package org.example.desktopclient.service.game;

public class ErrorMessage {
    String message;

    public ErrorMessage() {

    }
    public ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

