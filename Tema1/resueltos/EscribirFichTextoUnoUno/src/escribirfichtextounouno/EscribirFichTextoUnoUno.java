/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichtextounouno;

import java.io.*;

public class EscribirFichTextoUnoUno {
    public static void main(String[] args) throws IOException {
        //declara fichero 
        File fichero = new File("FichTexto.txt");         
        //crear el flujo de salida
        FileWriter fic = new FileWriter(fichero,true);        
        String cadena ="Esto es una prueba con FileWriter escribiendo uno a uno";
        
        //convierte un String en array de caracteres
        char[] cad = cadena.toCharArray();
	
        //se va escribiendo un caracter
        for(int i=0; i<cad.length; i++)
            fic.write(cad[i]);  

        //añado al final un *
        fic.append('*'); 
        //añado al final un salto de linea
        fic.append('\n'); 
        
        //cerrar fichero
        fic.close();    
   
        System.out.println("El proceso ha finalizado.");
    }
}
