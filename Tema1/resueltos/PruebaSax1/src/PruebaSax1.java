import java.io.*;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class PruebaSax1 {		
	public static void main(String[] args) 
		throws FileNotFoundException, IOException, SAXException {		
		
		// Creacion del procesador de XML (el parser). Se produce una excepcion debido a que
		// no se indica que version de SAX se va a utilizar, sino que se utiliza
		// la que tiene el sistema por defecto.
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		
		// Otra posibilidad hubiera sido la siguiente:
		// XMLReader procesadorXML = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
		
		// Instanciamos la clase que realizará el tratamiento al fichero XML
		GestionContenido gestor= new GestionContenido();  
		// Asignamos el objeto creado para tratar los eventos que ocurren dentro del documento
		procesadorXML.setContentHandler(gestor);
		
		// Creamos una fuente de entrada a partir del fichero XML
		InputSource fileXML = new InputSource("alumnos.xml");	
		// Lanzamos el parseador
		procesadorXML.parse(fileXML); 
		Vector alumnos = gestor.v;
		System.out.println(alumnos);
	}
}//fin PruebaSax1

