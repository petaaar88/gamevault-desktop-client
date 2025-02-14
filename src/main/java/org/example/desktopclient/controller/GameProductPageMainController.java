package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.GameProductPageVerticalMainComponent;
import org.example.desktopclient.service.game.GameService;

public class GameProductPageMainController {
    private GameProductPageVerticalMainComponent component;
    private Integer gameId;
    private Integer userId;
    private GameService gameService;

    //TODO: ovde se inicijazliuju svi kontroleri u jednoj sceni
    public GameProductPageMainController(GameProductPageVerticalMainComponent component,Integer gameId,Integer userId){
        gameService = new GameService();

        this.gameId = gameId;
        this.userId = userId;

        this.hideContent();

        this.component = component;
        this.component.getGameDescriptionController().setGameId(gameId);
        this.component.getGameDescriptionController().setContent();
        this.component.getGameDescriptionController().getComponent().getGameDetailsController().setGameId(gameId);
        this.component.getGameDescriptionController().getComponent().getGameDetailsController().setContent();
        this.component.getGameDescriptionController().getComponent().getImageSliderController().setImages(gameId);

        this.component.getGetGameController().setGameId(gameId);
        this.component.getGetGameController().setUserId(userId);
        this.component.getGetGameController().handleClick();

        this.component.getGameSystemRequirementsController().setGameId(gameId);
        this.component.getGameSystemRequirementsController().setContent();

        this.component.getFriendsThatPlayGameController().setGameId(gameId);
        this.component.getFriendsThatPlayGameController().setUserId(userId);
        this.component.getFriendsThatPlayGameController().setContent();
    }

    public void hideContent(){
        gameService.doesUserHaveGame(userId,gameId,callback->{
            Platform.runLater(()->{
                if(callback)
                    this.component.getRequirementsGettingAndReviewVbox().getChildren().removeFirst();
                else
                    this.component.getRequirementsGettingAndReviewVbox().getChildren().removeLast();
            });
        });

        gameService.doesUserHaveFriendsThatPlayGame(userId, gameId, callback->{
            Platform.runLater(()->{
                if(!callback)
                    this.component.getFriendsThatPlayGameComponent().getComponent().setVisible(false);
                else
                    this.component.getFriendsThatPlayGameComponent().getComponent().setVisible(true);

            });
        });
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
