/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leerfichaleatorio;

import java.io.*;
public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {     
        File fichero = new File("../EscribirFichAleatorio/AleatorioEmple.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int  id, dep, posicion;    
        Double salario;	
        char apellido[] = new char[10], aux;	
   
        posicion=0;
        for(;;){  //recorro el fichero
            file.seek(posicion); //nos posicionamos 0	
            id=file.readInt();   // obtengo id de empleado	  	  
	
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                apellido[i] = aux;
            }     
            String apellidos = new String(apellido);//convierto a String el array
            dep=file.readInt();//obtengo dep
            salario=file.readDouble();  //obtengo salario
	  
            System.out.println("ID: " + id + ", Apellido: "+  apellidos.trim() + 
	                     ", Departamento: "+dep + ", Salario: " + salario);    
            // Aumentamos la posicion
            posicion = posicion + 36;
            //Si he recorrido todos los bytes salgo del for	 	  
            if (file.getFilePointer()==file.length())break;
   
        }//fin bucle for 
        file.close();  //cerrar fichero 
    }
}

