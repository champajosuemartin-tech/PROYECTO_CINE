package estructuras;

import modelo.Reserva;

public class ListaEnlazada {

     private class Nodo {
        Reserva dato;
        Nodo siguiente;

        public Nodo(Reserva dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
      private Nodo cabeza;
 

    //  INSERTAR (al final)
    public void insertar(Reserva dato) {
        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    //  RECORRER
    public void recorrer() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = cabeza;
        while (actual != null) {
            actual.dato.mostrar();
            System.out.println("-------------------");
            actual = actual.siguiente;
        }
    }

    //  BUSCAR (por DNI del cliente)
    public Reserva buscar(String dni) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.dato != null &&
                actual.dato.getCliente().getDni().equals(dni)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    //  ELIMINAR (por DNI)
    public void eliminar(String dni) {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        // Caso: eliminar el primero
        if (cabeza.dato.getCliente().getDni().equals(dni)) {
            cabeza = cabeza.siguiente;
            System.out.println("Reserva eliminada");
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.dato.getCliente().getDni().equals(dni)) {
                actual.siguiente = actual.siguiente.siguiente;
                System.out.println("Reserva eliminada");
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("No se encontró la reserva");
    }
}
