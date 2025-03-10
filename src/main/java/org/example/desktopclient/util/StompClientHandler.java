package org.example.desktopclient.util;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class StompClientHandler extends StompSessionHandlerAdapter {
    public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
        System.out.println("Konektovan na server!");
    }
}
