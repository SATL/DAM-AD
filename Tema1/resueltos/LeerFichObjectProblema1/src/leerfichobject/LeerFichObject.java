/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leerfichobject;

import POJO.Persona;
import java.io.*;

public class LeerFichObject {
  
    public static void main(String[] args) throws IOException, ClassNotFoundException{ 
        //defino la variable persona
        Persona persona;   
        //declara el fichero
        File fichero = new File("../EscribirFichObjectProblema1/FichPersona.dat");
        //crea el flujo de entrada 
        FileInputStream filein = new FileInputStream(fichero);  
        //conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataout = new ObjectInputStream(filein);
   
        int i=1;
        try {
            //lectura del fichero
            while (true) { 
                //leer una Persona
                persona = (Persona) dataout.readObject();               
		System.out.println("Persona numero: " + i);		   
		System.out.println("Nombre: " + persona.getNombre() + ", edad: " + persona.getEdad());  
		i++;
            }
        }catch (EOFException eo) {
            // Como llega al final del fichero no se produce ningun error
        }catch (StreamCorruptedException x) {
            System.out.println("Error StreamCorruptedException");
            System.out.println(x.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
        //cerrar stream de entrada
        dataout.close();  
        System.out.println("El proceso ha terminado");
    }
}