/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio10;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tema1.AppendableObjectOutputStream;

/**
 *
 * @author eslem
 */
public class Agenda {

    List<Contacto> contactos;
    File file;

    public Agenda(int max) {
        contactos = new ArrayList<>(max);
    }

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void createFile(String name) {
        file = new File(name);
    }

    public void openFile(String name) {
        file = new File(name);
        if (!file.exists()) {
            System.out.println("no existe ese archivo");
            return;
        }
        try {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fin);
            try {
                contactos = new ArrayList<>();
                while (true) {
                    contactos.add((Contacto) ois.readObject());
                }
            } catch (EOFException ex) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }

            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede leer el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error leyendo el archivo");
        }
    }

    public void saveFile() {
        if (file == null) {
            return;
        }
        try {
            //no funciona si sobreescribe
            //AppendableObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(file, true));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            contactos.stream().forEach(x -> {
                try {
                    oos.writeUnshared(x);
                } catch (IOException ex) {
                    System.out.println("Error escribiendo en el archivo");
                }
            });

            oos.close();
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");
        }
    }

    //Al no poder sobreescribir guardo el array entero
    public void saveContact(Contacto contact) {
        if (file == null) {
            return;
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
            oos.writeObject(contact);
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");
        }
    }

    public void add(Contacto contacto) {
        contactos.add(contacto);
        if (file != null) {
            saveContact(contacto);
        }
    }

    public void showAll() {
        contactos.stream().forEach(contacto -> System.out.println(contacto.toString()));

    }

    public Contacto seachByName(String name) {
        return contactos.stream().filter(x -> x.getNombre().equals(name)).findAny().orElse(null);
    }

    public Contacto seachByAdress(String address) {
        return contactos.stream().filter(x -> x.getDireccion().equals(address)).findAny().orElse(null);
    }

    public Contacto seachByPhone(int phone) {
        return contactos.stream().filter(x -> x.getTelefono() == phone).findAny().orElse(null);
    }

    public Contacto deleteByPhone(int phone) {
        Contacto contacto = contactos.stream().filter(x -> x.getTelefono() == phone).findAny().orElse(null);
        if (contacto != null) {
            contactos.remove(contacto);
        }
        return contacto;
    }

    public boolean editPhone(String name, int phone) {
        Contacto contacto = seachByName(name);
        if (contacto != null) {
            contacto.setTelefono(phone);
            return true;
        }

        return false;
    }

    public int getSize() {
        return contactos.size();
    }

}
