/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejericio8;

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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eslem
 */
public class Ejercicio8 {

    Scanner in = new Scanner(System.in);
    List<Vehiculo> vehiculos;

    String filename = "vehiculo.bin";

    Ejercicio8() throws ClassNotFoundException {
        vehiculos = new ArrayList<>();
        readFile();
        int resp = 0;
        while (resp != 3) {
            System.out.println("1.- Insertar vehiculo");
            System.out.println("2.- Visualizar vehiculos");
            System.out.println("3.- Salir");

            resp = in.nextInt();
            in.nextLine();
            switch (resp) {
                case 1:
                    vehiculos.add(new Vehiculo(in));
                    saveBin();
                    break;
                case 2:
                    printVehiculos();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion erronea");
            }
        }
    }

    public void printVehiculos() {
        vehiculos.stream().forEach((i) -> {
            System.out.println(i.toString());
        });
    }

    private void readFile() throws ClassNotFoundException {
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(filename));
            try {
                while (true) {
                    vehiculos.add((Vehiculo) oos.readObject());
                }
            } catch (EOFException ex) {
                oos.close();
            }
        } catch (IOException ex) {
        }
    }

    private void saveBin() {
        try {
            FileOutputStream fin = new FileOutputStream(new File(filename), true);
            ObjectOutputStream oos = new ObjectOutputStream(fin);

            vehiculos.stream().forEach((i)
                    -> {
                try {
                    oos.writeObject(i);
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
             
            oos.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new Ejercicio8();
    }
}
