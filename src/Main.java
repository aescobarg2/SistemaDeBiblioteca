import controller.AutorController;
import controller.CategoriaController;
import controller.LibroController;
import controller.PrestamoController;
import model.*;

import java.util.*;

public class Main {

    // ================== VARIABLES ================== //
    private static Scanner leer = new Scanner(System.in);
    public static Biblioteca miBiblioteca = new Biblioteca();

    private static CategoriaController categoriaController = new CategoriaController();
    private static AutorController autorController = new AutorController();
    private static LibroController libroController = new LibroController();
    private static PrestamoController prestamoController = new PrestamoController();

    // ================== HELPERS VISUALES ================== //
    public static void printHeader(String titulo) {
        System.out.println("\n==================================================");
        System.out.println(titulo);
        System.out.println("==================================================");
    }

    public static void printSubHeader(String titulo) {
        System.out.println("\n---------------- " + titulo + " ----------------");
    }

    // ================== FUNCIONES ================== //

    public static void crearCategoria(){
        printHeader("CREAR CATEGORIA");

        System.out.print("Nombre: ");
        String nombreCategoria = leer.nextLine();

        categoriaController.crearCategoria(nombreCategoria, miBiblioteca);
    }

    public static void agregarAutor(){
        printHeader("AGREGAR AUTOR");

        System.out.print("Nombre: ");
        String nombrAutor = leer.nextLine();

        System.out.print("Pais: ");
        String nombrePais = leer.nextLine();

        System.out.print("Anio de nacimiento: ");
        int nombreanio = leer.nextInt();
        leer.nextLine();

        autorController.AgregarAutor(nombrAutor,nombrePais,nombreanio, miBiblioteca);
    }

    public static void agregarLibro() {
        printHeader("AGREGAR LIBRO");

        System.out.print("ISBN: ");
        String isbn = leer.nextLine();

        System.out.print("Titulo: ");
        String title = leer.nextLine();

        printSubHeader("Autores");
        printArray(miBiblioteca.getAutores());
        System.out.print("Seleccione autor: ");
        int autorId = leer.nextInt();

        printSubHeader("Categorias");
        printArray(miBiblioteca.getCategorias());
        System.out.print("Seleccione categoria: ");
        int categoriaId = leer.nextInt();
        leer.nextLine();

        libroController.agregarLibro(isbn, title, autorId, categoriaId, miBiblioteca);
    }

    public static void realizarPrestamo() {
        printHeader("REALIZAR PRESTAMO");

        System.out.print("Usuario: ");
        String name = leer.nextLine();

        printSubHeader("Categorias");
        printArray(miBiblioteca.getCategorias());
        System.out.print("Seleccione categoria: ");
        int categoriaId = leer.nextInt();
        leer.nextLine();

        printSubHeader("Libros disponibles");
        printBooks(true, miBiblioteca.getCategorias().get(categoriaId-1).getListaLibros());

        System.out.print("ISBN: ");
        String isbn = leer.nextLine();

        boolean successfully = prestamoController.crearPrestamo(categoriaId, isbn, name, miBiblioteca);

        if(!successfully) System.out.println("No se pudo realizar el prestamo.");
    }

    public static void devloverLibro() {
        printHeader("DEVOLVER LIBRO");

        System.out.print("Usuario: ");
        String name = leer.nextLine();

        printSubHeader("Prestamos del usuario");
        boolean successfully = printPrestamos(miBiblioteca.getPrestamos(), name);

        if(!successfully) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("ISBN a devolver: ");
        String isbn = leer.nextLine();

        boolean devuelto = prestamoController.devolverLibro(isbn, miBiblioteca);

        if(!devuelto) System.out.println("No se pudo devolver el libro.");
    }

    public static void verLibrosDisponibles() {
        printHeader("LIBROS DISPONIBLES");

        for(Categoria c : miBiblioteca.getCategorias()) {
            printSubHeader("Categoria: " + c.getNombre());
            printBooks(true, c.getListaLibros());
        }
    }

    public static void verDetallesAutor() {
        printHeader("DETALLES DE AUTOR");

        verLibrosDisponibles();

        System.out.print("ISBN: ");
        String isbn = leer.nextLine();

        Autor autor = autorController.verDetallesAutor(isbn, miBiblioteca);

        if(autor == null) {
            System.out.println("ISBN no encontrado.");
            return;
        }

        System.out.println(autor);
    }

    public static void verLibrosCategoria() {
        printHeader("LIBROS POR CATEGORIA");

        printArray(miBiblioteca.getCategorias());
        System.out.print("Seleccione categoria: ");
        int categoriaId = leer.nextInt();
        leer.nextLine();

        printBooks(true, miBiblioteca.getCategorias().get(categoriaId-1).getListaLibros());
    }

