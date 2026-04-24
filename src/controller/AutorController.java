package controller;

import model.Autor;
import model.Biblioteca;
import model.Categoria;
import model.Libro;

public class AutorController {

    public void AgregarAutor(String nombre, String pais, int anioNacimmiento, Biblioteca biblioteca) {
        Autor autor = new Autor(biblioteca.getAutores().size() + 1, nombre, pais, anioNacimmiento);
        biblioteca.registrarAutor(autor);
    }

    public Autor verDetallesAutor(String isbn, Biblioteca biblioteca) {
        for(Categoria c : biblioteca.getCategorias()) {
            for(Libro l : c.getListaLibros()) {
                if(isbn.equals(l.getIsbn())) {
                    return l.getAutor();
                }
            }
        }
        return null;
    }
}
