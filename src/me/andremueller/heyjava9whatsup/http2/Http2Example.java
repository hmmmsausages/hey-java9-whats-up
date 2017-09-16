package me.andremueller.heyjava9whatsup.http2;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Http2Example {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.
                newBuilder()
                .uri(new URI("http://www.zuhlke.com"))
                .GET()
                .build();


        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());

        System.out.println("Headers: "+response.headers());
        System.out.println("Body: "+response.body());
    }
}