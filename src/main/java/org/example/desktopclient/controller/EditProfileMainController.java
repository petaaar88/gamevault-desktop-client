package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.EditProfileMainVerticalComponent;
import org.example.desktopclient.model.user.UpdateUserDTO;
import org.example.desktopclient.service.user.UserService;

import java.io.File;
import java.util.Objects;

public class EditProfileMainController {
    private EditProfileMainVerticalComponent component;
    private Integer userId;
    private UserService userService;
    private ImageUploaderController imageUploaderController;

    public EditProfileMainController(EditProfileMainVerticalComponent component, Integer userId, Stage primaryStage) {
        this.component = component;
        this.userId = userId;

        imageUploaderController = new ImageUploaderController(component.getImageUploaderComponent());
        imageUploaderController.setStage(primaryStage);
        imageUploaderController.handleUploadClick();

        userService = new UserService();

        this.initialize();
        this.handleSaveButtonClick();

    }

    public void initialize() {
        userService.fetchUserDescription(userId, userDescriptionDTO -> {
            Platform.runLater(() -> {
                component.getUsernameTextField().setText(userDescriptionDTO.getUsername());
                component.getDescriptionTextArea().setText(userDescriptionDTO.getDescription());
                component.getCurrentImageView().setImage(new Image(userDescriptionDTO.getIcon()));
            });
        });
    }

    public void handleSaveButtonClick() {

        component.getSaveChangesButton().setOnMouseClicked(e -> {


            String username = component.getUsernameTextField().getText().trim();
            String description = Objects.isNull(component.getDescriptionTextArea().getText()) ? "" : component.getDescriptionTextArea().getText().trim();
            File icon = imageUploaderController.getSelectedImageFile();

            if (username.matches("^(?=(.*[a-zA-Z]){2})[^\\s/,:*%@^()\\\\,;\"'={}^`$]{2,20}$")) {

                if (description.length() < 420) {
                    UpdateUserDTO updateUserDTO = new UpdateUserDTO(username, description, icon);

                    userService.updateUser(userId, updateUserDTO, userDescriptionDTO -> {
                        showAlert(userDescriptionDTO);
                    });

                } else {
                    showAlert("Description is too long!");
                }

            } else {
                showAlert("Invalid username!");
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

    public EditProfileMainVerticalComponent getComponent() {
        return component;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
