package estructuras;

import modelo.Cliente;

public class Cola {

    private class Nodo {
        Cliente dato;
        Nodo siguiente;

        public Nodo(Cliente dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo frente;
    private Nodo fin;

    //  ENQUEUE (agregar)
    public void enqueue(Cliente dato) {
        Nodo nuevo = new Nodo(dato);

        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    //  DEQUEUE (eliminar)
    public Cliente dequeue() {
        if (frente == null) {
            System.out.println("Cola vacía");
            return null;
        }

        Cliente dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    //  MOSTRAR
    public void mostrar() {
        if (frente == null) {
            System.out.println("No hay clientes en cola");
            return;
        }

        Nodo actual = frente;
        while (actual != null) {
            actual.dato.mostrar();
            actual = actual.siguiente;
        }
    }
}