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
import org.example.desktopclient.component.RegisterMainComponent;
import org.example.desktopclient.model.user.LoginUserDTO;
import org.example.desktopclient.model.user.RegisterUserDTO;
import org.example.desktopclient.scene.LoginScene;
import org.example.desktopclient.service.user.UserService;
import org.example.desktopclient.util.Initializer;

import java.util.Objects;

public class RegisterMainController {
    private RegisterMainComponent component;
    private PasswordController passwordController;
    private ImageUploaderController imageUploaderController;
    private Stage primaryStage;

    public RegisterMainController(RegisterMainComponent component) {
        this.component = component;
        passwordController = new PasswordController(component.getPasswordComponent());
        imageUploaderController = new ImageUploaderController(component.getImageUploaderComponent());
        imageUploaderController.setStage(primaryStage);
        imageUploaderController.handleUploadClick();
    }

    public void handleRegisterButtonClick() {
        component.getRegisterButton().setOnMouseClicked(e -> {
            String username = component.getUsernameTextField().getText().trim();
            String password = passwordController.getPassword().trim();

            if (username.isBlank() || password.isBlank()) {
                showAlert("Enter username and password!");
            }
            else{
                if (username.matches("^(?=(.*[a-zA-Z]){2})[^\\s/,:*%@^()\\\\,;\"'={}^`$]{2,20}$")) {
                    if(password.length() >= 5 && password.length() <= 20) {
                        UserService userService = new UserService();

                        userService.registerUser(new RegisterUserDTO(username, password, imageUploaderController.getSelectedImageFile()), callaback -> {
                            Platform.runLater(() -> {
                                if(!Objects.isNull(callaback)) {
                                    if(callaback.equals("Username Already Taken!")) {
                                        showAlert(callaback);
                                    }




                                }
                                else{
                                    userService.loginUser(new LoginUserDTO(username, password), user -> {
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


                        });
                    }
                    else{
                        showAlert("Password must be at least 5 and maximum 20 characters long!");
                    }
                }
                else{
                    showAlert("Invalid username!");
                }

            }

        });
    }

    public void handleCloseButtonClick() {
        component.getCloseButton().setOnMouseClicked(e -> System.exit(0));
    }

    public void handleBackButtonClick() {
        component.getBackButton().setOnMouseClicked(e -> {
            LoginScene.getInstance(primaryStage);
            LoginScene.getInstance().createScene();
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

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
