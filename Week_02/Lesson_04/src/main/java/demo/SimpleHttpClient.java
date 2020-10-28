package demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SimpleHttpClient {
    public static void main(String[] args) throws Exception {
        SimpleHttpClient simpleHttpClient = new SimpleHttpClient();
        String url = "http://localhost:8808/test";
        //String url = "http://localhost:8801";
        int counter = 0;
        while (counter < 100) {
            counter = counter + 1;
            Thread.sleep(300);
            System.out.println(simpleHttpClient.get(url));
        }
    }


    public String get(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
