package org.example.desktopclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import org.example.desktopclient.component.UserGameInCollectionComponent;
import org.example.desktopclient.component.UsersGamesCollectionComponent;
import org.example.desktopclient.model.game.GameInCollectionDTO;
import org.example.desktopclient.model.game.GameInstallationData;
import org.example.desktopclient.service.game.GameService;
import org.example.desktopclient.util.JsonFileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class UsersGamesCollectionController implements ISearchable {

    private UsersGamesCollectionComponent component;
    private UserGameInCollectionDetailsController userGameInCollectionDetailsController;
    private List<GameInCollectionDTO> gamesInUserCollection;
    private List<GameInstallationData> installedGames;

    private UserGameInCollectionController selectedGameInCollectionController;
    private List<UserGameInCollectionController> gamesInCollectionControllers;
    private Integer userId;
    private GameService gameService;

    public UsersGamesCollectionController(Integer userId, UsersGamesCollectionComponent component, UserGameInCollectionDetailsController userGameInCollectionDetailsController) {
        this.component = component;
        SearchController searchController = new SearchController(component.getSearchComponent());
        searchController.setSearchableController(this);

        this.userGameInCollectionDetailsController = userGameInCollectionDetailsController;
        gamesInCollectionControllers = new ArrayList<>();
        gamesInUserCollection = new ArrayList<>();

        gameService = new GameService();
        this.getInstalledGames();

        gameService.fetchUserGameCollection(userId, games -> {
            Platform.runLater(() -> {
                 Integer firstGameInCollection = games.getFirst().getId();
                 installedGames.stream().filter(game -> game.getGame_id() == firstGameInCollection).findFirst().ifPresent(game -> this.userGameInCollectionDetailsController.setGameInstallationData(game));
            });
        });
        this.userGameInCollectionDetailsController.initialize();
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

    public void getInstalledGames(){
        installedGames = new ArrayList<>();

        JsonFileManager jsonFileManager = new JsonFileManager();
        Path jsonFile = jsonFileManager.getConfigFilePath("GameVault", "installed_games.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (Files.exists(jsonFile)) {
                // Čitaj JSON i mapiraj u listu GameInfo objekata
                List<GameInstallationData> games = objectMapper.readValue(Files.readString(jsonFile), new TypeReference<List<GameInstallationData>>() {
                });

                System.out.println("Učitan JSON kao objekti:");

                installedGames = games;

            } else {
                System.out.println("Fajl ne postoji.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void changeGame(UserGameInCollectionController userGameInCollectionController) {
        selectedGameInCollectionController.setSelected(false);
        selectedGameInCollectionController = userGameInCollectionController;
        selectedGameInCollectionController.setSelected(true);

        userGameInCollectionDetailsController.setGameInstallationData(installedGames.stream().filter(game -> game.getGame_id() == selectedGameInCollectionController.getGameId()).findFirst().orElse(null));
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
