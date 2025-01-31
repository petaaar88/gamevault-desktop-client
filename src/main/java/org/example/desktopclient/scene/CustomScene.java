package org.example.desktopclient.scene;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.TitleBarComponent;
import org.example.desktopclient.util.ResizeUtil;

public abstract class CustomScene {
    protected double xOffset = 0;
    protected double yOffset = 0;
    protected final double borderThickness = 2; // Debljina ivica za resize
    protected Stage primaryStage;
    protected BorderPane root;
    protected Scene scene;

    public CustomScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new BorderPane();
    }

    public abstract Scene createScene();

    public void setup(){
        // Uklanjanje podrazumevanog okvira prozora
        this.primaryStage.initStyle(StageStyle.UNDECORATED);

        TitleBarComponent titleBar = new TitleBarComponent();
        root.setStyle("-fx-border: none;-fx-background-color: #191B2E");
        root.setTop(titleBar.getComponent(primaryStage,xOffset,yOffset));
        root.setPadding(new Insets(0,6,0,6));

        ResizeUtil.resizingWindow(primaryStage,root,borderThickness);

        scene = new Scene(root, 1200, 768);
        String css = getClass().getResource("/org/example/desktopclient/styles/universalStyles.css").toExternalForm();

        scene.getStylesheets().add(css);

    }



}
