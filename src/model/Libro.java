package model;

public class Libro {
    private final String isbn;
    private final String titulo;
    private Autor autor;
    private Categoria categoria;

    public Libro(String isbn, String titulo, Autor autor, Categoria categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }


    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
