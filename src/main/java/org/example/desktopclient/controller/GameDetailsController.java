package org.example.desktopclient.controller;

import org.example.desktopclient.component.GameDetailsComponent;

public class GameDetailsController {
    private GameDetailsComponent component;
    private Integer gameId;

    public GameDetailsController(GameDetailsComponent component) {
        this.component = component;
    }

    public GameDetailsComponent getComponent() {
        return component;
    }

    public void setComponent(GameDetailsComponent component) {
        this.component = component;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
