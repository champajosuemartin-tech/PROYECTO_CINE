package estructuras;

import modelo.Reserva;

public class Pila {

    private class Nodo {
        Reserva dato;
        Nodo siguiente;

        public Nodo(Reserva dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cima;

    //  PUSH (agregar)
    public void push(Reserva dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    //  POP (eliminar)
    public Reserva pop() {
        if (cima == null) {
            System.out.println("Pila vacía");
            return null;
        }

        Reserva dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    //  MOSTRAR
    public void mostrar() {
        if (cima == null) {
            System.out.println("Historial vacío");
            return;
        }

        Nodo actual = cima;
        while (actual != null) {
            actual.dato.mostrar();
            System.out.println("-------------------");
            actual = actual.siguiente;
        }
    }
}