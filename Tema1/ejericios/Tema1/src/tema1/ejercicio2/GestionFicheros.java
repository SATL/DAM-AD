/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author eslem
 */
public class GestionFicheros {

    private File root = new File("/");

    GestionFicheros(String root) {
        setRoot(root);
    }

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

    public void setRoot(String str) {
        File newRoot = getValidFile(str);
        if (newRoot != null) {
            root = newRoot;
            System.out.println("Carpeta de trabajo modificada correctamente");
        }
    }

    public void listFile(String str) {
        File file = getValidFile(str);
        if (file != null) {
            detail(file);
        }
    }

    public void createDir(String str) {
        File dir = new File(root, str);
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Carpeta creada correctamente");
        } else {
            System.out.println("La carpeta ya existe");
        }
    }

    public void createFile(String str) {
        File file = new File(root, str);
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

    public void delFile(String str) {
        File file = getValidFile(str);
        if (file.delete()) {
            System.out.println("Fichero eliminado correctamente");
        } else {
            System.out.println("No se ha podido eliminar el archivo");
        }
    }
}
