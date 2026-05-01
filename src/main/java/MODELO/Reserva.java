package modelo;

public class Reserva {
    
    private Cliente cliente;
    private Pelicula pelicula;
    private int fila;
    private int columna;

    // Constructor
    public Reserva(Cliente cliente, Pelicula pelicula, int fila, int columna) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fila = fila;
        this.columna = columna;
    }

    // Método mostrar
    public void mostrar() {
        System.out.println("Reserva:");
        cliente.mostrar();
        pelicula.mostrar();
        System.out.println("Asiento: Fila " + fila + " - Columna " + columna);
    }
    public Cliente getCliente() {
    return cliente;
}
}