package leerfichtextobuf;

import java.io.*;
public class LeerFichTextoBuf {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("./src/leerfichtextobuf/LeerFichTextoBuf.java");
	  
            BufferedReader br = new BufferedReader(fr); 

            String linea; 
            
            while((linea = br.readLine())!=null) 	 
                System.out.println(linea); 
    
            br.close(); 
        } catch (FileNotFoundException fn ){                      
            System.out.println("No se encuentra el fichero");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
