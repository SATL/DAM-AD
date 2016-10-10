package tema1.ejercicio1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eslem
 */
public class PeriodicoTest {
    
    Periodico periodico = new Periodico();
    
    public PeriodicoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        periodico.insertar(new Noticia(20160110, 0000, 80, "Noticia 1"));
        periodico.insertar(new Noticia(20160510, 0000, 1, "Noticia 2"));
        periodico.insertar(new Noticia(20160610, 0000, 1, "Noticia 3"));
        periodico.insertar(new Noticia(20160710, 0000, 2, "Noticia 4"));
        periodico.insertar(new Noticia(20160101, 0000, 4, "Noticia 5"));
        periodico.insertar(new Noticia(20160103, 0000, 5, "Noticia 6"));
        periodico.insertar(new Noticia(20150110, 0000, 20, "Noticia 7"));
        periodico.insertar(new Noticia(20140110, 0000, 30, "Noticia 8"));
        periodico.insertar(new Noticia(20160101, 0000, 80, "Noticia 9"));
    }
    
    @After
    public void tearDown() {
        periodico = new Periodico();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void insertar(){
        periodico.insertar(new Noticia(0, 0, 0, ""));
        assertSame(periodico.noticias.size(), 10);
    }
    
    @Test
    public void primeraNoticia(){
        Noticia noExist = periodico.primeraNoticia(1, 1, 2017);
        assertNull("No noticia 2017", noExist);
        
        Noticia primeraEnero = periodico.primeraNoticia(5, 1, 2016);
        assertEquals(20160110, primeraEnero.getData());
               
    }
    
     @Test
    public void populares(){
        periodico.masPopulares();
        
        //Noticia primeraEnero = periodico.primeraNoticia(5, 1, 2016);
        assertTrue(true);
               
    }
    
    
    private int convert(int a, int m, int d){
        int date = a*10000+m*100+d;
        return date;
    }
    
    @Test
    public void dateConvert(){
        int datea = 20160115;
        int conv = convert(2016, 01,15);
        
        assertEquals(datea, conv);
        
        int dateb = 20160101;
        int convb = convert(2016, 01, 01);
        
        assertEquals(dateb, convb);
    }
    
    @Test
    public void anteriores(){
        periodico.borrarAnteriores(5, 1, 2016);
        assertEquals(4, periodico.noticias.size());
    }
}
