package org.example;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        // 1. OBTENER LA FRASE
        System.out.println(">>> Conectando con el servidor de frases...");
        String fraseAPI = ClienteAPI.obtenerFrase();
        System.out.println(">>> Frase recibida: " + fraseAPI);

        // 2. PROCESAR (ENCRIPTAR)
        Frase parcial = new Frase(fraseAPI);

        long inicio = System.nanoTime();
        parcial.encriptar();
        long fin = System.nanoTime();

        // 3. RECUPERAR (DESENCRIPTAR)
        String resultado = parcial.desencriptar();

        System.out.println("\n--- RESULTADOS DEL EXAMEN ---");
        System.out.println("Tiempo de ejecucion: " + (fin - inicio) + " ns");
        System.out.println("Texto recuperado: " + resultado);

        // 4. GENERAR ARCHIVO
        if (fraseAPI.equalsIgnoreCase(resultado)) {
            guardarEnArchivo(fraseAPI, resultado);
        }
    }

    public static void guardarEnArchivo(String orig, String recu) {
        try {
            PrintWriter escritor = new PrintWriter("resultado.txt");
            escritor.println("REPORTE FINAL DEL PARCIAL");
            escritor.println("==========================");
            escritor.println("Original: " + orig);
            escritor.println("Recuperado: " + recu);
            escritor.close();
            System.out.println("\n[EXITO] Se ha creado el archivo 'resultado.txt'");
        } catch (Exception e) {
            System.out.println("Error: No se pudo guardar el reporte.");
        }
    }
}