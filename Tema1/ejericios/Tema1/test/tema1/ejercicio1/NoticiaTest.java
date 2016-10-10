/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio1;

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
public class NoticiaTest {

    public NoticiaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void dateTest() {
        //Date 20160112
        Noticia noticia = new Noticia(20160130, 945, 5, "Text");

        assertTrue(noticia.igualData(30, 01, 2016));
    }

    @Test
    public void stringTest() {
        //Date 20160112
        Noticia noticia = new Noticia(20160130, 945, 5, "Text");
        String s = "";
        s += "30/1/2016 - 9:45\n";
        s += "Text\n";
        s += "Leida 5 veces\n";
        assertEquals(noticia.toString(), s);
    }

}
