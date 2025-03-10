package org.example.desktopclient.scene;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.LoginMainComponent;
import org.example.desktopclient.controller.LoginMainController;
import org.example.desktopclient.controller.MenuController;

public class LoginScene {
    private Stage primaryStage;
    private static LoginScene instance;
    private Scene scene;
    private VBox layout;

    private LoginScene(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.initStyle(StageStyle.UNDECORATED);

    }

    public static LoginScene getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new LoginScene(primaryStage);
        }
        return instance;
    }

    public Scene createScene() {
        layout = new VBox();
        layout.setStyle("-fx-background-color: #191B2E");

        LoginMainComponent loginMainComponent = new LoginMainComponent();

        LoginMainController loginMainController = new LoginMainController(loginMainComponent);
        loginMainController.setPrimaryStage(primaryStage);
        loginMainController.handleCloseButtonClick();
        loginMainController.handleLoginButtonClick();
        loginMainController.handleCreateAccountButtonClick();


        layout.getChildren().add(loginMainComponent.getComponent());


        scene = new Scene(layout, 610, 370);

        primaryStage.setScene(scene);

        primaryStage.setHeight(370);
        primaryStage.setWidth(610);

        primaryStage.setMinHeight(370);
        primaryStage.setMinWidth(610);
        primaryStage.setMaxHeight(370);
        primaryStage.setMaxWidth(610);

        primaryStage.centerOnScreen();

        primaryStage.show();

        return scene;
    }

    public static LoginScene getInstance() {
        return instance;
    }

}
