package org.example;

public class ListaSimple {
    Nodo cabeza;

    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevo;
    }

    public void intercambiarPares() {
        if (cabeza == null || cabeza.siguiente == null) return;

        Nodo dummy = new Nodo(0);
        dummy.siguiente = cabeza;
        Nodo previo = dummy;
        Nodo actual = cabeza;

        while (actual != null && actual.siguiente != null) {
            Nodo primero = actual;
            Nodo segundo = actual.siguiente;

            previo.siguiente = segundo;
            primero.siguiente = segundo.siguiente;
            segundo.siguiente = primero;

            previo = primero;
            actual = primero.siguiente;
        }
        cabeza = dummy.siguiente;
    }
}