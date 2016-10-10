/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leerfichtexto20;

import java.io.*;

public class LeerFichTexto20 {
    public static void main(String[] args) throws IOException {
        //declarar fichero que vamos a leer (en este caso el mismo fichero fuente del programa)
        File fichero = new File("./src/leerfichtexto20/LeerFichTexto20.java");
        
        //crear el flujo de entrada
        FileReader fileReader = new FileReader(fichero); 
        
        int i;
        char b[] = new char[22];
        //se va leyendo un caracter
        while ((i = fileReader.read(b)) != -1) 
            System.out.println(b);
        
        //cerrar fichero   
        fileReader.close(); 
    }
}