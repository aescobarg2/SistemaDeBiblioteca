package model;

public class Libro {
    private final String isbn;
    private final String titulo;
    private Autor autor;
    private boolean isPrestado;


    public Libro(String isbn, String titulo, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.isPrestado = false;
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

    public Autor getAutor() {
        return autor;
    }

    public boolean isPrestado() {
        return isPrestado;
    }

    public void setisPrestado(boolean prestado) {
        this.isPrestado = prestado;
    }

    @Override
    public String toString() {
        return String.format(
                "%s | %s",
                isbn,
                titulo
        );
    }
}
