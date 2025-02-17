package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.example.desktopclient.component.ProfileDescriptionComponent;
import org.example.desktopclient.service.user.UserService;

import java.util.Objects;

public class ProfileDescriptionController {
    private ProfileDescriptionComponent component;
    private Integer viewUserId;
    private Integer mainUserId;
    private UserService userService;

    public ProfileDescriptionController(ProfileDescriptionComponent component) {
        this.component = component;
        userService = new UserService();
    }

    public void setContent() {
        userService.fetchUserDescription(viewUserId, description -> {
            Platform.runLater(() -> {
                if (Objects.isNull(description.getDescription())) {
                    component.getDescription().setText("No description");
                    component.getDescription().setStyle("-fx-font-size: 15px;-fx-text-fill: #8079CB;");

                } else
                    component.getDescription().setText(description.getDescription());

                component.getCreatedAtDateLabel().setText(description.getCreatedAt());
                component.getUsername().setText(description.getUsername());
                component.getImageView().setImage(new Image(description.getIcon()));


            });

        });
    }

    public ProfileDescriptionComponent getComponent() {
        return component;
    }

    public void setComponent(ProfileDescriptionComponent component) {
        this.component = component;
    }

    public Integer getViewUserId() {
        return viewUserId;
    }

    public void setViewUserId(Integer viewUserId) {
        this.viewUserId = viewUserId;
    }

    public Integer getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(Integer mainUserId) {
        this.mainUserId = mainUserId;
    }
}
