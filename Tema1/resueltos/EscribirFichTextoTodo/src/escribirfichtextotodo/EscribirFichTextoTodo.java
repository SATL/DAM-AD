/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichtextotodo;

import java.io.*;
public class EscribirFichTextoTodo {
    public static void main(String[] args) throws IOException {
        //declara fichero
        File fichero = new File("FichTexto.txt");
        //crear el flujo de salida
        FileWriter fic = new FileWriter(fichero);        
        String cadena ="Esto es una prueba con FileWriter todo de golpe";
        
        //convierte un String en array de caracteres
        char[] cad = cadena.toCharArray();
	
        //se escribe todo de golpe
        fic.write(cad);  

        //añado al final un *
        fic.append('*'); 
        //añado al final un salto de linea
        fic.append('\n'); 
                
        //cerrar fichero
        fic.close();    
   
        System.out.println("El proceso ha finalizado.");
    }
}
