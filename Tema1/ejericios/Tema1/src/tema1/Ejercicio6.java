/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author eslem
 */
public class Ejercicio6 {

    private static void createFile() throws FileNotFoundException, IOException {
        FileOutputStream fileout = new FileOutputStream("ejercicio6.data");
        DataOutputStream dos = new DataOutputStream(fileout);
        System.out.println("crando archivos");
        String out = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla faucibus magna ac neque consequat, et accumsan ex sagittis. Nulla ultricies eros a elementum pharetra.";

        for (int i = 0; i < out.length(); i++) {
            dos.writeChar((int) out.charAt(i));
        }

        fileout.close();
        dos.close();
    }

    public static void main(String[] args) throws IOException {
        createFile();

        System.out.println("Introduce el nombre del fichero");
        String name = new Scanner(System.in).next();
        try {

            DataInputStream dis = new DataInputStream(new FileInputStream(name));

            String data = "";
            try {
                while (true) {
                    char letter = dis.readChar();
                    data += letter == 'a' ? 'A' : letter;
                }
            } catch (EOFException e) {

            }
            System.out.println(data);
            String nameCopia = name + "Copia.txt";
            FileWriter fw = new FileWriter(nameCopia);
            fw.write(data);
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra ese archivo");
        }
    }
}
