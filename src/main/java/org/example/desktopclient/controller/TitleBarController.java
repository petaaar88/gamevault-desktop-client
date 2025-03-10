package org.example.desktopclient.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.TitleBarComponent;
import org.example.desktopclient.service.user.UserService;

public class TitleBarController {
    private TitleBarComponent component;

    public TitleBarController(TitleBarComponent component) {
        this.component = component;
    }

    public void handleCloseButtonClick(Integer userId) {
        component.getCloseButton().setOnMouseClicked(e -> {

            showAlert("Are you sure you want to exit?", userId);
        });
    }

    public void showAlert(String message, Integer userId) {
        Stage alertStage = new Stage();
        alertStage.initStyle(StageStyle.UNDECORATED); // Uklanja naslovnu traku
        alertStage.initModality(Modality.APPLICATION_MODAL); // Blokira interakciju sa glavnim prozorom dok je alert otvoren

        // Tekst poruke
        Label alertText = new Label(message);
        alertText.setStyle("-fx-font-size: 25px;-fx-text-fill: white");

        // Dugme za zatvaranje
        Button closeButton = new Button("Cancel");
        closeButton.setStyle("-fx-background-color: #0084FF;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:14px;-fx-padding: 5 14 5 14;-fx-font-weight:700");
        closeButton.setOnAction(ec -> alertStage.close());

        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-background-color: red;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:14px;-fx-padding: 5 14 5 14;-fx-font-weight:700");

        exitButton.setOnMouseClicked(e->{

            UserService userService = new UserService();

            userService.logoutUser(userId, c -> {
                System.exit(0);
            });
        });

        HBox hBox = new HBox(exitButton,closeButton);

        hBox.setSpacing(25);
        hBox.setAlignment(Pos.CENTER);

        // Pravljenje layout-a
        VBox alertLayout = new VBox(10, alertText, hBox);
        alertLayout.setAlignment(Pos.CENTER);
        alertLayout.setStyle("-fx-background-color: #191B2E;-fx-border-color:#333352;-fx-border-width: 2px; -fx-padding: 25px 50px 25px 50px;");

        Scene alertScene = new Scene(alertLayout);
        alertScene.setFill(Color.TRANSPARENT); // Ako želiš prozirnu pozadinu

        alertStage.setScene(alertScene);
        alertStage.showAndWait();
    }
}
