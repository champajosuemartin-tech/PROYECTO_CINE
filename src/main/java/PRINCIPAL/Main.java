package principal;

import servicios.Cine;
import modelo.Cliente;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cine cine = new Cine();

        int opcion;

        do {
            System.out.println("\n===== CINE UTP =====");
            System.out.println("1. Ver peliculas");
            System.out.println("2. Buscar pelicula");
            System.out.println("3. Ver sala");
            System.out.println("4. Reservar asiento");
            System.out.println("5. Comprar entrada");
            System.out.println("6. Ver cola de clientes");
            System.out.println("7. Ver historial");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    cine.verPeliculas();
                    break;

                case 2:
                    System.out.print("Ingrese ID de la pelicula: ");
                    int idBuscar = sc.nextInt();
                    if (cine.buscarPelicula(idBuscar) != null) {
                        cine.buscarPelicula(idBuscar).mostrar();
                    } else {
                        System.out.println("Pelicula no encontrada");
                    }
                    break;

                case 3:
                    cine.mostrarSala();
                    break;

                case 4:
                    sc.nextLine(); // limpiar buffer

                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine();

                    System.out.print("DNI: ");
                    String dni = sc.nextLine();

                    System.out.print("ID de pelicula: ");
                    int idPeli = sc.nextInt();

                    System.out.print("Fila (0-4): ");
                    int fila = sc.nextInt();

                    System.out.print("Columna (0-4): ");
                    int col = sc.nextInt();

                    Cliente cliente = new Cliente(nombre, dni);

                    cine.reservar(cliente, idPeli, fila, col);
                    break;

                case 5:
                    cine.comprar();
                    break;

                case 6:
                    cine.verCola();
                    break;

                case 7:
                    cine.verHistorial();
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción invalida");
            }

        } while (opcion != 8);

        sc.close();
    }
}