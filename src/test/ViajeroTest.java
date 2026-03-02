package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Viajero;

class ViajeroTest {

    @Test
    void testConstructorVacio() {
        Viajero v = new Viajero();
        assertNotNull(v);
    }

    @Test
    void testConstructorConParametros() {
        Viajero v = new Viajero("Lucia", "Perez", "456B", "Española");

        assertEquals("Lucia", v.getNombre());
        assertEquals("Perez", v.getApellido());
        assertEquals("456B", v.getDNI());
        assertEquals("Española", v.getNacionalidad());
    }

    @Test
    void testSetGetNacionalidad() {
        Viajero v = new Viajero();
        v.setNacionalidad("Francesa");

        assertEquals("Francesa", v.getNacionalidad());
    }

    @Test
    void testToString() {
        Viajero v = new Viajero("Lucia", "Perez", "456B", "Española");
        String texto = v.toString();

        assertTrue(texto.contains("Lucia Perez (456B)"));
        assertTrue(texto.contains("Nacionalidad=Española"));
    }
}