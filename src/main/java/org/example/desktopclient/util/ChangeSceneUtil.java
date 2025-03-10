package org.example.desktopclient.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeSceneUtil {

    public static Stage primaryStage;

    public static void changeScene(Scene scene) {

        Double width = primaryStage.getWidth();
        Double height = primaryStage.getHeight();

        primaryStage.setScene(scene);

        primaryStage.setWidth(width.doubleValue());
        primaryStage.setHeight(height.doubleValue());
    }

}
