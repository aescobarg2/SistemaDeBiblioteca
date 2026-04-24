package model;

import java.util.ArrayList;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Categoria> categorias;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;

    private static int diaActual = 1;

    public Biblioteca() {
        this.categorias = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // ================== REGISTROS ================== //
    public void registrarAutor(Autor a) { autores.add(a); }
    public void registrarCategoria(Categoria c) { categorias.add(c); }
    public void registrarPrestamo(Prestamo p) { prestamos.add(p); }

    // ================== GETTERS ================== //
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    // ================== TIEMPO ================== //
    public static int getDiaActual() {
        return diaActual;
    }

    public static void avanzarDia() {
        diaActual++;
    }

    // ================== REPORTE ================== //
    public void mostrarEstado() {
        System.out.println("--- Reporte de Biblioteca ---");
        System.out.println("Autores registrados: " + autores.size());
        System.out.println("Categorías: " + categorias.size());
        System.out.println("Préstamos realizados: " + prestamos.size());
        System.out.println("Día actual: " + diaActual); // 👈 útil para demo
    }
}