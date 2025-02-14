package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.FriendComponent;
import org.example.desktopclient.component.FriendsThatPlayGameComponent;
import org.example.desktopclient.service.game.GameService;

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
        gameService.doesUserHaveFriendsThatPlayGame(userId,gameId,callback->{
            Platform.runLater(()->{
                if(callback)
                    gameService.fetchAllFriendsThatPlayGame(userId,gameId,friends->{
                        Platform.runLater(()->{
                        friends.forEach(friend->{
                           component.getFriendsVbox().getChildren().addAll(new FriendComponent().getComponent("https://cdn-icons-png.flaticon.com/512/3135/3135823.png",friend.getUsername(),friend.getHoursPlayed().toString()));

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
