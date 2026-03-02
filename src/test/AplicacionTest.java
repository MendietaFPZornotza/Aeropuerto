package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Piloto;
import app.Viajero;
import app.Vuelo;
import app.VueloCharter;

class AplicacionTest {

    @Test
    void testFlujoCompletoAplicacion() {

        // 1. Crear piloto
        Piloto piloto = new Piloto(
                "Iker",
                "Sanz",
                "789C",
                "P001",
                1500
        );

        // 2. Crear vuelo normal
        Vuelo vuelo = new Vuelo("IB300", piloto, 0, 120);

        // 3. Crear viajeros
        Viajero v1 = new Viajero("Ana", "Lopez", "111A", "Española");
        Viajero v2 = new Viajero("Lucia", "Garcia", "222B", "Francesa");

        // 4. Añadir viajeros al vuelo
        assertTrue(vuelo.agregarPasajero(v1));
        assertTrue(vuelo.agregarPasajero(v2));

        // 5. Comprobar número de pasajeros
        assertEquals(2, vuelo.getNumeroPasajeros());

        // 6. Comprobar precio total
        assertEquals(240, vuelo.obtenerPrecioVuelo());

        // 7. Comprobar salida por pantalla (toString)
        String salida = vuelo.toString();
        assertTrue(salida.contains("IB300"));
        assertTrue(salida.contains("Ana"));
        assertTrue(salida.contains("Lucia"));
        assertTrue(salida.contains("Piloto"));
    }

    @Test
    void testFlujoCompletoVueloCharter() {

        // 1. Crear piloto
        Piloto piloto = new Piloto(
                "Mikel",
                "Ruiz",
                "999Z",
                "P777",
                3000
        );

        // 2. Crear vuelo charter
        VueloCharter charter = new VueloCharter(
                "CH900",
                piloto,
                0,
                100,
                500
        );

        charter.setMaximoPasajeros(2);

        // 3. Añadir pasajeros
        assertTrue(charter.agregarPasajero(
                new Viajero("Jon", "Perez", "333C", "Española")));
        assertTrue(charter.agregarPasajero(
                new Viajero("Ane", "Martin", "444D", "Italiana")));

        // 4. Superar el máximo
        assertFalse(charter.agregarPasajero(
                new Viajero("Mark", "Smith", "555E", "Inglesa")));

        // 5. Comprobar precio con recargo
        assertEquals(700, charter.obtenerPrecioVuelo());

        // 6. Comprobar toString
        String salida = charter.toString();
        assertTrue(salida.contains("CH900"));
        assertTrue(salida.contains("Recargo Charter"));
    }
}