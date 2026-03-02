package app;

public class VueloCharter extends Vuelo {
    private double recargoCharter;
    private int maximoPasajeros;
    
    public VueloCharter() {
    }

    public VueloCharter(String codigo, Piloto p, int numPasajeros, int precioPorPasajero, double recargo) {
        super(codigo, p, numPasajeros, precioPorPasajero);
        this.recargoCharter = recargo;
        this.maximoPasajeros = 200;
    }

    public double getRecargoCharter() { return recargoCharter; }
    public void setRecargoCharter(double r) { recargoCharter = r; }
    
    public int getMaximoPasajeros() { return maximoPasajeros; }
    public void setMaximoPasajeros(int m) { maximoPasajeros = m; }

    @Override
    public boolean agregarPasajero(Viajero b) {
        if (listaPasajeros.size() >= maximoPasajeros) return false;
        return super.agregarPasajero(b);
    }

    @Override
    public double obtenerPrecioVuelo() {
        return (numeroPasajeros * precioPorPasajero) + recargoCharter;
    }

    @Override
    public String toString() {
        return super.toString() + " [Recargo Charter: " + recargoCharter + "]";
    }
}
