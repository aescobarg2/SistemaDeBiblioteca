package model;

import java.util.ArrayList;

public class Categoria {
    private final int id;
    private final String nombre;
    private ArrayList<Libro> listaLibros;

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        this.listaLibros.add(libro);
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public String getNombre() { return nombre; }
}