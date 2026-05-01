package estructuras;

import modelo.Pelicula;

public class ArbolBinario {

    //  Nodo interno
    private class Nodo {
        Pelicula dato;
        Nodo izquierda;
        Nodo derecha;

        public Nodo(Pelicula dato) {
            this.dato = dato;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    private Nodo raiz;

    //  INSERTAR
    public void insertar(Pelicula dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo actual, Pelicula dato) {
        if (actual == null) {
            return new Nodo(dato);
        }

        if (dato.getId() < actual.dato.getId()) {
            actual.izquierda = insertarRec(actual.izquierda, dato);
        } else if (dato.getId() > actual.dato.getId()) {
            actual.derecha = insertarRec(actual.derecha, dato);
        }

        return actual;
    }

    //  BUSCAR
    public Pelicula buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Pelicula buscarRec(Nodo actual, int id) {
        if (actual == null) {
            return null;
        }

        if (id == actual.dato.getId()) {
            return actual.dato;
        }

        if (id < actual.dato.getId()) {
            return buscarRec(actual.izquierda, id);
        } else {
            return buscarRec(actual.derecha, id);
        }
    }

    //  RECORRIDOS

    // Inorden (ordenado)
    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(Nodo actual) {
        if (actual != null) {
            inordenRec(actual.izquierda);
            actual.dato.mostrar();
            inordenRec(actual.derecha);
        }
    }

    // Preorden
    public void preorden() {
        preordenRec(raiz);
    }

    private void preordenRec(Nodo actual) {
        if (actual != null) {
            actual.dato.mostrar();
            preordenRec(actual.izquierda);
            preordenRec(actual.derecha);
        }
    }

    // Postorden
    public void postorden() {
        postordenRec(raiz);
    }

    private void postordenRec(Nodo actual) {
        if (actual != null) {
            postordenRec(actual.izquierda);
            postordenRec(actual.derecha);
            actual.dato.mostrar();
        }
    }
}