package org.example.desktopclient.controller;

import javafx.scene.layout.HBox;
import org.example.desktopclient.component.UserGameInCollectionComponent;
import org.example.desktopclient.component.UsersGamesCollectionComponent;

import java.util.*;

public class UsersGamesCollectionController {

    private UsersGamesCollectionComponent component;
    private UserGameInCollectionDetailsController userGameInCollectionDetailsController;
    private List<Map<String, String>> games;
    private UserGameInCollectionController selectedGameInCollectionController;
    private List<UserGameInCollectionController> gamesInCollectionControllers;

    public UsersGamesCollectionController(UsersGamesCollectionComponent component, UserGameInCollectionDetailsController userGameInCollectionDetailsController) {
        this.component = component;
        this.userGameInCollectionDetailsController = userGameInCollectionDetailsController;
        gamesInCollectionControllers = new ArrayList<>();

        this.setGames();
        this.initializeGameCollectionComponent();

    }

    public void setGames() {
        games = Arrays.asList(Map.of("id", "1", "image", "https://static.vecteezy.com/system/resources/previews/027/127/593/non_2x/grand-theft-auto-gta-v-logo-grand-theft-auto-gta-v-icon-transparent-free-png.png", "title", "Grand Threft Auto 5"), Map.of("id", "2", "image", "https://img.icons8.com/?size=192&id=iExfEgcZKka2&format=png", "title", "Rainbow Six Siege"));
    }

    public void initializeGameCollectionComponent() {
        Collection<HBox> gamesHbox = new ArrayList<>();

        games.forEach(game -> {
            UserGameInCollectionComponent userGameInCollectionComponent = new UserGameInCollectionComponent();

            userGameInCollectionComponent.setContent(game.get("image"),game.get("title"));

            Integer gameId = Integer.parseInt(game.get("id"));

            UserGameInCollectionController userGameInCollectionController = new UserGameInCollectionController(gameId,userGameInCollectionComponent,this);
            gamesHbox.add(userGameInCollectionComponent.getComponent());
            gamesInCollectionControllers.add(userGameInCollectionController);

            userGameInCollectionController.setSelected(false);
        });

        component.setContent(gamesHbox);
        selectedGameInCollectionController = gamesInCollectionControllers.getFirst();
        selectedGameInCollectionController.setSelected(true);

    }

    public void changeGame(UserGameInCollectionController userGameInCollectionController){
        selectedGameInCollectionController.setSelected(false);
        selectedGameInCollectionController = userGameInCollectionController;
        selectedGameInCollectionController.setSelected(true);

        userGameInCollectionDetailsController.changeGame(selectedGameInCollectionController.getGameId());
    }
}
