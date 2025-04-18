package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.example.desktopclient.component.FriendComponent;
import org.example.desktopclient.component.FriendsThatPlayGameComponent;
import org.example.desktopclient.service.game.GameService;
import org.example.desktopclient.util.NumberFormatter;

public class FriendsThatPlayGameController {

    private FriendsThatPlayGameComponent component;
    private Integer gameId;
    private Integer userId;
    private GameService gameService;


    public FriendsThatPlayGameController(FriendsThatPlayGameComponent component) {
        this.component = component;
        gameService = new GameService();
    }

    public void setContent() {
        gameService.doesUserHaveFriendsThatPlayGame(userId, gameId, callback -> {
            Platform.runLater(() -> {
                if (callback)
                    gameService.fetchAllFriendsThatPlayGame(userId, gameId, friends -> {
                        Platform.runLater(() -> {
                            friends.forEach(friend -> {

                                FriendComponent friendComponent = new FriendComponent();
                                FriendController friendController = new FriendController(friendComponent);
                                friendController.setUserId(friend.getId());


                                friendController.getComponent().getTextLabel().setText(NumberFormatter.roundDecimals(friend.getHoursPlayed()) + " Hours");
                                friendController.getComponent().getImageView().setImage(new Image(friend.getIcon()));
                                friendController.getComponent().getUsernameLabel().setText(friend.getUsername());
                                friendController.handleClick();


                                component.getFriendsVbox().getChildren().addAll(friendComponent.getComponent());

                            });

                        });
                    });
            });
        });
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public FriendsThatPlayGameComponent getComponent() {
        return component;
    }

    public void setComponent(FriendsThatPlayGameComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
