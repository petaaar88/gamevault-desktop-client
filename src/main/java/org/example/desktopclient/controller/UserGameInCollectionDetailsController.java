package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.UserGameInCollectionDetailsComponent;
import org.example.desktopclient.model.game.GameStatus;
import org.example.desktopclient.service.game.GameService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserGameInCollectionDetailsController {

    private UserGameInCollectionDetailsComponent component;
    private GameService gameService;
    private Integer userId;
    private GameInLibraryActionButtonController gameInLibraryActionButtonController;
    private GameStatus gameStatus;

    public UserGameInCollectionDetailsController(UserGameInCollectionDetailsComponent component, Integer userId) {

        this.component = component;
        this.userId = userId;
        gameService = new GameService();

        gameInLibraryActionButtonController = new GameInLibraryActionButtonController(component.getGameInLibraryActionButtonComponent());

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
                if(!Objects.isNull(gameStatus)){
                    if(gameStatus.getGame_id()==newGameId){
                        System.out.println("Vec je instalirana");
                    }
                }
                component.setNewContent(game);
            });
        });

    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
