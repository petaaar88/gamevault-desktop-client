package org.example.desktopclient.controller;

import javafx.scene.text.Text;
import org.example.desktopclient.component.GameDetailsComponent;
import org.example.desktopclient.service.game.GameService;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GameDetailsController {
    private GameDetailsComponent component;
    private Integer gameId;
    private GameService gameService;

    public GameDetailsController(GameDetailsComponent component) {
        this.component = component;
        gameService = new GameService();
    }

    public void setContent() {

        gameService.fetchGameDescriptionForProductPage(gameId, gameDescriptionDTO -> {
            component.getGameDescriptionLabel().setText(gameDescriptionDTO.getDescription());
            String dateString = gameDescriptionDTO.getRelease();

            // Parsiranje stringa u LocalDate
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateString, inputFormatter);

            // Formatiranje u željeni izlazni format
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d. MMM yyyy", Locale.ENGLISH);
            String formattedDate = date.format(outputFormatter);
            component.getReleaseDateText().setText(formattedDate);

            component.getGameDeveloperNameText().setText(gameDescriptionDTO.getDeveloper());
            gameService.fetchOverallRating(gameId, gameOverallRatingDTO -> {
                NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
                Integer reviewNumberInteger = gameOverallRatingDTO.getNumberOfReviews();
                component.getReviewNumber().setText(("(" + nf.format(reviewNumberInteger) + ")"));
                String rating = gameOverallRatingDTO.getRating();

                String reviewTextTypeString;


                if(rating == null){
                    rating = "TBO";
                    reviewTextTypeString = "mixed";
                }
                else{
                    reviewTextTypeString = rating.toLowerCase();
                }
                component.getReview().setText(rating);

                reviewTextTypeString = reviewTextTypeString.toLowerCase().replace(' ','_');

                String reviewTextClass = "game-description-review-" + reviewTextTypeString + "-color";
                component.getReview().getStyleClass().removeLast();
                component.getReview().getStyleClass().add(reviewTextClass);

            });



        });

    }

    public GameDetailsComponent getComponent() {
        return component;
    }

    public void setComponent(GameDetailsComponent component) {
        this.component = component;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
