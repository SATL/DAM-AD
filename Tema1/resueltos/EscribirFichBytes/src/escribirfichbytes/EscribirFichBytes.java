/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichbytes;

import java.io.*;

public class EscribirFichBytes {
    public static void main(String[] args) throws IOException {   
        //declara fichero
        File fichero = new File("FichBytes.dat");
        //crea flujo de salida hacia el fichero: ESCRITURA
        FileOutputStream fileout = new FileOutputStream(fichero);   
        //crea flujo de entrada: LECTURA
        FileInputStream filein = new FileInputStream(fichero);   
        int i;

        //escribe datos en el flujo de salida
        for (i=1; i<100; i++)
            fileout.write(i);
   
        //cerrar stream de salida
        fileout.close();    
   
        //visualizar los datos del fichero
        //lee datos del flujo de entrada
        while ((i = filein.read()) != -1) 
            System.out.println(i);		
   
        //cerrar stream de entrada
        filein.close();   
    }
}
