package model;

public class Prestamo {
    private final int id;
    private Libro libro;
    private String usuario;
    private int fechaPrestamo;
    private int fechaEntrega;
    private boolean devuelto;

    public Prestamo(int id, Libro libro, String usuario, int fechaPrestamo, int fechaEntrega) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.devuelto = false;
    }

    @Override
    public String toString() {
        return "Prestamo " + id +
                ": " + libro.getTitulo() +
                " a " + usuario +
                " [Entrega: dia " + fechaEntrega + "]" +
                (devuelto ? " (Devuelto)" : "");
    }

    public int getFechaEntrega() {
        return fechaEntrega;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getUsuario() {
        return usuario;
    }
}