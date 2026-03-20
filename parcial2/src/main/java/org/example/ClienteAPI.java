package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteAPI {
    public static String obtenerFrase() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://zenquotes.io/api/random"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();
            int inicio = body.indexOf("\"q\":\"") + 5;
            int fin = body.indexOf("\",\"a\"");

            return body.substring(inicio, fin);
        } catch (Exception e) {
            return "ERROR AL CONECTAR CON LA API";
        }
    }
}
