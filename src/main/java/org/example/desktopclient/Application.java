package org.example.desktopclient;

import javafx.stage.Stage;
import org.example.desktopclient.component.UserGameInCollectionDetailsComponent;
import org.example.desktopclient.scene.FriendsScene;
import org.example.desktopclient.scene.GameCatalogScene;
import org.example.desktopclient.scene.GameProductPageScene;
import org.example.desktopclient.scene.UserGameCollectionScene;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        GameCatalogScene gameProductPageScene = new GameCatalogScene(primaryStage);
        gameProductPageScene.createScene();

        primaryStage.setMinWidth(1048);
        primaryStage.setMinHeight(550);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}