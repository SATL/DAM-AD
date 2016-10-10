/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio2;

import java.util.Scanner;

/**
 *
 * @author eslem
 */
public class Ejercicio2 {

    public static String askStr(Scanner in) {
        System.out.println("Introduce la ruta");
        return in.next();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        GestionFicheros gf = new GestionFicheros("/");
        int resp = 0;
        while (resp != 7) {
            System.out.println("\n");
            System.out.println("1.-Asignar carpeta de trabajo");
            System.out.println("2.-Listado de la carpeta de trabajo");
            System.out.println("3.-Informacion detallada de un archivo");
            System.out.println("4.-Creacion de un directorio");
            System.out.println("5.-Creacion de un fichero");
            System.out.println("6.-Eliminacion de un fichero");
            System.out.println("7.-Salir");

            resp = in.nextInt();

            switch (resp) {
                case 1:
                    gf.setRoot(askStr(in));
                    break;
                case 2:
                    gf.listRoot();
                    break;
                case 3:
                    gf.listFile(askStr(in));
                    break;
                case 4:
                    gf.createDir(askStr(in));
                    break;
                case 5:
                    gf.createFile(askStr(in));
                    break;
                case 6:
                    gf.delFile(askStr(in));
                    break;
                case 7:
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;

            }
        }
    }
}
