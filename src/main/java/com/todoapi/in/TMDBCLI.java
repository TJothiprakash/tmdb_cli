package com.todoapi.in;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TMDBCLI {
    public static void main(String[] args) {
        if (args.length < 2 || !args[0].equals("--type")) {
            System.out.println("Usage: java -jar tmdb-cli.jar --type [playing|popular|top|upcoming]");
            return;
        }

        String type = switch (args[1]) {
            case "playing" -> "now_playing";
            case "popular" -> "popular";
            case "top" -> "top_rated";
            case "upcoming" -> "upcoming";
            default -> throw new IllegalArgumentException("Invalid type");
        };

        String response = TMDBClient.fetchMovies(type);
        printMovies(response);
    }

    private static void printMovies(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode movies = root.get("results");

            for (JsonNode movie : movies) {
                System.out.println("Title: " + movie.get("title").asText());
                System.out.println("Release Date: " + movie.get("release_date").asText());
                System.out.println("Rating: " + movie.get("vote_average").asDouble());
                System.out.println("-----------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}
