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

    public static void init(Stage primaryStage, FriendDTO user) {
        StompClient stompClient = new StompClient("ws://localhost:8080/ws", user.getId());

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
        menuController.setUser(applicationContextService.getUser());

        ChangeSceneUtil.primaryStage = primaryStage;

        GameProductPageScene gameProductPageSceneInstance = GameProductPageScene.getInstance(primaryStage, menuController);
        gameProductPageSceneInstance.setApplicationContextService(applicationContextService);

        UserGameCollectionScene userGameCollectionSceneInstance = UserGameCollectionScene.getInstance(primaryStage, menuController);
        userGameCollectionSceneInstance.setApplicationContextService(applicationContextService);

        FriendsScene friendsSceneInstance = FriendsScene.getInstance(primaryStage, menuController);
        friendsSceneInstance.setApplicationContextService(applicationContextService);

        ProfilePageScene profilePageSceneInstance = ProfilePageScene.getInstance(primaryStage, menuController);
        profilePageSceneInstance.setApplicationContextService(applicationContextService);

        EditProfileScene editProfileSceneInstance = EditProfileScene.getInstance(primaryStage, menuController);
        editProfileSceneInstance.setApplicationContextService(applicationContextService);

        //TODO scena nije zadnja inicijlaizovana, nece se rendervoati meni i sadrzaj na njoj
        GameCatalogScene gameCatalogSceneInstance = GameCatalogScene.getInstance(primaryStage, menuController);
        gameCatalogSceneInstance.setApplicationContextService(applicationContextService);


        ChangeSceneUtil.changeScene(GameCatalogScene.getInstance().createScene());
        primaryStage.centerOnScreen();
    }
}
