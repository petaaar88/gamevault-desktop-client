package org.example.desktopclient;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.scene.GameCatalogScene;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws IOException {


        primaryStage.setTitle("GameVault");
        primaryStage.setScene(new GameCatalogScene().createScene(primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}