import java.io.*;
public class EscribirFichTextoUnoUno {
  public static void main(String[] args) throws IOException {
   File fichero = new File("FichTexto.txt");//declara fichero          
   FileWriter fic = new FileWriter(fichero,true); //crear el flujo de salida       
   String cadena ="Esto es una prueba con FileWriter escribiendo uno a uno";
   char[] cad = cadena.toCharArray();//convierte un String en array de caracteres
	
   for(int i=0; i<cad.length; i++)
	   fic.write(cad[i]);  //se va escribiendo un caracter

   fic.append('\n'); //añado al final un *
   fic.close();    //cerrar fichero
   
   System.out.println("El proceso ha finalizado.");
  }
}
