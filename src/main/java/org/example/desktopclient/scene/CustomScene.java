package org.example.desktopclient.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.FooterComponent;
import org.example.desktopclient.component.TitleBarComponent;
import org.example.desktopclient.util.ResizeUtil;

import java.util.Collection;

public abstract class CustomScene {
    protected double xOffset = 0;
    protected double yOffset = 0;
    protected final double borderThickness = 2; // Debljina ivica za resize
    protected Stage primaryStage;
    protected BorderPane root;
    protected Scene scene;
    protected VBox layout;

    public CustomScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new BorderPane();
        layout = new VBox();
    }

    public abstract Scene createScene();

    public void setup(){
        // Uklanjanje podrazumevanog okvira prozora
        this.primaryStage.initStyle(StageStyle.UNDECORATED);

        TitleBarComponent titleBar = new TitleBarComponent();
        root.setTop(titleBar.getComponent(primaryStage,xOffset,yOffset));
        root.setStyle("-fx-border: none;-fx-background-color: #191B2E");
        root.setPadding(new Insets(0,0,0,0));

        FooterComponent footerComponent = new FooterComponent();
        root.setBottom(footerComponent.getComponents());

        ResizeUtil.resizingWindow(primaryStage,root,borderThickness);

        scene = new Scene(root, 1200, 768);
        String css = getClass().getResource("/org/example/desktopclient/styles/universalStyles.css").toExternalForm();

        scene.getStylesheets().add(css);

        layout = new VBox();
        layout.setPrefWidth(Double.MAX_VALUE);  // Postavlja širinu na maksimalnu
        layout.setPrefHeight(Double.MAX_VALUE);  // Postavlja visinu na maksimalnu

        layout.setAlignment(Pos.TOP_CENTER);

        layout.getStyleClass().add("main-layout");
        layout.setPadding(new Insets(25, 0, 0, 0)); // (top, right, bottom, left)


    }

    public void addNodesToLayout(Collection<Node> elements){
        layout.getChildren().addAll(elements);
        root.setCenter(layout);

    }

}
