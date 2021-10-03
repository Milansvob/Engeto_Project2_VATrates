package com.example.Main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CallAppi {

    // A tady v metodě callApi
    public String callApi() throws IOException, InterruptedException {
        //vytvoříme Http klienta. Tak, že zavoláme metodu HttpClient.newBuilder().build().
        // HTTP klienta si můžu představit jako prohlížeč (bez zobrazování), to co stáhne ty data
        HttpClient httpClient = HttpClient.newBuilder().build();

        // a teď potřebujeme vytvořit requst a zase pomocí buildera
        // nastavit URI
        // A specifikovat typ volání GET
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://euvatrates.com/rates.json")).GET().build();

        // a teď potřebujeme ten httpRequest zavolat
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code" + httpResponse.statusCode());
        System.out.println("Body" + httpResponse.body());

        return httpResponse.body();
    }

}
