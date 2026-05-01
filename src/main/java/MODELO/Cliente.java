package modelo;

public class Cliente {
    
    private String nombre;
    private String dni;

    // Constructor
    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    // Método mostrar
    public void mostrar() {
        System.out.println("Cliente: " + nombre + " | DNI: " + dni);
    }
}