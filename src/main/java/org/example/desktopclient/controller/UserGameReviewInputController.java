package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.TextInputComponent;
import org.example.desktopclient.model.game.CreateGameReviewDTO;
import org.example.desktopclient.service.game.GameService;

public class UserGameReviewInputController {
    private TextInputComponent component;
    private RatingController ratingController;
    private Integer gameId;
    private Integer userId;
    private GameService gameService;


    public UserGameReviewInputController(TextInputComponent component) {
        this.gameService = new GameService();
        this.component = component;
        this.component.getRatingAndButtonHbox().getChildren().addFirst(this.component.getRatingComponent().getComponent());
        this.component.getRatingAndButtonHbox().setAlignment(Pos.CENTER);
        ratingController = new RatingController(this.component.getRatingComponent());

    }

    public void handleClick() {
        this.component.getSubmitButton().setOnMouseClicked(e -> {
            String reviewContent = this.component.getTextArea().getText().trim();

            boolean isRatingSelected = this.ratingController.getRatingButtonControllers().stream().filter(ratingController -> ratingController.getComponent().getIsSelected()).findFirst().isPresent();

            if (!isRatingSelected) {
                showAlert("Choose rating!");
            } else {
                if (!reviewContent.isBlank()) {
                    String rating = this.ratingController.getRatingButtonControllers().stream().filter(ratingController -> ratingController.getComponent().getIsSelected()).findFirst().get().getComponent().getNameForJson();
                    CreateGameReviewDTO createGameReviewDTO = new CreateGameReviewDTO(rating,reviewContent);

                    gameService.postReviewForGame(userId,gameId,createGameReviewDTO,callback->{
                        Platform.runLater(()->{
                            showAlert(callback);
                        });
                    });
                } else
                    showAlert("Enter review!");

            }


        });
    }

    public void showAlert(String message) {
        Stage alertStage = new Stage();
        alertStage.initStyle(StageStyle.UNDECORATED); // Uklanja naslovnu traku
        alertStage.initModality(Modality.APPLICATION_MODAL); // Blokira interakciju sa glavnim prozorom dok je alert otvoren

        // Tekst poruke
        Label alertText = new Label(message);
        alertText.setStyle("-fx-font-size: 25px;-fx-text-fill: white");

        // Dugme za zatvaranje
        Button closeButton = new Button("OK");
        closeButton.setStyle("-fx-background-color: #0084FF;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:14px;-fx-padding: 5 14 5 14;-fx-font-weight:700");
        closeButton.setOnAction(ec -> alertStage.close());

        // Pravljenje layout-a
        VBox alertLayout = new VBox(10, alertText, closeButton);
        alertLayout.setAlignment(Pos.CENTER);
        alertLayout.setStyle("-fx-background-color: #191B2E;-fx-border-color:#333352;-fx-border-width: 2px; -fx-padding: 25px 50px 25px 50px;");

        Scene alertScene = new Scene(alertLayout);
        alertScene.setFill(Color.TRANSPARENT); // Ako želiš prozirnu pozadinu

        alertStage.setScene(alertScene);
        alertStage.showAndWait();
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public TextInputComponent getComponent() {
        return component;
    }

    public void setComponent(TextInputComponent component) {
        this.component = component;
    }
}
