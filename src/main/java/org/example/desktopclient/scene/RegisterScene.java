package org.example.desktopclient.scene;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.RegisterMainComponent;
import org.example.desktopclient.controller.RegisterMainController;

public class RegisterScene {

    private Stage primaryStage;
    private static RegisterScene instance;
    private Scene scene;
    private VBox layout;

    private RegisterScene(Stage primaryStage) {
        this.primaryStage = primaryStage;

    }

    public static RegisterScene getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new RegisterScene(primaryStage);
        }
        return instance;
    }

    public Scene createScene() {

        layout = new VBox();
        layout.setStyle("-fx-background-color: #191B2E");

        RegisterMainComponent registerMainComponent = new RegisterMainComponent();
        RegisterMainController registerMainController = new RegisterMainController(registerMainComponent);
        registerMainController.setPrimaryStage(primaryStage);
        registerMainController.handleCloseButtonClick();
        registerMainController.handleBackButtonClick();
        registerMainController.handleRegisterButtonClick();

        layout.getChildren().add(registerMainComponent.getComponent());

        scene = new Scene(layout, 610, 600);

        primaryStage.setScene(scene);

        primaryStage.setHeight(600);
        primaryStage.setWidth(610);

        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(610);
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(610);

        primaryStage.centerOnScreen();

        primaryStage.show();

        return scene;
    }

    public static RegisterScene getInstance() {
        return instance;
    }
}
