package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.example.desktopclient.component.ProfileDescriptionComponent;
import org.example.desktopclient.scene.EditProfileScene;
import org.example.desktopclient.service.user.UserService;
import org.example.desktopclient.util.SceneChanger;
import org.example.desktopclient.util.CustomDateFormatter;

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

                component.getCreatedAtDateLabel().setText(CustomDateFormatter.formatDateOfPattern(description.getCreatedAt(), "d. MMM yyyy"));
                component.getUsername().setText(description.getUsername());
                component.getImageView().setImage(new Image(description.getIcon()));


                if (!Objects.equals(mainUserId, viewUserId)) {
                    userService.fetchUserRelationshipWithUser(mainUserId, viewUserId, relationship -> {
                        Platform.runLater(() -> {

                            component.getActionButton().setText(relationship);

                            if (relationship.equals("Friends"))
                                component.getActionButton().setDisable(true);
                            else if (relationship.equals("Request Sent"))
                                component.getActionButton().setDisable(true);
                            else if (relationship.equals("Request Received")) {
                                component.getActionButton().setDisable(true);
                            } else {
                                component.getActionButton().setDisable(false);
                                component.getActionButton().setText("Send Friend Request");
                                this.handleSendFriendRequestClick();
                            }
                        });
                    });
                } else {
                    component.getActionButton().setDisable(false);
                    component.getActionButton().setText("Edit Profile");

                    this.handleEditProfileClick();
                }


            });

        });
    }

    public void handleSendFriendRequestClick() {
        component.getActionButton().setOnMouseClicked(e -> {
            userService.sendFriendRequest(mainUserId, viewUserId, message -> {
                Platform.runLater(() -> {
                    component.getActionButton().setDisable(true);
                    component.getActionButton().setText("Request Sent");

                });

            });
        });
    }

    public void handleEditProfileClick() {
        component.getActionButton().setOnMouseClicked(e -> {
            EditProfileScene.getInstance().setUserId(mainUserId);
            SceneChanger.changeScene( EditProfileScene.getInstance().createScene());
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
