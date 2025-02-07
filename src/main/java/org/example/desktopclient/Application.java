package org.example.desktopclient;

import javafx.stage.Stage;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.component.UserGameInCollectionDetailsComponent;
import org.example.desktopclient.controller.MenuController;
import org.example.desktopclient.model.User;
import org.example.desktopclient.scene.FriendsScene;
import org.example.desktopclient.scene.GameCatalogScene;
import org.example.desktopclient.scene.GameProductPageScene;
import org.example.desktopclient.scene.UserGameCollectionScene;
import org.example.desktopclient.service.ApplicationContextService;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        ApplicationContextService applicationContextService = new ApplicationContextService();
        applicationContextService.setUser(new User(1,"Korinsik123","http://slika123.jpg"));

        MenuComponent menuComponent = new MenuComponent();
        MenuController menuController = new MenuController(menuComponent, primaryStage);



        GameProductPageScene gameProductPageSceneInstance = GameProductPageScene.getInstance(primaryStage,menuController);
        gameProductPageSceneInstance.setApplicationContextService(applicationContextService);

        UserGameCollectionScene userGameCollectionSceneInstance = UserGameCollectionScene.getInstance(primaryStage,menuController);
        userGameCollectionSceneInstance.setApplicationContextService(applicationContextService);

        //TODO scena nije zadnja inicijlaizovana, nece se rendervoati meni i sadrzaj na njoj
        GameCatalogScene gameCatalogSceneInstance = GameCatalogScene.getInstance(primaryStage, menuController);
        gameCatalogSceneInstance.setApplicationContextService(applicationContextService);

        gameCatalogSceneInstance.createScene();

       // primaryStage.setMinWidth(1048);
       // primaryStage.setMinHeight(550);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}