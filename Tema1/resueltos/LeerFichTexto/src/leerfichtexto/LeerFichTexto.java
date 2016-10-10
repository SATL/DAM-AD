/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leerfichtexto;

import java.io.*;

public class LeerFichTexto {
  public static void main(String[] args) throws IOException {
    //declarar fichero que vamos a leer (en este caso el mismo fichero fuente del programa)
    File fichero = new File("./src/leerfichtexto/LeerFichTexto.java");
    
    //crear el flujo de entrada             
    FileReader fileReader = new FileReader(fichero); 
    
    int i;
    //se va leyendo un caracter
    while ((i = fileReader.read()) != -1) 
        System.out.println((char) i);
    
    //cerrar flujo de entrada
    fileReader.close();  
  }
}
