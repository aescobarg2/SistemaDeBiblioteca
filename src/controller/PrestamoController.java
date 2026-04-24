package controller;

import model.Biblioteca;
import model.Libro;
import model.Prestamo;

import java.util.ArrayList;

public class PrestamoController {

    public boolean crearPrestamo(int categoriaId, String isbn, String usuario, Biblioteca biblioteca) {

        ArrayList<Libro> libros = biblioteca.getCategorias()
                .get(categoriaId - 1)
                .getListaLibros();

        for (Libro l : libros) {

            if (l.getIsbn().equals(isbn) && !l.isPrestado()) {

                l.setisPrestado(true);

                int diasPermitidos = 3;

                Prestamo prestamo = new Prestamo(
                        biblioteca.getPrestamos().size() + 1,
                        l,
                        usuario,
                        Biblioteca.getDiaActual(),
                        Biblioteca.getDiaActual() + diasPermitidos
                );

                biblioteca.registrarPrestamo(prestamo);
                return true;
            }
        }

        return false;
    }

    public boolean devolverLibro(String isbn, Biblioteca biblioteca) {

        for (Prestamo p : biblioteca.getPrestamos()) {

            if (p.getLibro().getIsbn().equals(isbn) && !p.isDevuelto()) {

                p.getLibro().setisPrestado(false);
                p.setDevuelto(true);

                return true;
            }
        }

        return false;
    }

    public int calcularDiasRetraso(Prestamo p) {
        int retraso = Biblioteca.getDiaActual() - p.getFechaEntrega();
        return Math.max(retraso, 0);
    }

    public int calcularMulta(Prestamo p) {
        return calcularDiasRetraso(p) * 1000;
    }
}