package org.example.desktopclient.controller;

import org.example.desktopclient.component.GameProductPageVerticalMainComponent;

public class GameProductPageMainController {
    private GameProductPageVerticalMainComponent component;
    private Integer gameId;

    public GameProductPageMainController(GameProductPageVerticalMainComponent component,Integer gameId){
        this.gameId = gameId;
        this.component = component;
        this.component.getGameDescriptionController().setGameId(gameId);
        this.component.getGameDescriptionController().setContent();
    }

    public GameProductPageVerticalMainComponent getComponent() {
        return component;
    }

    public void setComponent(GameProductPageVerticalMainComponent component) {
        this.component = component;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
