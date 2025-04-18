package org.example.desktopclient.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.desktopclient.component.FooterComponent;
import org.example.desktopclient.component.TitleBarComponent;
import org.example.desktopclient.service.ApplicationContextService;
import org.example.desktopclient.util.WindowResizer;

import java.util.Collection;

public abstract class CustomScene {
    protected double xOffset = 0;
    protected double yOffset = 0;
    protected final double borderThickness = 2; // Debljina ivica za resize
    protected Stage primaryStage;
    protected BorderPane root;
    protected Scene scene;
    protected VBox layout;
    protected ApplicationContextService applicationContextService;
    protected TitleBarComponent titleBar;

    public CustomScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new BorderPane();
        layout = new VBox();
    }

    public abstract Scene createScene();

    public void setup(){

        titleBar = new TitleBarComponent();
        root.setTop(titleBar.getComponent(primaryStage,xOffset,yOffset));
        root.setStyle("-fx-border: none;-fx-background-color: #191B2E");
        root.setPadding(new Insets(0,0,0,0));

        FooterComponent footerComponent = new FooterComponent();
        root.setBottom(footerComponent.getComponents());

        WindowResizer.resizingWindow(primaryStage,root,borderThickness);

        scene = new Scene(root, 1200, 768);
        String css = getClass().getResource("/org/example/desktopclient/styles/universalStyles.css").toExternalForm();

        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);

        layout = new VBox();
        layout.setPrefWidth(Double.MAX_VALUE);  // Postavlja širinu na maksimalnu
        layout.setPrefHeight(Double.MAX_VALUE);  // Postavlja visinu na maksimalnu

        layout.setAlignment(Pos.TOP_CENTER);

        layout.getStyleClass().add("main-layout");
        layout.setPadding(new Insets(25, 0, 0, 0)); // (top, right, bottom, left)


    }

    public void addNodesToLayout(Collection<Node> elements){
        layout.getChildren().clear();

        layout.getChildren().addAll(elements);
        root.setCenter(layout);
        primaryStage.setWidth(scene.getWidth()+0.001);
        primaryStage.setHeight(scene.getHeight()+0.001);

    }

    public ApplicationContextService getApplicationContextService() {
        return applicationContextService;
    }

    public void setApplicationContextService(ApplicationContextService applicationContextService) {
        this.applicationContextService = applicationContextService;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public BorderPane getRoot() {
        return root;
    }
    public Scene getScene() {
        return scene;
    }
}
