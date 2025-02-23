package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.layout.HBox;
import org.example.desktopclient.component.UserGameInCollectionComponent;
import org.example.desktopclient.component.UsersGamesCollectionComponent;
import org.example.desktopclient.service.game.GameService;

import java.util.*;

public class UsersGamesCollectionController {

    private UsersGamesCollectionComponent component;
    private UserGameInCollectionDetailsController userGameInCollectionDetailsController;

    private UserGameInCollectionController selectedGameInCollectionController;
    private List<UserGameInCollectionController> gamesInCollectionControllers;
    private Integer userId;
    private GameService gameService;

    public UsersGamesCollectionController(UsersGamesCollectionComponent component, UserGameInCollectionDetailsController userGameInCollectionDetailsController) {
        this.component = component;
        this.userGameInCollectionDetailsController = userGameInCollectionDetailsController;
        gamesInCollectionControllers = new ArrayList<>();

        gameService = new GameService();

    }

    public void initializeGameCollectionComponent() {

        gameService.fetchUserGameCollection(userId, gamesInCollection -> {

            Platform.runLater(() -> {

                gamesInCollection.forEach(game -> {

                    UserGameInCollectionComponent userGameInCollectionComponent = new UserGameInCollectionComponent();

                    userGameInCollectionComponent.setContent(game.getIcon(), game.getTitle());

                    Integer gameId = game.getId();

                    UserGameInCollectionController userGameInCollectionController = new UserGameInCollectionController(gameId, userGameInCollectionComponent, this);
                    component.getGamesInCollectionVbox().getChildren().add(userGameInCollectionComponent.getComponent());
                    gamesInCollectionControllers.add(userGameInCollectionController);

                    userGameInCollectionController.setSelected(false);
                });

                selectedGameInCollectionController = gamesInCollectionControllers.getFirst();
                selectedGameInCollectionController.setSelected(true);

            });
        });

//        games.forEach(game -> {
//            UserGameInCollectionComponent userGameInCollectionComponent = new UserGameInCollectionComponent();
//
//            userGameInCollectionComponent.setContent(game.get("image"),game.get("title"));
//
//            Integer gameId = Integer.parseInt(game.get("id"));
//
//            UserGameInCollectionController userGameInCollectionController = new UserGameInCollectionController(gameId,userGameInCollectionComponent,this);
//            component.getGamesInCollectionVbox().getChildren().add(userGameInCollectionComponent.getComponent());
//            gamesInCollectionControllers.add(userGameInCollectionController);
//
//            userGameInCollectionController.setSelected(false);
//
//        });


    }

    public void changeGame(UserGameInCollectionController userGameInCollectionController) {
        selectedGameInCollectionController.setSelected(false);
        selectedGameInCollectionController = userGameInCollectionController;
        selectedGameInCollectionController.setSelected(true);

        userGameInCollectionDetailsController.changeGame(selectedGameInCollectionController.getGameId());
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
