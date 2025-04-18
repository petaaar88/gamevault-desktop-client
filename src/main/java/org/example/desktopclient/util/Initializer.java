package org.example.desktopclient.util;

import javafx.stage.Stage;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.controller.MenuController;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.model.user.User;
import org.example.desktopclient.scene.*;
import org.example.desktopclient.service.ApplicationContextService;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Initializer {

    private static final String WS_URL = System.getenv("WS_URL");

    public static void init(Stage primaryStage, FriendDTO user) {

        //TODO: promeni da bude u env localhost;
        StompClient stompClient = new StompClient(WS_URL +"/ws", user.getId());

        ListenableFuture<StompSession> f = stompClient.connect();
        StompSession stompSession = null;
        try {
            stompSession = f.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        List<String> themes = Arrays.asList("/user-online-notification", "/friend-request-notification", "/friend-entered-game-notification");
        try {
            stompClient.subscribe(stompSession, themes);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        ApplicationContextService applicationContextService = new ApplicationContextService();
        applicationContextService.setUser(new User(user.getId(), user.getUsername(), user.getIcon()));
        applicationContextService.initialize();
        applicationContextService.setPrimaryStage(primaryStage);

        MenuComponent menuComponent = new MenuComponent();
        MenuController menuController = new MenuController(menuComponent, primaryStage);
        menuController.setUser(new User(user.getId(), user.getUsername(), user.getIcon()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SceneChanger.primaryStage = primaryStage;

        GameProductPageScene.restartInstance();
        GameProductPageScene gameProductPageSceneInstance = GameProductPageScene.getInstance(primaryStage, menuController);
        gameProductPageSceneInstance.setApplicationContextService(applicationContextService);

        UserGameCollectionScene.restartInstance();
        UserGameCollectionScene userGameCollectionSceneInstance = UserGameCollectionScene.getInstance(primaryStage, menuController);
        userGameCollectionSceneInstance.setApplicationContextService(applicationContextService);

        FriendsScene.restartInstance();
        FriendsScene friendsSceneInstance = FriendsScene.getInstance(primaryStage, menuController);
        friendsSceneInstance.setApplicationContextService(applicationContextService);

        ProfilePageScene.restartInstance();
        ProfilePageScene profilePageSceneInstance = ProfilePageScene.getInstance(primaryStage, menuController);
        profilePageSceneInstance.setApplicationContextService(applicationContextService);

        EditProfileScene.restartInstance();
        EditProfileScene editProfileSceneInstance = EditProfileScene.getInstance(primaryStage, menuController);
        editProfileSceneInstance.setApplicationContextService(applicationContextService);

        //TODO scena nije zadnja inicijlaizovana, nece se rendervoati meni i sadrzaj na njoj
        GameCatalogScene.restartInstance();
        GameCatalogScene gameCatalogSceneInstance = GameCatalogScene.getInstance(primaryStage, menuController);
        gameCatalogSceneInstance.setApplicationContextService(applicationContextService);


        SceneChanger.changeScene(GameCatalogScene.getInstance().createScene());
        primaryStage.setMinHeight(550);
        primaryStage.setMinWidth(1048);
        primaryStage.setMaxHeight(1080); // Postavljamo maksimalnu visinu
        primaryStage.setMaxWidth(1920);  // Postavljamo maksimalnu širinu
        primaryStage.setWidth(1200);
        primaryStage.setHeight(768);
        primaryStage.setResizable(true); // Omogućavamo promenu veličine prozora


        primaryStage.centerOnScreen();
    }
}
