package model;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Categoria> categorias;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.categorias = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }


    public void registrarAutor(Autor a) { autores.add(a); }
    public void registrarCategoria(Categoria c) { categorias.add(c); }
    public void registrarPrestamo(Prestamo p) { prestamos.add(p); }


    public void mostrarEstado() {
        System.out.println("--- Reporte de Biblioteca ---");
        System.out.println("Autores registrados: " + autores.size());
        System.out.println("Categorías: " + categorias.size());
        System.out.println("Préstamos realizados: " + prestamos.size());
    }
}