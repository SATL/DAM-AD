import java.io.*;
public class VerDir {
public static void main(String[] args) {
  File f = new File(".");
  System.out.println("Archivos en el directorio actual: " + f.getAbsolutePath());  
  if (f.isDirectory()){
	  String[] archivos = f.list();
	  for (int i = 0; i < archivos.length; i++) {
		  System.out.println(archivos[i]);
	  }
  }
}

}

