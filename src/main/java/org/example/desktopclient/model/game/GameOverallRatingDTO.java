package org.example.desktopclient.model.game;

import java.math.BigInteger;

public class GameOverallRatingDTO {
    String rating;
    Integer numberOfReviews;

    public GameOverallRatingDTO() {
    }

    public GameOverallRatingDTO(String rating, Integer numberOfReviews) {
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
