package model;


public class Autor {
    private static int id;
    private final String nombre; // Cannot be modified after constructor
    private String pais;
    private int anioNacimiento;

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public Autor(int id, String nombre, String pais, int anioNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.anioNacimiento = anioNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAñoNacimiento() {
        return anioNacimiento;
    }

    public void setAñoNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    @Override
    public String toString() {
        return String.format(
                "[%d] %s | %s | Nacimiento: %d",
                id,
                nombre,
                pais,
                anioNacimiento
        );
    }
}