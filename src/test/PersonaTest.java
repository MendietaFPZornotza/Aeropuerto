package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Persona;

class PersonaTest {

    @Test
    void testConstructorVacio() {
        Persona p = new Persona();
        assertNotNull(p);
    }

    @Test
    void testConstructorConParametros() {
        Persona p = new Persona("Jon", "Lopez", "123A");
        assertEquals("Jon", p.getNombre());
        assertEquals("Lopez", p.getApellido());
        assertEquals("123A", p.getDNI());
    }

    @Test
    void testGettersSetters() {
        Persona p = new Persona();
        p.setNombre("Ane");
        p.setApellido("Garcia");
        p.setDNI("999Z");

        assertEquals("Ane", p.getNombre());
        assertEquals("Garcia", p.getApellido());
        assertEquals("999Z", p.getDNI());
    }

    @Test
    void testToString() {
        Persona p = new Persona("Jon", "Lopez", "123A");
        assertEquals("Jon Lopez (123A)", p.toString());
    }
}
