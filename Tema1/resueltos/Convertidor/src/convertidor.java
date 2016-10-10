import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class convertidor {
 public static void main(String argv[]) throws IOException{ 
	 String hojaEstilo = "alumnosPlantilla.xsl";
	 String datosAlumnos = "alumnos.xml";
	 // Fichero HTML
	 File pagHTML = new File("mipagina.html");
	 // Flujo de salida para la creacion del fichero
	 FileOutputStream os = new FileOutputStream(pagHTML);
  
	 // Fuente de la hoja de estilos
	 Source estilos =new StreamSource(hojaEstilo);
	 // Fuente de los datos
	 Source datos =new StreamSource(datosAlumnos);
	 // Resultado de la transformacion
	 Result result = new StreamResult(os);
  
	 try{     
		 Transformer transformer =  
               TransformerFactory.newInstance().newTransformer(estilos); 
		  //obtiene el HTML
		 transformer.transform(datos, result);
	 }catch(Exception e){
		 System.err.println("Error: "+e);
	 }
  
  os.close();  //cerrar fichero 	
 }//de main
}//de la clase
