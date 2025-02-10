package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.GameDescriptionComponent;
import org.example.desktopclient.service.game.GameService;

public class GameDescriptionController {
    private GameDescriptionComponent component;
    private Integer gameId;
    private GameService gameService;

    public GameDescriptionController(GameDescriptionComponent component){
        this.component = component;
        this.gameService = new GameService();
        gameId = component.getGameDetailsController().getGameId();

    }

    public void setContent(){
        gameService.fetchGameDescriptionForProductPage(gameId,gameDescriptionDTO -> {
            Platform.runLater(()->{
            component.getGameTitleText().setText(gameDescriptionDTO.getTitle());

            });
        });
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public GameDescriptionComponent getComponent() {
        return component;
    }

    public void setComponent(GameDescriptionComponent component) {
        this.component = component;
    }
}
