/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.StringTokenizer;

/**
 *
 * @author loren
 */
public class main {

    /**
     * @param args the command line arguments
     */
    static BufferedReader stdin = null;
    static File fichero = new File("socios.txt");    
    
    public static void main(String[] args) {
        
    
       
        stdin = new BufferedReader(new InputStreamReader(System.in));   
         
        try{
                        
            // TODO Auto-generated method stub
            int opcion = -1;

            while (opcion != 5) {
                showMenu();
                opcion = Integer.parseInt(stdin.readLine());
                    // Alta de socio
                if (opcion == 1) {
                    addSocio();
                    // Solicitamos la modificación de socio
                } else if (opcion == 2) {                        
                    modifySocio();
                    // Solicitamos el borrado de Socio
                } else if (opcion == 3) {
                    deleteSocio();
                    // Listar socios
                } else if (opcion == 4) {
                    listSocios();
                    // Salimos de la aplicacion
                } else if (opcion == 5) {
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Vista que muestra el menú en la pantalla principal
    public static void showMenu(){
        System.out.println();
        System.out.println("1.- Alta de socio en el sistema.");
        System.out.println("2.- Modificación de un socio en el sistema");
        System.out.println("3.- Borrado de socio en el sistema.");
        System.out.println("4.- Listar socios del sistema");
        System.out.println("5.- Salir.");
    }     
    
    public static String preguntarPorCadena(String pregunta) throws IOException{
        System.out.println(pregunta);        
        String salida = stdin.readLine();
        return salida;        
    }
    
    public static int preguntarPorEntero(String pregunta) throws IOException{
        System.out.println(pregunta);        
        int salida = Integer.parseInt(stdin.readLine());
        return salida;        
    } 
    
    public static float preguntarPorFloat(String pregunta) throws IOException{
        System.out.println(pregunta);        
        float salida = Float.parseFloat(stdin.readLine());
        return salida;        
    }    
    
    // Alta de socio en el sistema
    public static void addSocio() throws IOException{
        
        // A IMPLEMENTAR POR EL ALUMNO      
                
    }    
    
    // Modificacion de socio en el sistema
    public static void modifySocio() throws IOException{    
        
        // A IMPLEMENTAR POR EL ALUMNO      
               
    }
    
    // Borrado de socio en el sistema
    public static void deleteSocio() throws IOException{    
        
        // A IMPLEMENTAR POR EL ALUMNO      
               
    }
    
    // Listar socios
    public static void listSocios() {
        
        // A IMPLEMENTAR POR EL ALUMNO      
        
    }       
    
    // Metodo que nos permite copiar un fichero a otro
    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel origen = null;
        FileChannel destino = null;
        try {
            origen = new FileInputStream(sourceFile).getChannel();
            destino = new FileOutputStream(destFile).getChannel();

            long count = 0;
            long size = origen.size();              
            while((count += destino.transferFrom(origen, count, size-count))<size);
        }
        finally {
            if(origen != null) {
                origen.close();
            }
            if(destino != null) {
                destino.close();
            }
        }
    }   
    
}
