package org.example.desktopclient;

import javafx.stage.Stage;
import org.example.desktopclient.scene.GameCatalogScene;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        GameCatalogScene gameCatalogScene = new GameCatalogScene(primaryStage);
        gameCatalogScene.createScene();

        primaryStage.setMinWidth(1048);
        primaryStage.setMinHeight(550);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}