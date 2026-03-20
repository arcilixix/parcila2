package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteAPI {
    public static String obtenerFrase() {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create("https://zenquotes.io/api/random"))
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            String cuerpo = respuesta.body();

            int inicio = cuerpo.indexOf("\"q\":\"") + 5;
            int fin = cuerpo.indexOf("\",\"a\"");

            return cuerpo.substring(inicio, fin);
        } catch (Exception e) {
            // Si no hay internet o falla la API, devolvemos esta:
            return "El exito es la suma de pequenos esfuerzos";
        }
    }
}