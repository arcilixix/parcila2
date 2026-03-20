package org.example;
import java.util.ArrayDeque;

public class Frase {
    private String textoOriginal;
    private ArrayDeque<ListaSimple> palabrasCola; // Soporte Fase 1

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
                int valorAscii = (int) p.charAt(i) + incremento;
                lista.insertar(valorAscii);
            }
            lista.intercambiarPares();
            // Paso 3: Almacenar en ArrayDeque
            palabrasCola.addLast(lista);
        }
    }

    public ArrayDeque<ListaSimple> getPalabrasCola() {
        return palabrasCola;
    }
}