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
        layout = new VBox();
        layout.setStyle("-fx-background-color: #191B2E");
    }

    public static LoginScene getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new LoginScene(primaryStage);
        }
        return instance;
    }

    public Scene createScene() {


        layout.getChildren().clear();

        LoginMainComponent loginMainComponent = new LoginMainComponent();

        LoginMainController loginMainController = new LoginMainController(loginMainComponent);
        loginMainController.setPrimaryStage(primaryStage);
        loginMainController.handleCloseButtonClick();
        loginMainController.handleLoginButtonClick();
        loginMainController.handleCreateAccountButtonClick();


        layout.getChildren().add(loginMainComponent.getComponent());

        scene = new Scene(layout, 610, 370);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);

        return scene;
    }

}
