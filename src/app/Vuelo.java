package app;

import java.util.ArrayList;

public class Vuelo {
    protected String codigoVuelo;
    protected Piloto piloto;
    protected int numeroPasajeros;
    protected int precioPorPasajero;
    protected ArrayList<Viajero> listaPasajeros;

    public Vuelo() {
    }

    public Vuelo(String codigo, Piloto piloto, int numPasajeros, int precio) {
        this.codigoVuelo = codigo;
        this.piloto = piloto;
        this.numeroPasajeros = numPasajeros;
        this.precioPorPasajero = precio;
        this.listaPasajeros = new ArrayList<>();
    }
    
    public ArrayList<Viajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public boolean agregarPasajero(Viajero p) {
        listaPasajeros.add(p);
        numeroPasajeros = listaPasajeros.size();
        return true;
    }

    public String getCodigoVuelo() { return codigoVuelo; }
    public void setCodigoVuelo(String c) { codigoVuelo = c; }

    public Piloto getPiloto() { return piloto; }
    public void setPiloto(Piloto p) { piloto = p; }

    public int getNumeroPasajeros() { return numeroPasajeros; }
    public void setNumeroPasajeros(int n) { numeroPasajeros = n; }

    public int getPrecioPorPasajero() { return precioPorPasajero; }
    public void setPrecioPorPasajero(int p) { precioPorPasajero = p; }

    public double obtenerPrecioVuelo() {
        return numeroPasajeros * precioPorPasajero;
    }

    @Override
    public String toString() {
        String out = "Vuelo [" + codigoVuelo + "] - Piloto: " + piloto +
                     "\nNúmero de pasajeros: " + numeroPasajeros +
                     " | Precio/P: " + precioPorPasajero + "\nPasajeros:\n";

        for (Viajero p : listaPasajeros)
            out += "  - " + p.getNombre() + "\n";

        return out;
    }
}
