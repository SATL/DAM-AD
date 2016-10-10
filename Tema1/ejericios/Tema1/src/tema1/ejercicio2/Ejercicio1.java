/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eslem
 */
public class Ejercicio1 {

    Scanner in = new Scanner(System.in);
    File root = new File("/");

    private void detail(File f) {
        if (f.exists()) {
            System.out.println("Nombre del fichero  : " + f.getName());
            System.out.println("Ruta                : " + f.getPath());
            System.out.println("Ruta absoluta       : " + f.getAbsolutePath());
            System.out.println("Se puede escribir   : " + f.canRead());
            System.out.println("Se puede leer       : " + f.canWrite());
            System.out.println("Tamaño              : " + f.length());
            System.out.println("Es un directorio    : " + f.isDirectory());
            System.out.println("Es un fichero       : " + f.isFile());
        }
    }

    private void list(File f) {
        System.out.println("Archivos en el directorio: " + f.getAbsolutePath());
        if (f.isDirectory()) {
            String[] archivos = f.list();
            for (String file : archivos) {
                System.out.println(file);
            }
        }
    }

    private String askStr() {
        System.out.println("Introduce la ruta");
        return in.next();
    }

    private File getValidFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        } else {
            System.out.println("Error: no es una ruta valida");
            return null;
        }
    }

    public void listRoot() {
        list(root);
    }

    public void setRoot() {
        File newRoot = getValidFile(askStr());
        if (newRoot != null) {
            root = newRoot;
            System.out.println("Carpeta de trabajo modificada correctamente");
        }
    }

    public void listFile() {
        File file = getValidFile(askStr());
        if (file != null) {
            detail(file);
        }
    }

    public void createDir() {
        File dir = new File(root, askStr());
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Carpeta creada correctamente");
        } else {
            System.out.println("La carpeta ya existe");
        }
    }

    public void createFile() {
        File file = new File(root, askStr());
        try {
            if (file.createNewFile()) {
                System.out.println("Fichero creado correctamente");
            } else {
                System.out.println("No se ha podido crear el archivo");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void delFile() {
        File file = getValidFile(askStr());
        if (file.delete()) {
            System.out.println("Fichero eliminado correctamente");
        } else {
            System.out.println("No se ha podido eliminar el archivo");
        }
    }

    private void menuToString() {

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
                    setRoot();
                    break;
                case 2:
                    listRoot();
                    break;
                case 3:
                    listFile();
                    break;
                case 4:
                    createDir();
                    break;
                case 5:
                    createFile();
                    break;
                case 6:
                    delFile();
                    break;
                case 7:
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;

            }

        }

    }

    Ejercicio1() {
        menuToString();
    }

    public static void main(String[] args) {
        Ejercicio1 ejer = new Ejercicio1();
    }

}
