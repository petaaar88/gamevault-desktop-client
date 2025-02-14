package org.example.desktopclient.model.game;

import java.util.Map;

public class GameReviewDTO {
    private String content;
    private String rating;
    private String postedOn;
    private Map<String, String> user;

    public GameReviewDTO() {
    }

    public GameReviewDTO(String content, String rating, String postedOn, Map<String, String> user) {
        this.content = content;
        this.rating = rating;
        this.postedOn = postedOn;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(String postedOn) {
        this.postedOn = postedOn;
    }

    public Map<String, String> getUser() {
        return user;
    }

    public void setUser(Map<String, String> user) {
        this.user = user;
    }
}
