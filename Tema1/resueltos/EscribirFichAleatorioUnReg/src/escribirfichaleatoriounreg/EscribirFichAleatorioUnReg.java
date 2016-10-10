/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirfichaleatoriounreg;

import java.io.*;
public class EscribirFichAleatorioUnReg {
    public static void main(String[] args) throws IOException {      
        File fichero = new File("../EscribirFichAleatorio/AleatorioEmple.dat");
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
   
        StringBuffer buffer = null;	//bufer para almacenar apellido 
   
        String apellido="GONZALEZ";
        Double salario=1230.87;
        int id=20;
        int dep=10;   
        long posicion = (id -1 ) * 36; 
     
        file.seek(posicion); //nos posicionamos 
        file.writeInt(id); //uso id para identificar empleado
        buffer = new StringBuffer( apellido);      
        buffer.setLength(10); //10 caracteres para el apellido
        file.writeChars(buffer.toString());//insertar apellido
        file.writeInt(dep);       //insertar departamento
        file.writeDouble(salario);//insertar salario
        
        file.close();  //cerrar fichero 
    }
}
