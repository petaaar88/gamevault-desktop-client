package org.example.desktopclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.example.desktopclient.model.user.CreateCommentDTO;
import org.example.desktopclient.service.game.ErrorMessage;
import org.example.desktopclient.service.user.UserService;

public class FriendCommentInputController {
    private TextInputComponent component;
    private Integer userId;
    private Integer friendId;
    private UserService userService;


    public FriendCommentInputController(TextInputComponent component, Integer userId, Integer friendId) {
        this.component = component;
        this.userId = userId;
        this.friendId = friendId;
        userService = new UserService();
    }

    public void handleClick() {
        component.getSubmitButton().setOnMouseClicked(e->{
            String comment = component.getTextArea().getText().trim();

            if (comment.isBlank() || comment.isEmpty()) {
                showAlert("Enter comment!");
            }
            else{
                userService.postCommentOnFriendProfile(userId, friendId, new CreateCommentDTO(comment), response -> {
                    Platform.runLater(()->{
                        showAlert(response);
                    });
                });
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

    public TextInputComponent getComponent() {
        return component;
    }

    public void setComponent(TextInputComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
