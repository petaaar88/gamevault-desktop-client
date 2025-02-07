package org.example.desktopclient.model.game;


import java.math.BigInteger;
import java.util.Map;

public class GameOverview {

    Integer id;
    String title;
    String imageUrl;
    BigInteger acquisitions;
    String developer;
    Map<String, String> rating;

    public GameOverview() {
    }

    public GameOverview(Integer id, String title, String imageUrl, BigInteger acquisitions, String developer, Map<String, String> rating) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.acquisitions = acquisitions;
        this.developer = developer;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigInteger getAcquisitions() {
        return acquisitions;
    }

    public void setAcquisitions(BigInteger acquisitions) {
        this.acquisitions = acquisitions;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Map<String, String> getRating() {
        return rating;
    }

    public void setRating(Map<String, String> rating) {
        this.rating = rating;
    }
}
