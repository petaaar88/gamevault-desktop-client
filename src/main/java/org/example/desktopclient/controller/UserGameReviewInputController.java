package org.example.desktopclient.controller;

import javafx.geometry.Pos;
import org.example.desktopclient.component.TextInputComponent;

public class UserGameReviewInputController {
    private TextInputComponent component;
    private Integer gameId;
    private Integer userId;


    public UserGameReviewInputController(TextInputComponent component) {
        this.component = component;
        this.component.getRatingAndButtonHbox().getChildren().addFirst(this.component.getRatingComponent().getComponent());
        this.component.getRatingAndButtonHbox().setAlignment(Pos.CENTER);
        this.handleClick();
    }

    public void handleClick() {
        this.component.getSubmitButton().setOnMouseClicked(e -> {
            String reviewContent = this.component.getTextArea().getText().trim();

            if (reviewContent.isBlank())
                System.out.println("alo bre unesi review");
            else
                System.out.println(reviewContent);
        });
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
