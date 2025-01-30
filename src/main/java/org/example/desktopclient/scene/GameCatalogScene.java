package org.example.desktopclient.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.component.SearchComponent;

public class GameCatalogScene extends CustomScene {

    public GameCatalogScene(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public Scene createScene() {

        this.setup();

        VBox layout = new VBox();
        layout.setPrefWidth(Double.MAX_VALUE);  // Postavlja širinu na maksimalnu
        layout.setPrefHeight(Double.MAX_VALUE);  // Postavlja visinu na maksimalnu

        layout.setAlignment(Pos.TOP_CENTER);

        layout.getStyleClass().add("main-layout");

        MenuComponent menuComponent = new MenuComponent();
        SearchComponent searchComponent = new SearchComponent();
        searchComponent.settingFocus(scene);


        layout.getChildren().addAll(menuComponent.getComponent(), searchComponent.getComponent("Search Games"));
        layout.setPadding(new Insets(25, 0, 0, 0)); // (top, right, bottom, left)

        root.getChildren().add(layout);

        primaryStage.setMinWidth(1048);
        primaryStage.setMinHeight(550);

        primaryStage.setScene(scene);
        return scene;
    }
}
