
package servicios;

import estructuras.*;
import modelo.*;

public class Cine {

    private ArbolBinario arbolPeliculas;
    private ListaEnlazada listaReservas;
    private Pila historial;
    private Cola colaClientes;

    private char[][] sala;

    // Constructor
    public Cine() {
        arbolPeliculas = new ArbolBinario();
        listaReservas = new ListaEnlazada();
        historial = new Pila();
        colaClientes = new Cola();

        // Sala 5x5
        sala = new char[5][5];

        inicializarSala();
        cargarPeliculas();
    }

    //  Inicializar sala
    private void inicializarSala() {
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j] = 'O';
            }
        }
    }

    //  Cargar películas
    private void cargarPeliculas() {
        arbolPeliculas.insertar(new Pelicula(10, "Avengers", "8PM", 15));
        arbolPeliculas.insertar(new Pelicula(5, "Batman", "6PM", 12));
        arbolPeliculas.insertar(new Pelicula(20, "Spiderman", "9PM", 18));
    }

    //  Ver películas
    public void verPeliculas() {
        arbolPeliculas.inorden();
    }

    //  Buscar película
    public Pelicula buscarPelicula(int id) {
        return arbolPeliculas.buscar(id);
    }

    //  Mostrar sala
    public void mostrarSala() {
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.println();
        }
    }

    //  Reservar asiento
    public void reservar(Cliente cliente, int idPelicula, int fila, int col) {

        if (sala[fila][col] == 'X') {
            System.out.println("Asiento ocupado");
            return;
        }

        Pelicula peli = buscarPelicula(idPelicula);

        if (peli == null) {
            System.out.println("Película no encontrada");
            return;
        }

        sala[fila][col] = 'X';

        Reserva r = new Reserva(cliente, peli, fila, col);

        listaReservas.insertar(r);
        colaClientes.enqueue(cliente);

        System.out.println("Reserva realizada");
    }

    //  Comprar entrada
    public void comprar() {

        Cliente cliente = colaClientes.dequeue();

        if (cliente == null) {
            System.out.println("No hay clientes en cola");
            return;
        }

        Reserva r = listaReservas.buscar(cliente.getDni());

        if (r != null) {
            historial.push(r);
            System.out.println("Compra realizada:");
            r.mostrar();
        } else {
            System.out.println("No hay reserva para este cliente");
        }
    }

    //  Mostrar historial
    public void verHistorial() {
        historial.mostrar();
    }

    //  Mostrar cola
    public void verCola() {
        colaClientes.mostrar();
    }
}