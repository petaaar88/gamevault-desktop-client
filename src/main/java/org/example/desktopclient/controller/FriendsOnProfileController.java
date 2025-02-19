package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.example.desktopclient.component.FriendComponent;
import org.example.desktopclient.component.FriendsOnProfileComponent;
import org.example.desktopclient.service.user.UserService;

public class FriendsOnProfileController {
    private FriendsOnProfileComponent component;
    private Integer userId;
    private UserService userService;

    public FriendsOnProfileController(FriendsOnProfileComponent component, Integer userId) {
        this.component = component;
        this.userId = userId;
        userService = new UserService();
    }

    public void initialize() {
        userService.fetchAllFriends(userId, friends -> Platform.runLater(() -> {
                    friends.getFriends().get("online").forEach(onlineFrined -> {
                        FriendComponent friendComponent = new FriendComponent();
                        friendComponent.getImageView().setImage(new Image(onlineFrined.getIcon()));
                        friendComponent.getUsernameLabel().setText(onlineFrined.getUsername());

                        FriendController friendController = new FriendController(friendComponent);
                        friendController.setUserId(onlineFrined.getId());
                        friendController.handleClick();

                        if (onlineFrined.getInGame() != null) {
                            friendComponent.getTextLabel().setStyle(null);
                            friendComponent.getTextLabel().setStyle("-fx-font-weight: 200;-fx-text-fill: #D8E212");
                            friendComponent.getTextLabel().setText(onlineFrined.getInGame());
                        }

                        component.getFriendsVbox().getChildren().add(friendComponent.getComponent());

                    });

                    friends.getFriends().get("offline").forEach(offlineFriend -> {
                        FriendComponent friendComponent = new FriendComponent();
                        friendComponent.getImageView().setImage(new Image(offlineFriend.getIcon()));
                        friendComponent.getUsernameLabel().setText(offlineFriend.getUsername());

                        FriendController friendController = new FriendController(friendComponent);
                        friendController.setUserId(offlineFriend.getId());
                        friendController.handleClick();

                        component.getFriendsVbox().getChildren().add(friendComponent.getComponent());

                    });
                }
        ));
    }


    public FriendsOnProfileComponent getComponent() {
        return component;
    }


    public void setComponent(FriendsOnProfileComponent component) {
        this.component = component;
    }
}
