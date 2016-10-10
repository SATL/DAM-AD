/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eslem
 */
public class Ejercicio1 {

    private static void loadPeriodico() throws FileNotFoundException, IOException {
        File file = new File("periodico.txt");
        if (file.exists()) {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine().split("#")[0];
            System.out.println("Bienvenido a " + data);
            br.close();
            file.delete();
        }
    }

    private static void loadNoticias(Periodico periodico) throws FileNotFoundException, IOException {
        File file = new File("noticias.txt");
        if (file.exists()) {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("#");
                int fecha = Integer.parseInt(data[0]);
                int hora = Integer.parseInt(data[1]);
                int lecturas = Integer.parseInt(data[2]);
                Noticia noticia = new Noticia(fecha, hora, lecturas, data[3]);
                periodico.insertar(noticia);
            }
            br.close();
            file.delete();
        }
    }

    private static void saveFile(Periodico periodico, String name) throws IOException {
        FileWriter fw = new FileWriter("periodico.txt");
        fw.write(name + "#" + periodico.numNoticias);
        fw.close();
        saveNoticias(periodico);
    }

    private static void saveNoticias(Periodico periodico) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("noticias.txt"));
        periodico.noticias.stream().forEach(x -> {
            try {
                bw.write(x.toFile());
                bw.newLine();
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int resp = -1;
        Periodico periodico = new Periodico();
        loadPeriodico();
        loadNoticias(periodico);
        while (resp != 0) {
            System.out.println("1.- Crear nueva noticia");
            System.out.println("2.- Ver todas noticias");
            System.out.println("3.- Mas populares");
            System.out.println("4.- Primera noticia");
            System.out.println("5.- Borrar anteriores");
            System.out.println("0.- Salir");

            resp = in.nextInt();
            switch (resp) {
                case 0:
                    break;
                case 1:
                    System.out.println("fecha:");
                    int fecha = in.nextInt();
                    System.out.println("hora:");
                    int hora = in.nextInt();
                    System.out.println("lecturas:");
                    int lecturas = in.nextInt();
                    in.nextLine();
                    System.out.println("texto:");
                    String texto = in.nextLine();
                    periodico.insertar(new Noticia(fecha, hora, lecturas, texto));
                    break;
                case 2:
                    periodico.verTodas();
                    break;
                case 3:
                    periodico.masPopulares();
                    break;
                case 4:
                    System.out.println("año:");
                    int año = in.nextInt();
                    System.out.println("mes");
                    int mes = in.nextInt();
                    System.out.println("dia");
                    int dia = in.nextInt();
                    Noticia noticia = periodico.primeraNoticia(dia, mes, año);
                    if (noticia != null) {
                        System.out.println(noticia.toString());
                    }
                    break;
                case 5:
                    System.out.println("año:");
                    int a = in.nextInt();
                    System.out.println("mes:");
                    int m = in.nextInt();
                    System.out.println("dia:");
                    int d = in.nextInt();
                    periodico.borrarAnteriores(d, m, a);
                    break;
                default:
                    System.out.println("Opcion erronea");
            }
        }

        System.out.println("Desea guardar? (y/n)");

        if ("y".equals(in.next())) {
            System.out.println("Nombre del periodico");
            String nombre = in.next();
            saveFile(periodico, nombre);
        }
    }
}
