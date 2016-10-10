/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichobject;

import POJO.Persona;
import java.io.*;

public class EscribirFichObject {
  
    public static void main(String[] args) throws IOException {   
   
        //defino variable persona
        Persona persona = null;
        //declara el fichero
        File fichero = new File("FichPersona.dat");
        //crea el flujo de salida
        FileOutputStream fileout = new FileOutputStream(fichero,true);  
        //conecta el flujo de bytes al flujo de datos
        ObjectOutputStream dataout = new ObjectOutputStream(fileout);  
   
        String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres",
                            "Julio","Antonio","Maria Jesus"};
					   
        int edades[] = {14,15,13,15,16,12,16,14,13};
	
        //recorro los arrays
        for (int i=0;i<edades.length; i++){     
            //creo la persona
            persona = new Persona(nombres[i],edades[i]); 	  
            //escribo la persona en el fichero
            dataout.writeObject(persona); 
            dataout.reset();
        }     
        // escribimos la ultima persona de nuevo cambiandole la edad
        persona.setEdad(21);
        dataout.writeObject(persona); 
        //cerrar stream de salida
        dataout.close();       
        System.out.println("El proceso ha terminado.");
    }
}
