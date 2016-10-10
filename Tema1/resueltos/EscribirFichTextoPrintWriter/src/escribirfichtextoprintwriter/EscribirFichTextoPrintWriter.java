/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichtextoprintwriter;

import java.io.*;

public class EscribirFichTextoPrintWriter {
    public static void main(String[] args) {
        try{      
            PrintWriter  fichero = new PrintWriter (new FileWriter("FicTexto2.txt"));      
            for (int i=1; i<11; i++)
                fichero.println("Fila numero: "+i);	  		
     
            fichero.close(); 
        }catch (FileNotFoundException fn ){                      
            System.out.println("No se encuentra el fichero");
        }catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
