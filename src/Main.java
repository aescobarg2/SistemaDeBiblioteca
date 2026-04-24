import model.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            try {
                System.out.println("\n--- MENU BIBLIOTECA UNIVERSIDAD DE CARTAGENA ---");
                System.out.println("1. Registrar Autor");
                System.out.println("2. Registrar Categoría");
                System.out.println("3. Registrar Libro");
                System.out.println("4. Realizar Préstamo");
                System.out.println("5. Mostrar Estado del Sistema");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = leer.nextInt();
                leer.nextLine();

                switch(opcion){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debe ingresar un valor numerico válido.");
                leer.nextLine();
                opcion = 0;
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                leer.nextLine();
            }

        } while (opcion != 6);
    }
}