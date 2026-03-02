package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Piloto;
import app.Viajero;
import app.Vuelo;

/**class VueloTest {

    private Vuelo vuelo;
    private Piloto piloto;

    @BeforeEach
    void setUp() {
        piloto = new Piloto("Iker", "Sanz", "789C", "P001", 1500);
        vuelo = new Vuelo("IB100", piloto, 0, 100);
    }

    @Test
    void testConstructorVacio() {
        Vuelo v = new Vuelo();
        assertNotNull(v);
    }

    @Test
    void testConstructorConParametros() {
        // Crear vuelo usando constructor con parámetros
        Vuelo vuelo = new Vuelo("IB100", piloto, 10, 120);

        // Comprobar que los atributos se inicializan correctamente
        assertEquals("IB100", vuelo.getCodigoVuelo());
        assertEquals(piloto, vuelo.getPiloto());
        assertEquals(10, vuelo.getNumeroPasajeros());
        assertEquals(120, vuelo.getPrecioPorPasajero());

        // Lista de pasajeros debería estar vacía al inicio
        assertEquals(0, vuelo.getListaPasajeros().size());
    }

    
    @Test
    void testAgregarPasajero() {
        Viajero v = new Viajero("Ana", "Lopez", "111A", "Española");
        assertTrue(vuelo.agregarPasajero(v));
        assertEquals(1, vuelo.getNumeroPasajeros());
    }

    @Test
    void testAgregarVariosPasajeros() {
        vuelo.agregarPasajero(new Viajero("A", "A", "1", "ES"));
        vuelo.agregarPasajero(new Viajero("B", "B", "2", "FR"));

        assertEquals(2, vuelo.getNumeroPasajeros());
    }

    @Test
    void testObtenerPrecioVuelo() {
        vuelo.agregarPasajero(new Viajero("A", "A", "1", "ES"));
        vuelo.agregarPasajero(new Viajero("B", "B", "2", "FR"));

        assertEquals(200, vuelo.obtenerPrecioVuelo());
    }

    @Test
    void testToString() {
        vuelo.agregarPasajero(new Viajero("Ana", "Lopez", "111A", "ES"));
        String texto = vuelo.toString();

        assertTrue(texto.contains("IB100"));
        assertTrue(texto.contains("Ana"));
        assertTrue(texto.contains("Número de pasajeros"));
    }
}**/
public class VueloTest {

    private Vuelo vuelo;
    private Piloto piloto;
    private Viajero pasajero1;
    private Viajero pasajero2;

    @BeforeEach
    void setUp() {
        piloto = new Piloto("Iker", "Sanz", "789C", "P001", 1500);
        vuelo = new Vuelo("IB100", piloto, 0, 100);
        pasajero1 = new Viajero("Ana", "Lopez", "111A", "ES");
        pasajero2 = new Viajero("Lorea", "Mendieta", "222A", "ES");
    }

    @Test
    void testConstructorYGetters() {

        assertEquals("IB100", vuelo.getCodigoVuelo());
        assertEquals(piloto, vuelo.getPiloto());
        assertEquals(0, vuelo.getNumeroPasajeros());
        assertEquals(100, vuelo.getPrecioPorPasajero());
        assertNotNull(vuelo.getListaPasajeros());
        assertEquals(0, vuelo.getListaPasajeros().size());
    }
    @Test
    void testGetListaPasajeros() {
    	
    	
        // Hasieran lista hutsik egon behar da
        assertNotNull(vuelo.getListaPasajeros());
        assertEquals(0, vuelo.getListaPasajeros().size());

        // Gehitu pasajero bat
        vuelo.agregarPasajero(pasajero1);

        // Lista jasotzen duela egiaztatu
        ArrayList<Viajero> lista = vuelo.getListaPasajeros();
        assertEquals(1, lista.size());
        assertEquals(pasajero1, lista.get(0));

        // Beste pasahero bat gehitu eta berriro egiaztatu
        vuelo.agregarPasajero(pasajero2);
        lista = vuelo.getListaPasajeros();
        assertEquals(2, lista.size());
        assertEquals(pasajero2, lista.get(1));
    }

    @Test
    void testSetters() {
        vuelo.setCodigoVuelo("IB200");
        assertEquals("IB200", vuelo.getCodigoVuelo());

        Piloto nuevoPiloto = new Piloto("Maria", "Lopez", "123B", "P002", 2000);
        vuelo.setPiloto(nuevoPiloto);
        assertEquals(nuevoPiloto, vuelo.getPiloto());

        vuelo.setNumeroPasajeros(5);
        assertEquals(5, vuelo.getNumeroPasajeros());

        vuelo.setPrecioPorPasajero(150);
        assertEquals(150, vuelo.getPrecioPorPasajero());
    }

    @Test
    void testAgregarPasajero() {
        assertTrue(vuelo.agregarPasajero(pasajero1));
        assertEquals(1, vuelo.getNumeroPasajeros());
        assertEquals(1, vuelo.getListaPasajeros().size());
        assertEquals(pasajero1, vuelo.getListaPasajeros().get(0));

        vuelo.agregarPasajero(pasajero2);
        assertEquals(2, vuelo.getNumeroPasajeros());
        assertEquals(pasajero2, vuelo.getListaPasajeros().get(1));
    }

    @Test
    void testObtenerPrecioVuelo() {
        vuelo.agregarPasajero(pasajero1);
        vuelo.agregarPasajero(pasajero2);
        // 2 pasajeros * 100 precio cada uno
        assertEquals(200, vuelo.obtenerPrecioVuelo());
    }

    @Test
    void testToString() {
        vuelo.agregarPasajero(pasajero1);
        String texto = vuelo.toString();
        assertTrue(texto.contains("IB100"));
        assertTrue(texto.contains("Iker"));
        assertTrue(texto.contains("Sanz"));
        assertTrue(texto.contains("Ana"));
    }
}