import controller.AutorController;
import controller.CategoriaController;
import model.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //==================// Declaracion de variables //==================//
    private static Scanner leer = new Scanner(System.in);
    public static Biblioteca miBiblioteca = new Biblioteca();
    private static CategoriaController categoriaController = new CategoriaController();
    private static AutorController autorController = new AutorController();



    //==================//Funciones//==================//
    public static void crearCategoria(){

        System.out.print("Ingrese el nombre de la categoria: ");
        String nombreCategoria = leer.nextLine();

        categoriaController.crearCategoria(nombreCategoria, miBiblioteca);

    }

    public static void agregarAutor(){
        System.out.print("Ingrese nombre del autor: ");
        String nombrAutor = leer.nextLine();

        System.out.print("Ingrese nombre del pais");
        String nombrePais = leer.nextLine();

        System.out.print("Ingrese anio");
        int nombreanio = leer.nextInt();

        autorController.AgregarAutor(nombrAutor,nombrePais,nombreanio, miBiblioteca);
    }

    //==================// Main //==================//
    public static void main(String[] args) {


        int opcion = 0;

        do {
            try {
                System.out.println("\n--- MENU BIBLIOTECA UNIVERSIDAD DE CARTAGENA ---");
                System.out.println("1. Crear nueva Categoría");
                System.out.println("2. Agregar nuevo Autor");
                System.out.println("3. Agregar nuevo Libro");
                System.out.println("4. Realizar Préstamo");
                System.out.println("5. Devolver Libro Prestado");
                System.out.println("6. Ver Libros Disponibles");
                System.out.println("7. Ver Detalles de Autor");
                System.out.println("8. Ver Libros de una Categoría");
                System.out.println("9. Ver Multas Acumuladas");
                System.out.println("10. Ver Estadísticas");
                System.out.println("11. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = leer.nextInt();
                leer.nextLine();

                switch(opcion){
                    case 1:
                        crearCategoria();
                        break;

                    case 2:
                        agregarAutor();
                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:

                        break;

                    case 8:

                        break;

                    case 9:

                        break;

                    case 10:

                        break;

                    case 11:
                        System.out.println("Fin del programa");
                        break;


                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debe ingresar un valor numerico válido.");
                leer.nextLine();
                opcion = 0;
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                leer.nextLine();
            }

        } while (opcion !=11);
    }
}