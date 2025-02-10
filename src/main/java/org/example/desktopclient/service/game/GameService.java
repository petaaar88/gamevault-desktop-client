package org.example.desktopclient.service.game;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.desktopclient.model.game.GameDescriptionDTO;
import org.example.desktopclient.model.game.GameOverallRatingDTO;
import org.example.desktopclient.model.game.GameOverview;
import org.example.desktopclient.model.page.Pages;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class GameService {
    private HttpClient client;
    private ObjectMapper objectMapper;

    public GameService() {
        this.client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public void fetchGames(Integer page, Integer limit, String title, Consumer<Pages<GameOverview>> callback) {

        String gameTitle;
        try {
            gameTitle = URLEncoder.encode(title, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games?page=" + page.toString() + "&limit=" + limit.toString() + "&title=" + gameTitle))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseFetchGamesJson)
                .thenAccept(callback)
                .exceptionally(e -> {
                    if (e.getCause() instanceof ConnectException) {
                        System.out.println("Could not connect to server!");

                    } else {
                        e.printStackTrace();

                    }
                    return null;
                });

    }

    public void fetchGameDescriptionForProductPage(Integer gameId,Consumer<GameDescriptionDTO> callback){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" +gameId.toString()+"/description"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseFetchGameDescriptionProductPage)
                .thenAccept(callback)
                .exceptionally(e -> {
                    if (e.getCause() instanceof ConnectException) {
                        System.out.println("Could not connect to server!");

                    } else {
                        e.printStackTrace();

                    }
                    return null;
                });
    }

    public void fetchOverallRating(Integer gameId, Consumer<GameOverallRatingDTO> callback){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" +gameId.toString()+"/overal-rating"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseOverallRating)
                .thenAccept(callback)
                .exceptionally(e -> {
                    if (e.getCause() instanceof ConnectException) {
                        System.out.println("Could not connect to server!");

                    } else {
                        e.printStackTrace();

                    }
                    return null;
                });
    }

    private Pages<GameOverview> parseFetchGamesJson(String json) {
        try {
            Pages<GameOverview> games = objectMapper.readValue(json, new TypeReference<>() {
            });
            return games;
        } catch (JsonProcessingException e) {
            try {
                ErrorMessage message = objectMapper.readValue(json, new TypeReference<>() {
                });
                System.out.println(message.getMessage());
                return null;
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
                return null;
            }

        }
    }

    private GameDescriptionDTO parseFetchGameDescriptionProductPage(String json){
        try {
            System.out.println(json);
            GameDescriptionDTO gameDescriptionDTO = objectMapper.readValue(json, new TypeReference<>() {
            });
            return gameDescriptionDTO;
        } catch (JsonProcessingException e) {
            try {
                ErrorMessage message = objectMapper.readValue(json, new TypeReference<>() {
                });
                System.out.println(message.getMessage());
                return null;
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
                return null;
            }

        }
    }

    private GameOverallRatingDTO parseOverallRating(String json){
        try {
            System.out.println(json);
            GameOverallRatingDTO overallRating = objectMapper.readValue(json, new TypeReference<>() {
            });
            return overallRating;
        } catch (JsonProcessingException e) {
            try {
                ErrorMessage message = objectMapper.readValue(json, new TypeReference<>() {
                });
                System.out.println(message.getMessage());
                return null;
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
                return null;
            }

        }
    }

}
