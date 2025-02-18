package org.example.desktopclient.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.desktopclient.model.game.GameOverview;
import org.example.desktopclient.model.game.RecentPlayedGameDTO;
import org.example.desktopclient.model.page.Pages;
import org.example.desktopclient.model.user.AllFriendsDTO;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.model.user.FriendRequestsDTO;
import org.example.desktopclient.model.user.UserDescriptionDTO;
import org.example.desktopclient.service.AbstractService;
import org.example.desktopclient.service.game.ErrorMessage;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


public class UserService extends AbstractService {

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
                .uri(URI.create("http://localhost:8080/search/" + userId.toString() + "?username=" + encodedUsername + "&page=" + page.toString() + "&limit=" + limit.toString()))
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
                .uri(URI.create("http://localhost:8080/requests/" + userId.toString()))
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
                .uri(URI.create("http://localhost:8080/requests/send/" + userId.toString() + "/" + friendId.toString()))
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
                .uri(URI.create("http://localhost:8080/requests/" + requestId.toString()))
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
                .uri(URI.create("http://localhost:8080/requests/" + userId.toString() + "/" + requestId.toString()))
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
                .uri(URI.create("http://localhost:8080/friends/" + userId.toString()))
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
                .uri(URI.create("http://localhost:8080/profile/" + userId.toString()))
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
                .uri(URI.create("http://localhost:8080/relationship/" + userId.toString() + "/" + otherUserId.toString()))
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

        String url = "http://localhost:8080/profile/games/" + userId.toString();

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

}
