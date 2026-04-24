package controller;

import model.Autor;
import model.Biblioteca;

public class AutorController {

    public void AgregarAutor(String nombre, String pais, int anioNacimmiento, Biblioteca biblioteca) {
        Autor autor = new Autor(biblioteca.getAutores().size() + 1, nombre, pais, anioNacimmiento);
        biblioteca.registrarAutor(autor);
    }

    public void verDetallesAutor(Biblioteca biblioteca, Autor autor) {

    }
}
