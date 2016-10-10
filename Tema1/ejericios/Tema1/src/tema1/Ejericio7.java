/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author eslem
 */
public class Ejericio7 {

    Scanner in = new Scanner(System.in);

    private String askString() {

        return in.nextLine();
    }

    private void readFile(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bf = new BufferedReader(fileReader);
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }

            fileReader.close();
        } else {
            System.out.println("El fichero no existe");
        }

    }

    private void writeFile(String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        System.out.println("Introduce el texto a guardar");
        fw.write(askString());
        fw.close();
    }

    Ejericio7() throws IOException {
        int resp = 0;
        while (resp != 4) {
            System.out.println("1.- Leer desde teclado");
            System.out.println("2.- Leer desde fichero");
            System.out.println("3.- Escribir en fichero");
            System.out.println("4.- Fin");

            resp = in.nextInt();
            in.nextLine();
            switch (resp) {
                case 1:
                    String frase = askString();
                    System.out.println(frase + "\n Gracias por la frase");
                    break;
                case 2:
                    System.out.println("Introduce la ruta del fichero");
                    readFile(askString());
                    break;
                case 3:
                    System.out.println("Introduce la ruta del fchero");
                    writeFile(askString());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion erronea");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Ejericio7();
    }
}
