package org.example;

public class Main {
    public static void main(String[] args) {
        String fraseAPI = ClienteAPI.obtenerFrase();
        System.out.println("Frase de la API: " + fraseAPI);

        Frase parcial = new Frase(fraseAPI);

        parcial.encriptar();

        System.out.println("--- FASE 1 COMPLETADA ---");
        System.out.println("La frase ha sido procesada, rotada y guardada en el ArrayDeque.");
    }
}