/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio9;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eslem
 */
public class Ejercicio9Reader {

    Ejercicio9Reader() {
        ObjectInputStream inStream;
        Scanner in = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero:");
        FileInputStream fileStream;
        try {
            File file = new File(in.next());
            if (!file.exists()) {
                System.out.println("El archivo no existe");
                return;
            }
            fileStream = new FileInputStream(file);
            inStream = new ObjectInputStream(fileStream);
            try {
                while (true) {
                    System.out.println(((Alumno) inStream.readObject()).toString());
                }
            } catch (EOFException ex) {

            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");
        } catch (ClassNotFoundException ex) {
            System.out.println("El archivo no contiene objeto de la clase Alumno");
        }

    }

    public static void main(String[] args) {
        new Ejercicio9Reader();
    }
}
