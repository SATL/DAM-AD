/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichobject;

import POJO.Persona;
import java.io.*;
import util.AppendableObjectOutputStream;

public class EscribirFichObject {
  
    public static void main(String[] args) throws IOException {   
   
        //defino variable persona
        Persona persona = null;
        //declara el fichero
        File fichero = new File("FichPersona.dat");
        //crea el flujo de salida
        FileOutputStream fileout = new FileOutputStream(fichero);  
        //conecta el flujo de bytes al flujo de datos
        ObjectOutputStream dataout = null;
        dataout = new ObjectOutputStream(fileout);
        /** SOLUCION
        if (!fichero.exists()){
            dataout = new ObjectOutputStream(fileout);
        }else{
            dataout = new AppendableObjectOutputStream(fileout);
        }
        */
        
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
        //cerrar stream de salida
        dataout.close();       
        
        // Añadimos de nuevo creando otra vez la cabecera

        //crea el flujo de salida
        fileout = new FileOutputStream(fichero,true);  
        
        dataout = new ObjectOutputStream(fileout);
        /** SOLUCION
        // La segunda vez que añade los datos utilizamos la nueva clase
        dataout = new AppendableObjectOutputStream(fileout);  
	*/
                
        //recorro los arrays
        for (int i=0;i<edades.length; i++){     
            //creo la persona
            persona = new Persona(nombres[i],edades[i]); 	  
            //escribo la persona en el fichero
            dataout.writeObject(persona); 
            dataout.reset();
        }     
        //cerrar stream de salida
        dataout.close();        
        System.out.println("El proceso ha terminado.");
    }
}
