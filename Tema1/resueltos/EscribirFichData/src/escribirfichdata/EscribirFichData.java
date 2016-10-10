/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichdata;

import java.io.*;

public class EscribirFichData {
    public static void main(String[] args) throws IOException {   
 
        File fichero = new File("FichData.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);   
        DataOutputStream dataout = new DataOutputStream(fileout);
 
        String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres",
                            "Julio","Antonio","Maria Jesus"};
					   
        int edades[] = {14,15,13,15,16,12,16,14,13};
	
        for (int i=0;i<edades.length; i++){
            dataout.writeUTF(nombres[i]); //inserta nombre
            dataout.writeInt(edades[i]);  //inserta edad
        }     
   
        //cerrar stream
        dataout.close();   
   
        System.out.println("El proceso ha terminado.");
    }
}
