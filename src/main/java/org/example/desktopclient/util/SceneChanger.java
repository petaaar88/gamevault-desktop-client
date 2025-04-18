package org.example.desktopclient.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneChanger {

    public static Stage primaryStage;

    public static void changeScene(Scene scene) {

        double stageWidth = primaryStage.getWidth();
        double stageHeight = primaryStage.getHeight();

        primaryStage.setScene(scene);

        primaryStage.setWidth(stageWidth);
        primaryStage.setHeight(stageHeight);
    }

}
