package model;


public class Autor {
    private int id;
    private final String nombre; // Cannot be modified after constructor
    private String pais;
    private int anioNacimiento;

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public Autor(int id, String nombre, String pais, int añoNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.anioNacimiento = añoNacimiento;
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

    public void setAñoNacimiento(int añoNacimiento) {
        this.anioNacimiento = añoNacimiento;
    }
}