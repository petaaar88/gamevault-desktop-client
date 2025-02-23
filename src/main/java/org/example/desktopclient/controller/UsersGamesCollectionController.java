package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.example.desktopclient.component.UserGameInCollectionComponent;
import org.example.desktopclient.component.UsersGamesCollectionComponent;
import org.example.desktopclient.model.game.GameInCollectionDTO;
import org.example.desktopclient.service.game.GameService;

import java.util.*;

public class UsersGamesCollectionController implements ISearchable {

    private UsersGamesCollectionComponent component;
    private UserGameInCollectionDetailsController userGameInCollectionDetailsController;
    private List<GameInCollectionDTO> gamesInUserCollection;

    private UserGameInCollectionController selectedGameInCollectionController;
    private List<UserGameInCollectionController> gamesInCollectionControllers;
    private Integer userId;
    private GameService gameService;

    public UsersGamesCollectionController(UsersGamesCollectionComponent component, UserGameInCollectionDetailsController userGameInCollectionDetailsController) {
        this.component = component;
        SearchController searchController = new SearchController(component.getSearchComponent());
        searchController.setSearchableController(this);

        this.userGameInCollectionDetailsController = userGameInCollectionDetailsController;
        gamesInCollectionControllers = new ArrayList<>();
        gamesInUserCollection = new ArrayList<>();

        gameService = new GameService();

    }

    public void initializeGameCollectionComponent() {

        gameService.fetchUserGameCollection(userId, gamesInCollection -> {

            Platform.runLater(() -> {

                gamesInCollection.forEach(game -> {

                    gamesInUserCollection.add(game);

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

    @Override
    public void search(String text) {
        this.component.getGamesInCollectionVbox().getChildren().clear();
        gamesInCollectionControllers.clear();

        if(text.isBlank()){
            gamesInUserCollection.forEach(game -> {

                UserGameInCollectionComponent userGameInCollectionComponent = new UserGameInCollectionComponent();

                userGameInCollectionComponent.setContent(game.getIcon(), game.getTitle());

                Integer gameId = game.getId();

                UserGameInCollectionController userGameInCollectionController = new UserGameInCollectionController(gameId, userGameInCollectionComponent, this);
                component.getGamesInCollectionVbox().getChildren().add(userGameInCollectionComponent.getComponent());
                gamesInCollectionControllers.add(userGameInCollectionController);

                userGameInCollectionController.setSelected(false);
            });
        }
        else{



            gamesInUserCollection.forEach(game -> {

                if(!game.getTitle().toLowerCase().contains(text.toLowerCase())) return;
                UserGameInCollectionComponent userGameInCollectionComponent = new UserGameInCollectionComponent();

                userGameInCollectionComponent.setContent(game.getIcon(), game.getTitle());

                Integer gameId = game.getId();

                UserGameInCollectionController userGameInCollectionController = new UserGameInCollectionController(gameId, userGameInCollectionComponent, this);
                component.getGamesInCollectionVbox().getChildren().add(userGameInCollectionComponent.getComponent());
                gamesInCollectionControllers.add(userGameInCollectionController);

                userGameInCollectionController.setSelected(false);
            });

            if(gamesInUserCollection.stream().map(GameInCollectionDTO::getTitle).filter(title -> title.toLowerCase().contains(text.toLowerCase())).findAny().isEmpty()){
                Label label = new Label("No results found");
                label.setPadding(new Insets(0, 0, 0, 20));
                label.setStyle("-fx-font-size: 15;-fx-font-weight: bold;-fx-text-fill: #0084FF;");
                component.getGamesInCollectionVbox().getChildren().add(label);
            }

        }

    }
}
