/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leerfichdata;

import java.io.*;
public class LeerFichData {
    public static void main(String[] args) throws IOException {    
        File fichero = new File("../EscribirFichData/FichData.dat");
        FileInputStream filein = new FileInputStream(fichero);   
        DataInputStream datain = new DataInputStream(filein);

        String n;
        int e;

        try {
            while (true) {
                n = datain.readUTF(); //recupera el nombre
                e = datain.readInt(); //recupera la edad
                System.out.println("Nombre: " + n + ", edad: " + e);        
            }
        }catch (EOFException eo) {
            // No hace nada. Ha llegado al final
        }

        //cerrar stream
        datain.close();     
    }
}
