package org.example.desktopclient.service.game;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.desktopclient.model.game.*;
import org.example.desktopclient.model.page.Pages;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.service.AbstractService;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.function.Consumer;

public class GameService extends AbstractService {

    public GameService() {
        super();
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

    public void fetchGameDescriptionForProductPage(Integer gameId, Consumer<GameDescriptionDTO> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/description"))
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

    public void fetchGameProductPageImages(Integer gameId, Consumer<GameProductPageImages> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/pp-images"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseProductPageImages)
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

    public void fetchOverallRating(Integer gameId, Consumer<GameOverallRatingDTO> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/overal-rating"))
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

    public void fetchSystemRequirements(Integer gameId, Consumer<GameSystemRequirementsDTO> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/system-requirements"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseSystemRequirements)
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

    public void doesUserHaveGame(Integer userId, Integer gameId, Consumer<Boolean> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + userId.toString() + "/" + gameId.toString() + "/has-game"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> Boolean.valueOf(response))
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

    public void doesUserHaveFriendsThatPlayGame(Integer userId, Integer gameId, Consumer<Boolean> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + userId.toString() + "/" + gameId.toString() + "/has-friends-that-own-game"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> Boolean.valueOf(response))
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

    public void doesUserHaveReviewOnGame(Integer userId, Integer gameId, Consumer<Boolean> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/" + userId.toString() + "/has-review"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> Boolean.valueOf(response))
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

    public void doesGameHaveReviews(Integer gameId, Consumer<Boolean> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/has-reviews"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> Boolean.valueOf(response))
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

    public void addGameToUserCollection(Integer userId, Integer gameId, Consumer<String> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/" + userId.toString()))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {

                    if (response.statusCode() == 201)
                        return "Game added to collection!";
                    else if (response.statusCode() == 409) {
                        ErrorMessage message = null;
                        try {
                            message = objectMapper.readValue(response.body(), new TypeReference<>() {
                            });
                        } catch (JsonProcessingException e) {
                            System.out.println(e.getMessage());
                        }
                        return "Already In Collection!";
                    } else
                        return "Error";
                })
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

    public void fetchAllFriendsThatPlayGame(Integer userId, Integer gameId, Consumer<List<FriendDTO>> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/" + userId.toString() + "/friends"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseFriendsThatPlayGame)
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

    public void postReviewForGame(Integer userId, Integer gameId, CreateGameReviewDTO reviewDTO, Consumer<String> callback) {

        try {
            String json = new ObjectMapper().writeValueAsString(reviewDTO);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/" + userId.toString() + "/reviews"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> {

                        if (response.statusCode() == 201)
                            return "Game review added!";
                        else if (response.statusCode() == 404) {
                            ErrorMessage message = null;
                            try {
                                message = objectMapper.readValue(response.body(), new TypeReference<>() {
                                });
                            } catch (JsonProcessingException e) {
                                System.out.println(e.getMessage());
                            }
                            return "Already posted!";
                        } else {
                            System.out.println(response.statusCode());
                            return "Error";
                        }
                    })
                    .thenAccept(callback)
                    .exceptionally(e -> {
                        if (e.getCause() instanceof ConnectException) {
                            System.out.println("Could not connect to server!");
                        } else {
                            e.printStackTrace();
                        }
                        return null;
                    });


        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }


    }

    public void fetchGamerReviews(Integer gameId, Integer page, Integer limit, Consumer<Pages<GameReviewDTO>> callback) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/" + gameId.toString() + "/reviews?page=" + page.toString() + "&limit=" + limit.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseGamerReviews)
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

    public void fetchUserGameCollection(Integer userId, Consumer<List<GameInCollectionDTO>>callback){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/collection/" + userId.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseUserGameCollection)
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

    public void fetchGameInUserCollection(Integer userId, Integer gameId, Consumer<GameInUserCollectionDetails> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games/collection/" + userId.toString() + "/" + gameId.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseGameInUserCollection)
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

    public GameInUserCollectionDetails parseGameInUserCollection(String json) {
        try {
            GameInUserCollectionDetails game = objectMapper.readValue(json, new TypeReference<>() {
            });
            return game;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<GameInCollectionDTO> parseUserGameCollection(String json) {
        try {
            List<GameInCollectionDTO> games = objectMapper.readValue(json, new TypeReference<>() {
            });
            return games;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Pages<GameReviewDTO> parseGamerReviews(String json) {
        try {
            Pages<GameReviewDTO> reviews = objectMapper.readValue(json, new TypeReference<>() {
            });
            return reviews;
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

    public List<FriendDTO> parseFriendsThatPlayGame(String json) {
        try {
            List<FriendDTO> friends = objectMapper.readValue(json, new TypeReference<>() {
            });
            return friends;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public GameSystemRequirementsDTO parseSystemRequirements(String json) {
        try {
            GameSystemRequirementsDTO systemRequirements = objectMapper.readValue(json, new TypeReference<>() {
            });
            return systemRequirements;
        } catch (JsonProcessingException e) {
            return null;
        }
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

    private GameDescriptionDTO parseFetchGameDescriptionProductPage(String json) {
        try {
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

    private GameOverallRatingDTO parseOverallRating(String json) {
        try {
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

    private GameProductPageImages parseProductPageImages(String json) {
        try {
            GameProductPageImages productPageImages = objectMapper.readValue(json, new TypeReference<>() {
            });
            return productPageImages;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
