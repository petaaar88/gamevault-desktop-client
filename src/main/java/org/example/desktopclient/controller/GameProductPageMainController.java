package org.example.desktopclient.controller;

import org.example.desktopclient.component.GameProductPageVerticalMainComponent;

public class GameProductPageMainController {
    private GameProductPageVerticalMainComponent component;
    private Integer gameId;

    //TODO: ovde se inicijazliuju svi kontroleri u jednoj sceni
    public GameProductPageMainController(GameProductPageVerticalMainComponent component,Integer gameId){
        this.gameId = gameId;
        this.component = component;
        this.component.getGameDescriptionController().setGameId(gameId);
        this.component.getGameDescriptionController().setContent();
        this.component.getGameDescriptionController().getComponent().getGameDetailsController().setGameId(gameId);
        this.component.getGameDescriptionController().getComponent().getGameDetailsController().setContent();
        this.component.getGameDescriptionController().getComponent().getImageSliderController().setImages(gameId);

        this.component.getGetGameController().setGameId(gameId);
        this.component.getGetGameController().handleClick();

        this.component.getGameSystemRequirementsController().setGameId(gameId);
        this.component.getGameSystemRequirementsController().setContent();
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
