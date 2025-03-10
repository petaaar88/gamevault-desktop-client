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
import org.example.desktopclient.component.LoginMainComponent;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.model.user.LoginUserDTO;
import org.example.desktopclient.service.user.UserService;
import org.example.desktopclient.util.Initializer;

import java.util.Objects;

public class LoginMainController {
    private LoginMainComponent component;
    private PasswordController passwordController;
    private Stage primaryStage;

    public LoginMainController(LoginMainComponent component) {
        this.component = component;
        passwordController = new PasswordController(component.getPasswordComponent());
    }

    public void handleCloseButtonClick() {
        component.getCloseButton().setOnMouseClicked(e -> System.exit(0));
    }

    public void handleLoginButtonClick() {
        component.getLoginButton().setOnMouseClicked(e -> {

            String username = component.getUsernameTextField().getText().trim();
            String password = passwordController.getPassword().trim();

            if (username.isBlank() || password.isBlank()) {
                showAlert("Enter username and password!");
            } else {
                UserService userService = new UserService();

                userService.loginUser(new LoginUserDTO(username, password), user -> {
                    System.out.println("Prikazzzzz");

                    Platform.runLater(() -> {
                        if (!Objects.isNull(user.getUsername())) {
                            Initializer.init(primaryStage, user);
                        } else {
                            showAlert("Invalid username or password!");
                        }

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

    public void handleCreateAccountButtonClick() {
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
