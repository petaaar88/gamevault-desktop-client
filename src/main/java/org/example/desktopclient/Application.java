package org.example.desktopclient;

import javafx.stage.Stage;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.controller.MenuController;
import org.example.desktopclient.model.user.User;
import org.example.desktopclient.scene.FriendsScene;
import org.example.desktopclient.scene.GameCatalogScene;
import org.example.desktopclient.scene.GameProductPageScene;
import org.example.desktopclient.scene.UserGameCollectionScene;
import org.example.desktopclient.service.ApplicationContextService;
import org.example.desktopclient.service.game.GameService;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws IOException {


        ApplicationContextService applicationContextService = new ApplicationContextService();
        applicationContextService.setUser(new User(1,"Petar","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNNNXsl0n7l8OJWD05DUpYjWeNnYsg0bQneQ&s"));

        MenuComponent menuComponent = new MenuComponent();
        MenuController menuController = new MenuController(menuComponent, primaryStage);
        menuController.setUser(applicationContextService.getUser());


        GameProductPageScene gameProductPageSceneInstance = GameProductPageScene.getInstance(primaryStage,menuController);
        gameProductPageSceneInstance.setApplicationContextService(applicationContextService);

        UserGameCollectionScene userGameCollectionSceneInstance = UserGameCollectionScene.getInstance(primaryStage,menuController);
        userGameCollectionSceneInstance.setApplicationContextService(applicationContextService);

        FriendsScene friendsSceneInstance = FriendsScene.getInstance(primaryStage,menuController);
        friendsSceneInstance.setApplicationContextService(applicationContextService);

        //TODO scena nije zadnja inicijlaizovana, nece se rendervoati meni i sadrzaj na njoj
        GameCatalogScene gameCatalogSceneInstance = GameCatalogScene.getInstance(primaryStage, menuController);
        gameCatalogSceneInstance.setApplicationContextService(applicationContextService);

        gameCatalogSceneInstance.createScene();

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}