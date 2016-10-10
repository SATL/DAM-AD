import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class GestionContenido extends DefaultHandler{	 
		public Vector v;
		private Alumno a;
		private String dondeEstoy;
		
		// Constructor del gestor
	    public GestionContenido(){
	    	super();
	    	v = new Vector();
	    }
	    
	    // Salta cuando encuentra el inicio del documento
	    public void startDocument() {
	        System.out.println("Inicio de la carga del fichero XML con SAX.");
	    }
	    
	    // Salta cuando encuentra el fin del documento
	    public void endDocument() {
	        System.out.println("Fin de la carga del fichero XML con SAX.");
	    }	 
	    
	    // Salta cuando encuentra un inicio de elemento
	    public void startElement(String uri, String nombre,
	              String nombreC, Attributes atts) {
	    	dondeEstoy=nombre;
	    	if (nombre.equals("alumno")){
	    		a = new Alumno();
	    	}
	        System.out.println("\tPrincipio Elemento: " + nombre);	 	        
	    } 
	
	    // Salta cuando encuentra un fin de elemento
	    public void endElement(String uri, String nombre,
	                                 String nombreC){
	    		System.out.println("\tFin Elemento: " + nombre);
	    		dondeEstoy = "/" + nombre;
	    		if (dondeEstoy.equals("/alumno")){
	    			v.add(a);
	    		}
	    }
		
	    // Salta cuando encuentra valores que se encuentran entre una etiqueta
	    // de inicio y una de fin
		public void characters(char[] ch, int start, int length){
		   String car=new String(ch, start, length);
		   car = car.replaceAll("[\t\n]","");//quitar saltos de linea		   
		   System.out.println ("\tCaracteres: " + car);	
		   if (dondeEstoy.equals("nombre")){
			   a.setNombre(car);
		   }else if (dondeEstoy.equals("edad")){
			   a.setEdad(Integer.parseInt(car));
		   }
	    }
}//fin GestionContenido