package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.UserGameInCollectionDetailsComponent;
import org.example.desktopclient.service.game.GameService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserGameInCollectionDetailsController {

    private UserGameInCollectionDetailsComponent component;
    private GameService gameService;
    private Integer userId;

    public UserGameInCollectionDetailsController(UserGameInCollectionDetailsComponent component, Integer userId) {

        this.component = component;
        this.userId = userId;
        gameService = new GameService();

        this.initialize();
    }

    public void initialize() {
        gameService.fetchUserGameCollection(userId, games -> {
            Platform.runLater(() -> {
                this.changeGame(games.getFirst().getId());
            });
        });
    }



    public void changeGame(Integer newGameId){

        gameService.fetchGameInUserCollection(userId, newGameId, game -> {
            Platform.runLater(() -> {
                component.setNewContent(game.getImage());
            });
        });

    }
}
