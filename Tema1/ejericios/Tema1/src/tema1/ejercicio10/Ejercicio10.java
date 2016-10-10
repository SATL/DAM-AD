/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio10;

import java.util.Scanner;
import tema1.ejericio8.Vehiculo;

/**
 *
 * @author eslem
 */
public class Ejercicio10 {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner in = new Scanner(System.in);
        int resp = -1;
        while (resp != 0) {
            System.out.println("1.- Crear nueva agenda");
            System.out.println("2.- Abrir agenda");
            System.out.println("3.- Crear contacto");
            System.out.println("4.- Buscar contacto por nombre");
            System.out.println("5.- Buscar contacto por numero");
            System.out.println("6.- Borrar telefono");
            System.out.println("7.- Modificar telefono");
            System.out.println("8.- Mostrar todos los contactos");
            System.out.println("0.- Salir");

            resp = in.nextInt();
            switch (resp) {
                case 0:
                    break;
                case 1:
                    System.out.println("Nombre del archivo");
                    agenda.createFile(in.next());
                    break;
                case 2:
                    System.out.println("Nombre del archivo");
                    agenda.openFile(in.next());
                    break;
                case 3:
//For skipping
                    in.nextLine();
                    agenda.add(new Contacto(in));
                    break;
                case 4:
                    System.out.println("Nombre");

                    in.nextLine();
                    Contacto contacto = agenda.seachByName(in.nextLine());
                    if (contacto == null) {
                        System.out.println("No se encuentra ese contacto");
                    } else {
                        System.out.println(contacto.toString());
                    }
                    break;
                case 5:
                    System.out.println("Numero");
                    Contacto contactox = agenda.seachByPhone(in.nextInt());
                    if (contactox == null) {
                        System.out.println("No se encuentra ese contacto");
                    } else {
                        System.out.println(contactox.toString());
                    }
                    break;
                case 6:
                    Contacto contactoy = agenda.deleteByPhone(in.nextInt());
                    if (contactoy == null) {
                        System.out.println("No se encuentra ese contacto");
                    } else {
                        System.out.println("Contacto eliminado conrrectamente");
                    }
                    break;
                case 7:
                    boolean modified = agenda.editPhone(in.nextLine(), in.nextInt());
                    if (modified) {
                        System.out.println("Contacto modificado conrrectamente");
                    } else {
                        System.out.println("No se encuentra ese contacto");
                    }
                    break;
                case 8:
                    agenda.showAll();
                    break;
                default:
                    System.out.println("Opcion erronea");
            }
        }
        
        agenda.saveFile();
    }
}
