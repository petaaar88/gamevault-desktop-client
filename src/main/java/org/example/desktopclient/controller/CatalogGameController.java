package org.example.desktopclient.controller;

import org.example.desktopclient.component.CatalogGameComponent;

public class CatalogGameController {
    private CatalogGameComponent component;
    private Integer gameId;

    public CatalogGameController(CatalogGameComponent component) {
        this.component = component;
        this.handleButtonClick();

    }

    public CatalogGameComponent getComponent() {
        return component;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void handleButtonClick(){
        component.getButton().setOnMouseClicked(e->{
            System.out.println(gameId);
        });
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
