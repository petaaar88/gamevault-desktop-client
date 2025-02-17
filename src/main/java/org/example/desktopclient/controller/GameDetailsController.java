package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.text.Text;
import org.example.desktopclient.component.GameDetailsComponent;
import org.example.desktopclient.service.game.GameService;
import org.example.desktopclient.util.CustomDateFormatter;

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
            Platform.runLater(() -> {

                component.getGameDescriptionLabel().setText(gameDescriptionDTO.getDescription());

                component.getReleaseDateText().setText(CustomDateFormatter.formatDateOfPattern(gameDescriptionDTO.getRelease(),"d. MMM yyyy"));

                component.getGameDeveloperNameText().setText(gameDescriptionDTO.getDeveloper());
                component.getGameGenresController().setContent(gameDescriptionDTO.getGenres());

                gameService.fetchOverallRating(gameId, gameOverallRatingDTO -> {
                    Platform.runLater(() -> {


                        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
                        Integer reviewNumberInteger = gameOverallRatingDTO.getNumberOfReviews();
                        component.getReviewNumber().setText(("(" + nf.format(reviewNumberInteger) + ")"));
                        String rating = gameOverallRatingDTO.getRating();

                        String reviewTextTypeString;


                        if (rating == null) {
                            rating = "TBO";
                            reviewTextTypeString = "mixed";
                        } else {
                            reviewTextTypeString = rating.toLowerCase();
                        }
                        component.getReview().setText(rating);

                        reviewTextTypeString = reviewTextTypeString.toLowerCase().replace(' ', '_');

                        String reviewTextClass = "game-description-review-" + reviewTextTypeString + "-color";
                        component.getReview().getStyleClass().removeLast();
                        component.getReview().getStyleClass().add(reviewTextClass);
                    });

                });

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
