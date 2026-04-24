package controller;

import model.Biblioteca;
import model.Libro;

public class LibroController {
    public void agregarLibro(String isbn, String title, int authorId, int categoriaId, Biblioteca biblioteca) {
        Libro libro = new Libro(isbn, title, biblioteca.getAutores().get(authorId-1));
        biblioteca.getCategorias().get(categoriaId-1).agregarLibro(libro);
    }
}
