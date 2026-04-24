package controller;

import model.Biblioteca;
import model.Categoria;


public class CategoriaController {

    public void crearCategoria(String nombre, Biblioteca biblioteca){

        Categoria nomCategoria = new Categoria(biblioteca.getCategorias().size() + 1, nombre);
        biblioteca.registrarCategoria(nomCategoria);


    }
}
