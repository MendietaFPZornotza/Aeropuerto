package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Piloto;
import app.Viajero;
import app.VueloCharter;

class VueloCharterTest {

    private VueloCharter vuelo;



    @Test
    void testAgregarPasajerosHastaMaximo() {
        vuelo.setMaximoPasajeros(2);

        assertTrue(vuelo.agregarPasajero(new Viajero("A", "A", "1", "ES")));
        assertTrue(vuelo.agregarPasajero(new Viajero("B", "B", "2", "FR")));
        assertFalse(vuelo.agregarPasajero(new Viajero("C", "C", "3", "IT")));
    }

    @Test
    void testPrecioVueloCharter() {
        vuelo.agregarPasajero(new Viajero("A", "A", "1", "ES"));
        vuelo.agregarPasajero(new Viajero("B", "B", "2", "FR"));

        assertEquals(700, vuelo.obtenerPrecioVuelo());
        
    }

    @Test
    void testToStringIncluyeRecargo() {
        String texto = vuelo.toString();
        assertTrue(texto.contains("Recargo Charter"));
    }
}
