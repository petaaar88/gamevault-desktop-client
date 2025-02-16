package org.example.desktopclient.service.user;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.desktopclient.model.game.GameOverview;
import org.example.desktopclient.model.page.Pages;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.service.AbstractService;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
}
