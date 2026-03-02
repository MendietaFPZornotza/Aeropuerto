package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Piloto;

class PilotoTest {

    @Test
    void testConstructorVacio() {
        Piloto p = new Piloto();
        assertNotNull(p);
    }

    @Test
    void testConstructorConParametros() {
        Piloto p = new Piloto("Iker", "Sanz", "789C", "P001", 1500);

        assertEquals("Iker", p.getNombre());
        assertEquals("Sanz", p.getApellido());
        assertEquals("789C", p.getDNI());
        assertEquals("P001", p.getCodigoPiloto());
        assertEquals(1500, p.getHorasDeVuelo());
    }

    @Test
    void testGettersSetters() {
        Piloto p = new Piloto();
        p.setCodigoPiloto("P999");
        p.setHorasDeVuelo(3000);

        assertEquals("P999", p.getCodigoPiloto());
        assertEquals(3000, p.getHorasDeVuelo());
    }

    @Test
    void testToString() {
        Piloto p = new Piloto("Iker", "Sanz", "789C", "P001", 1500);
        String texto = p.toString();

        assertTrue(texto.contains("Iker Sanz (789C)"));
        assertTrue(texto.contains("CodigoPiloto=P001"));
        assertTrue(texto.contains("Horas=1500"));
    }
}
