package app;

public class Piloto extends Persona {
    private String codigoPiloto;
    private int horasDeVuelo;

    public Piloto() {}

    public Piloto(String nombre, String apellido, String DNI,
                  String codigoPiloto, int horasDeVuelo) {
        super(nombre, apellido, DNI);
        this.codigoPiloto = codigoPiloto;
        this.horasDeVuelo = horasDeVuelo;
    }

    public String getCodigoPiloto() { return codigoPiloto; }
    public void setCodigoPiloto(String codigoPiloto) { this.codigoPiloto = codigoPiloto; }

    public int getHorasDeVuelo() { return horasDeVuelo; }
    public void setHorasDeVuelo(int horasDeVuelo) { this.horasDeVuelo = horasDeVuelo; }

    @Override
    public String toString() {
        return super.toString() + " | CodigoPiloto=" + codigoPiloto +
               " | Horas=" + horasDeVuelo;
    }
}
