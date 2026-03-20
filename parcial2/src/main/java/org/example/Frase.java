package org.example;

import java.util.ArrayDeque;

public class Frase {
    private String textoOriginal;
    private ArrayDeque<ListaSimple> palabrasCola;

    public Frase(String textoOriginal) {
        this.textoOriginal = textoOriginal;
        this.palabrasCola = new ArrayDeque<>();
    }

    public void encriptar() {
        String[] palabras = textoOriginal.split(" ");
        for (String p : palabras) {
            ListaSimple lista = new ListaSimple();
            for (int i = 0; i < p.length(); i++) {
                int incremento = 1 + (i * 2);
                lista.insertar((int) p.charAt(i) + incremento);
            }
            lista.intercambiarPares();
            palabrasCola.addLast(lista);
        }
    }

    public String desencriptar() {
        StringBuilder sb = new StringBuilder();
        while (!palabrasCola.isEmpty()) {
            ListaSimple lista = palabrasCola.pollFirst();
            lista.intercambiarPares();

            Nodo temp = lista.cabeza;
            int i = 0;
            while (temp != null) {
                int incremento = 1 + (i * 2);
                sb.append((char) (temp.dato - incremento));
                temp = temp.siguiente;
                i++;
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}