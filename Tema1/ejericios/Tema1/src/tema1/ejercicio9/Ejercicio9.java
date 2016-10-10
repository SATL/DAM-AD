/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eslem
 */
public class Ejercicio9 {

    Scanner in = new Scanner(System.in);
    ObjectOutputStream outStream;

    Ejercicio9() {
        startFile();
        askAlumno();

        String resp = "";
        while (!"n".equals(resp)) {
            System.out.println("¿Introducir otro alumno? (s/n)");
            resp = in.next();
            if ("s".equals(resp)) {
                askAlumno();
            } else if (!"n".equals(resp)) {
                System.out.println("option no valida");
            }
        }

        try {
            outStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startFile() {
        System.out.println("Introduce el nombre del fichero:");
        String name = in.next();
        try {
            FileOutputStream fileStream = new FileOutputStream(name, true);
            outStream = new ObjectOutputStream(fileStream);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra ese fichero");
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void askAlumno() {
        System.out.println("DNI:");
        int dni = in.nextInt();
        System.out.println("Nota primer parcial");
        double nota = in.nextDouble();
        System.out.println("Nota segundo parcial");
        double nota2 = in.nextDouble();

        try {
            Alumno alumno = new Alumno(dni, nota, nota2);
            outStream.writeObject(alumno);
        } catch (IOException ex) {
            System.out.println("Error guardando alumno");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new Ejercicio9();
    }
}
