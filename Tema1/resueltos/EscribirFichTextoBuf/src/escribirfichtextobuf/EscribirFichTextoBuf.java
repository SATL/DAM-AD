/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichtextobuf;

import java.io.*;

public class EscribirFichTextoBuf {
    public static void main(String[] args) {
        try{      
            BufferedWriter fichero = new BufferedWriter(new FileWriter("FichTexto.txt"));
            for (int i=1; i<11; i++){
                //escribe una linea
                fichero.write("Fila numero: "+i);
                //escribe un salto de linea
                fichero.newLine(); 
            }
            fichero.close();       
            System.out.println("El proceso ha finalizado.");
        }catch (FileNotFoundException fn ){                      
            System.out.println("No se encuentra el fichero");
        }catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
