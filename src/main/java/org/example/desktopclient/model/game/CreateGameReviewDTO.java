package org.example.desktopclient.model.game;

public class CreateGameReviewDTO {
    String rating;
    String content;

    public CreateGameReviewDTO() {
    }

    public CreateGameReviewDTO(String rating, String content) {
        this.rating = rating;
        this.content = content;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
