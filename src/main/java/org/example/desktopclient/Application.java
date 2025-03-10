package org.example.desktopclient;

import javafx.stage.Stage;
import org.example.desktopclient.model.user.LoginUserDTO;
import org.example.desktopclient.scene.*;
import org.example.desktopclient.service.user.UserService;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        LoginScene loginSceneInstance = LoginScene.getInstance(primaryStage);
        loginSceneInstance.createScene();

        primaryStage.setTitle("GameVault");
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}