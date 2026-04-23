package model;

public class Prestamo {
    private final int id;
    private Libro libro;
    private String usuario;
    private String fechas;

    public Prestamo(int id, Libro libro, String usuario, String fechas) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechas = fechas;
    }

    @Override
    public String toString() {
        return "Prestamo :" + id + ": " + libro.getTitulo() + " a " + usuario + " [" + fechas + "]";
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }
}