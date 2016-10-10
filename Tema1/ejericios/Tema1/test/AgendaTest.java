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
import tema1.ejercicio10.Agenda;
import tema1.ejercicio10.Contacto;

/**
 *
 * @author eslem
 */
public class AgendaTest {

    public Agenda agenda;

    public AgendaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        agenda = new Agenda();

        agenda.add(new Contacto("nombre 1", "direccion 1", "cp1", 1));
        agenda.add(new Contacto("nombre 2", "direccion 2", "cp2", 2));
        agenda.add(new Contacto("nombre 3", "direccion 3", "cp3", 3));
        agenda.add(new Contacto("nombre 4", "direccion 4", "cp4", 4));
        agenda.add(new Contacto("nombre 5", "direccion 5", "cp5", 5));
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
    public void add() {
        agenda.add(new Contacto("", "", "", 1));
        assertEquals(6, agenda.getSize());
    }

    @Test
    public void sarchName() {
        Contacto contacto = agenda.seachByName("nombre 1");
        Contacto contactox = agenda.seachByName("nombre x");

        assertEquals(1, contacto.getTelefono());
        assertNull(contactox);
    }
    
    @Test
    public void editByName() {
        assertTrue(agenda.editPhone("nombre 1", 0));
        assertFalse(agenda.editPhone("nombre x", 0));
        
        Contacto contacto = agenda.seachByName("nombre 1");
        assertEquals(0, contacto.getTelefono());
    }

    @Test
    public void sarchPhone() {
        Contacto contacto = agenda.seachByPhone(1);
        Contacto contactox = agenda.seachByPhone(1231);

        assertEquals("nombre 1", contacto.getNombre());
        assertNull(contactox);
    }

    @Test
    public void deletePhone() {
        Contacto contacto = agenda.deleteByPhone(1);
        Contacto contactox = agenda.deleteByPhone(1231);

        assertEquals("nombre 1", contacto.getNombre());
        assertNull(contactox);
        
        assertEquals(4, agenda.getSize());
    }
}
