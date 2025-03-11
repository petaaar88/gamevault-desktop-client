package org.example.desktopclient.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.example.desktopclient.model.game.GameOverview;
import org.example.desktopclient.model.game.RecentPlayedGameDTO;
import org.example.desktopclient.model.page.Pages;
import org.example.desktopclient.model.user.*;
import org.example.desktopclient.service.AbstractService;
import org.example.desktopclient.service.game.ErrorMessage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


public class UserService extends AbstractService {

    private final String API_URL = System.getenv("API_URL");

    public UserService() {
        super();
    }

    public void fetchUsers(Integer page, Integer limit, Integer userId, String username, Consumer<Pages<FriendDTO>> callback) {


        String encodedUsername;
        try {
            encodedUsername = URLEncoder.encode(username, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "search/" + userId.toString() + "?username=" + encodedUsername + "&page=" + page.toString() + "&limit=" + limit.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> parseJson(response, new TypeReference<Pages<FriendDTO>>() {
                }))
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

    public void fetchFriendRequest(Integer userId, Consumer<FriendRequestsDTO> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "requests/" + userId.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> parseJson(response, new TypeReference<FriendRequestsDTO>() {
                }))
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

    public void sendFriendRequest(Integer userId, Integer friendId, Consumer<String> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create(API_URL + "requests/send/" + userId.toString() + "/" + friendId.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {

                    if (response.statusCode() == 201)
                        return "Request Sent!";
                    else if (response.statusCode() == 409) {
                        ErrorMessage message = null;
                        try {
                            message = objectMapper.readValue(response.body(), new TypeReference<>() {
                            });
                            return message.getMessage();
                        } catch (JsonProcessingException e) {
                            System.out.println(e.getMessage());
                        }
                        return "Already Sent";
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

    public void deleteFriendRequest(Integer requestId, Consumer<String> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "requests/" + requestId.toString()))
                .DELETE()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 204)
                        return "Request Deleted!";
                    else
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

    public void acceptFriendRequest(Integer userId, Integer requestId, Consumer<String> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "requests/" + userId.toString() + "/" + requestId.toString()))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 201)
                        return "Request Accepted!";
                    else
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

    public void fetchAllFriends(Integer userId, Consumer<AllFriendsDTO> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "friends/" + userId.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> parseJson(response, new TypeReference<AllFriendsDTO>() {
                }))
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

    public void fetchUserDescription(Integer userId, Consumer<UserDescriptionDTO> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "profile/" + userId.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> parseJson(response, new TypeReference<UserDescriptionDTO>() {
                }))
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

    public void fetchUserRelationshipWithUser(Integer userId, Integer otherUserId, Consumer<String> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "relationship/" + userId.toString() + "/" + otherUserId.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
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

    public void fetchRecentPlayedGames(Integer userId, Integer page, Integer limit, Consumer<Pages<RecentPlayedGameDTO>> callback) {

        String url = API_URL + "profile/games/" + userId.toString();

        if (!Objects.isNull(page)) {
            url += "?page=" + page.toString();
            if (!Objects.isNull(limit))
                url += "&limit=" + limit.toString();

        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> parseJson(response, new TypeReference<Pages<RecentPlayedGameDTO>>() {
                }))
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

    public void doesUserHaveFriends(Integer userId, Consumer<Boolean> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "does-have-friends/" + userId.toString()))
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

    public void doesUserPostedCommentOnFriendProfile(Integer userId, Integer friendId, Consumer<Boolean> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "does-user-post-comment/" + userId.toString() + "/" + friendId.toString()))
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

    public void postCommentOnFriendProfile(Integer userId, Integer friendId, CreateCommentDTO newComment, Consumer<String> callback) {

        try {
            String json = new ObjectMapper().writeValueAsString(newComment);

            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .uri(URI.create(API_URL + "profile/comments/" + userId.toString() + "/" + friendId.toString()))
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> {

                        if (response.statusCode() == 201)
                            return "Friend Comment Added!";
                        else if (response.statusCode() == 404) {
                            ErrorMessage message = null;
                            try {
                                message = objectMapper.readValue(response.body(), new TypeReference<>() {
                                });
                            } catch (JsonProcessingException e) {
                                System.out.println(e.getMessage());
                            }
                            return message.getMessage();
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
            throw new RuntimeException(e);
        }
    }

    public void fetchAllCommentsOnUserProfile(Integer userId, Integer page, Integer limit, Consumer<Pages<FriendCommentDTO>> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "profile/comments/" + userId.toString() + "?page=" + page.toString() + "&limit=" + limit.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> parseJson(response, new TypeReference<Pages<FriendCommentDTO>>() {
                }))
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

    public void doesHaveComments(Integer userId, Consumer<Boolean> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "does-have-comments/" + userId.toString()))
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

    public void updateUser(Integer userId, UpdateUserDTO updateUserDTO, Consumer<String> callback) {

        String serverUrl = API_URL + "profile/" + userId.toString();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPatch uploadFile = new HttpPatch(serverUrl);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.STRICT);

            if (!Objects.isNull(updateUserDTO.getIcon()))
                builder.addPart("profileImage", new FileBody(updateUserDTO.getIcon()));

            builder.addPart("username", new StringBody(updateUserDTO.getUsername(), ContentType.create("text/plain", StandardCharsets.UTF_8)));
            builder.addPart("description", new StringBody(updateUserDTO.getDescription(), ContentType.create("text/plain", StandardCharsets.UTF_8)));

            uploadFile.setEntity(builder.build());


            try (CloseableHttpResponse response = httpClient.execute(uploadFile)) {

                String message = null;

                if (response.getCode() == 204)
                    message = "Profile Updated!";
                else if (response.getCode() == 409)
                    message = "Username Already Taken!";
                else if (response.getCode() == 400) {
                    ErrorMessageUser errorMessage = objectMapper.readValue(response.getEntity().getContent(), ErrorMessageUser.class);
                    if (errorMessage.getDescription() != null)
                        message = errorMessage.getDescription();
                    if (errorMessage.getUsername() != null)
                        message = errorMessage.getUsername();
                }

                callback.accept(message);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loginUser(LoginUserDTO loginUserDTO, Consumer<FriendDTO> callback) {
        String json;
        try {
            json = objectMapper.writeValueAsString(loginUserDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing login data", e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "login"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 200) {
                        return parseLoginUser(response.body());
                    } else {
                        System.out.println(response.body());
                        showAlert("Wrong Credetials!");
                        return null;
                    }
                })
                .thenAccept(result -> {
                    if (result != null) {
                        callback.accept(result);
                    } else {
                        System.out.println("Login unsuccessful, callback not called.");
                    }
                })
                .exceptionally(e -> {
                    if (e.getCause() instanceof ConnectException) {
                        System.out.println("Could not connect to server!");
                    } else {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    public void logoutUser(Integer userId, Consumer<String> callback) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "logout/" + userId.toString()))
                .DELETE()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
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

    public void registerUser(RegisterUserDTO registerUserDTO, Consumer<String> callback) {
        String serverUrl = API_URL + "register";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost uploadFile = new HttpPost(serverUrl);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.STRICT);

            if (!Objects.isNull(registerUserDTO.getIcon()))
                builder.addPart("profileImage", new FileBody(registerUserDTO.getIcon()));

            builder.addPart("username", new StringBody(registerUserDTO.getUsername(), ContentType.create("text/plain", StandardCharsets.UTF_8)));
            builder.addPart("password", new StringBody(registerUserDTO.getPassword(), ContentType.create("text/plain", StandardCharsets.UTF_8)));

            uploadFile.setEntity(builder.build());


            try (CloseableHttpResponse response = httpClient.execute(uploadFile)) {

                String message = null;

                if (response.getCode() == 409)
                    message = "Username Already Taken!";

                if (response.getCode() == 204)
                    message = "Profile Created!";
                else if (response.getCode() == 400) {
                    ErrorMessageUser errorMessage = objectMapper.readValue(response.getEntity().getContent(), ErrorMessageUser.class);
                    if (errorMessage.getDescription() != null)
                        message = errorMessage.getDescription();
                    if (errorMessage.getUsername() != null)
                        message = errorMessage.getUsername();
                }

                callback.accept(message);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private FriendDTO parseLoginUser(String json) {
        try {
            return objectMapper.readValue(json, FriendDTO.class);
        } catch (JsonProcessingException e) {
            try {
                ErrorMessage message = objectMapper.readValue(json, ErrorMessage.class);
                System.out.println("Error message from server: " + message.getMessage());
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

    public void showAlert(String message) {
        Platform.runLater(()->{
            Stage alertStage = new Stage();
            alertStage.initStyle(StageStyle.UNDECORATED); // Uklanja naslovnu traku
            alertStage.initModality(Modality.APPLICATION_MODAL); // Blokira interakciju sa glavnim prozorom dok je alert otvoren

            // Tekst poruke
            Label alertText = new Label(message);
            alertText.setStyle("-fx-font-size: 25px;-fx-text-fill: white");

            // Dugme za zatvaranje
            Button closeButton = new Button("OK");
            closeButton.setStyle("-fx-background-color: #0084FF;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:14px;-fx-padding: 5 14 5 14;-fx-font-weight:700");
            closeButton.setOnAction(ec -> alertStage.close());

            // Pravljenje layout-a
            VBox alertLayout = new VBox(10, alertText, closeButton);
            alertLayout.setAlignment(Pos.CENTER);
            alertLayout.setStyle("-fx-background-color: #191B2E;-fx-border-color:#333352;-fx-border-width: 2px; -fx-padding: 25px 50px 25px 50px;");

            Scene alertScene = new Scene(alertLayout);
            alertScene.setFill(Color.TRANSPARENT); // Ako želiš prozirnu pozadinu

            alertStage.setScene(alertScene);
            alertStage.showAndWait();
        });

    }
}
