package org.example.desktopclient.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.desktopclient.component.Notification;
import org.example.desktopclient.model.user.FriendDTO;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.sockjs.frame.Jackson2SockJsMessageCodec;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StompClient {

    private String connectionUrl;
    private Integer userId;
    private final static WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

    public StompClient(String connectionUrl, Integer userId) {
        this.connectionUrl = connectionUrl;
        this.userId = userId;
    }

    public ListenableFuture<StompSession> connect() {

        Transport webSocketTransport = new WebSocketTransport(new StandardWebSocketClient());
        List<Transport> transports = Collections.singletonList(webSocketTransport);

        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.setMessageCodec(new Jackson2SockJsMessageCodec());

        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);

        String url = connectionUrl;
        return stompClient.connect(url, headers, new StompClientHandler(), "localhost", 8080);
    }

    public void subscribe(StompSession stompSession, List<String> themes) throws ExecutionException, InterruptedException {

        themes.forEach(theme -> {
            String themeUrl = theme + "/" + userId.toString();
            stompSession.subscribe(themeUrl, new StompFrameHandler() {

                public Type getPayloadType(StompHeaders stompHeaders) {
                    return byte[].class;
                }

                public void handleFrame(StompHeaders stompHeaders, Object payload) {
                    byte[] bytes = (byte[]) payload;
                    String json = new String(bytes, StandardCharsets.UTF_8);

                    ObjectMapper objectMapper = new ObjectMapper();
                    FriendDTO friend = null;

                    try {
                        friend = objectMapper.readValue(json, FriendDTO.class);
                        switch (theme){
                            case "/user-online-notification":
                                System.out.println("Friend is online: " + friend);
                                Notification.showOnlineNotification(friend.getIcon(), friend.getUsername());
                                break;
                            case "/friend-request-notification":
                                System.out.println("Friend Request received : " + friend);
                                Notification.showFriendRequestNotification(friend.getIcon(), friend.getUsername());
                                break;
                            case "/friend-entered-game-notification":
                                System.out.println("Friend entered game: " + friend);
                                Notification.showEnterGameNotification(friend.getIcon(), friend.getUsername(), friend.getInGame());
                                break;
                            default:
                                break;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });

        });
    }


}


