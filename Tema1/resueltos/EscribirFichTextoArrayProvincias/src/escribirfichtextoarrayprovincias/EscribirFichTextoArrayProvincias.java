/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichtextoarrayprovincias;

import java.io.*;
public class EscribirFichTextoArrayProvincias {
    public static void main(String[] args) throws IOException {
        //declara fichero
        File fichero = new File("FichProvincias.txt");  
        //crear el flujo de salida
        FileWriter fic = new FileWriter(fichero);     
   
        String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen",
                        "Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
        
	//se ha añadido el salto de linea
        for(int i=0; i<prov.length; i++)
            fic.write(prov[i] + "\n");  

        //cerrar fichero
        fic.close();    
   
        System.out.println("El proceso ha finalizado.");
    }
}
