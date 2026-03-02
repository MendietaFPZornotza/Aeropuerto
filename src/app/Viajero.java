package app;

public class Viajero extends Persona {
    private String nacionalidad;

    public Viajero() {}

    public Viajero(String nombre, String apellido, String DNI, String nacionalidad) {
        super(nombre, apellido, DNI);
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    @Override
    public String toString() {
        return super.toString() + " | Nacionalidad=" + nacionalidad;
    }
}