    public static void verMultas() {
        printHeader("MULTAS ACUMULADAS");

        int total = 0;

        for (Prestamo p : miBiblioteca.getPrestamos()) {
            int multa = prestamoController.calcularMulta(p);

            if (multa > 0) {
                System.out.printf("%s -> $%,d%n", p, multa);
                total += multa;
            }
        }

        System.out.println("----------------------------------------------");
        System.out.printf("Total acumulado: $%,d%n", total);
    }

    public static void verEstadisticas() {
        printHeader("ESTADISTICAS");

        int totalLibros = 0;
        int prestados = 0;

        for (Categoria c : miBiblioteca.getCategorias()) {
            totalLibros += c.getListaLibros().size();

            for (Libro l : c.getListaLibros()) {
                if (l.isPrestado()) prestados++;
            }
        }

        System.out.printf("Total de libros: %d%n", totalLibros);
        System.out.printf("Libros prestados: %d%n", prestados);
        System.out.printf("Total prestamos: %d%n", miBiblioteca.getPrestamos().size());
    }

    // Datos de prueba iniciales
    public static void cargarDatosPrueba() {

        // ================= AUTORES =================
        Autor a1 = new Autor(1, "Gabriel Garcia Marquez", "Colombia", 1927);
        Autor a2 = new Autor(2, "J.K. Rowling", "Reino Unido", 1965);
        Autor a3 = new Autor(3, "George Orwell", "India", 1903);

        miBiblioteca.registrarAutor(a1);
        miBiblioteca.registrarAutor(a2);
        miBiblioteca.registrarAutor(a3);

        // ================= CATEGORIAS =================
        Categoria c1 = new Categoria(1, "Novela");
        Categoria c2 = new Categoria(2, "Fantasia");
        Categoria c3 = new Categoria(3, "Distopia");

        miBiblioteca.registrarCategoria(c1);
        miBiblioteca.registrarCategoria(c2);
        miBiblioteca.registrarCategoria(c3);

        // ================= LIBROS =================
        Libro l1 = new Libro("ISBN001", "Cien Anios de Soledad", a1);
        Libro l2 = new Libro("ISBN002", "Harry Potter", a2);
        Libro l3 = new Libro("ISBN003", "1984", a3);

        c1.agregarLibro(l1);
        c2.agregarLibro(l2);
        c3.agregarLibro(l3);
    }

    // ================== MAIN ================== //
    public static void main(String[] args) {
        cargarDatosPrueba();
        int opcion = 0;

        do {
            try {
                System.out.println("\n===== SISTEMA DE GESTION BIBLIOTECA =====");
                System.out.println("1. Crear Categoria");
                System.out.println("2. Agregar Autor");
                System.out.println("3. Agregar Libro");
                System.out.println("4. Realizar Prestamo");
                System.out.println("5. Devolver Libro");
                System.out.println("6. Ver Libros Disponibles");
                System.out.println("7. Ver Autor");
                System.out.println("8. Ver Libros por Categoria");
                System.out.println("9. Ver Multas");
                System.out.println("10. Ver Estadisticas");
                System.out.println("11. Salir");
                System.out.print("Opcion: ");

                opcion = leer.nextInt();
                leer.nextLine();

                switch(opcion){
                    case 1: crearCategoria(); break;
                    case 2: agregarAutor(); break;
                    case 3: agregarLibro(); break;
                    case 4: realizarPrestamo(); break;
                    case 5: devloverLibro(); break;
                    case 6: verLibrosDisponibles(); break;
                    case 7: verDetallesAutor(); break;
                    case 8: verLibrosCategoria(); break;
                    case 9: verMultas(); break;
                    case 10: verEstadisticas(); break;
                    case 11: System.out.println("Fin del programa"); break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida.");
                leer.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                leer.nextLine();
            }

        } while (opcion != 11);
    }

    // ================== HELPERS ================== //

    public static void printArray(ArrayList<?> array) {
        if(array.isEmpty()) {
            System.out.println("No hay datos.");
            return;
        }

        for(int i = 0; i < array.size(); i++) {
            System.out.printf("%2d. %s%n", (i+1), array.get(i));
        }
    }

    public static boolean printPrestamos(ArrayList<Prestamo> prestamos, String user) {
        int i = 1;
        boolean found = false;

        for(Prestamo p : prestamos) {
            if(!p.getUsuario().equalsIgnoreCase(user)) continue;

            System.out.printf("%2d. %s%n", i, p);
            i++;
            found = true;
        }

        return found;
    }

    public static void printBooks(boolean disponibles, ArrayList<Libro> libros) {
        boolean hay = false;

        for(Libro l : libros) {
            if(disponibles && !l.isPrestado()) {
                System.out.println(l);
                hay = true;
            }

            if(!disponibles && l.isPrestado()) {
                System.out.println(l);
                hay = true;
            }
        }

        if(!hay) {
            System.out.println("No hay libros para mostrar.");
        }
    }
}