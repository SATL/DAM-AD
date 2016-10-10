/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eslem
 */
public class Ejericio4 {

    private static void saveNumber(int a, int b) {
        File file = new File("ejercicio1.data");
        try {
            FileOutputStream fileout = new FileOutputStream(file);
            fileout.write(a+b);
            fileout.write(a-b);
            fileout.write(a*b);
            
            fileout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejericio4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejericio4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int getNum() {
        File file = new File("ejercicio1.data");
        int i = 0;

        try {
            FileInputStream fsin = new FileInputStream(file);
            while ((i = fsin.read()) != -1) {
                System.out.println(i);
            }
            
            fsin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejericio4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejericio4.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el primer numero");
        int a = in.nextInt();
        System.out.println("Introduce el segundo numero");
        int b = in.nextInt();

        saveNumber(a, b);

        getNum();
    }
}
