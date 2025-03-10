package com.todoapi.in;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TMDBClient {
    private static final String API_KEY = "551f2aa3dc8b7568dc1e718abd48d897";
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    public static String fetchMovies(String type) {
        System.setProperty("https.protocols", "TLSv1.2");

        String url = BASE_URL + type + "?api_key=" + API_KEY;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            return "Error fetching data: " + e.getMessage();
        }
    }
}
