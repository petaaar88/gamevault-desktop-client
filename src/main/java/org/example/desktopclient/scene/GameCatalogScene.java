package org.example.desktopclient.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.component.SearchComponent;

public class GameCatalogScene {
    public Scene createScene(Stage primaryStage) {

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 1200, 768);
        String css = getClass().getResource("/org/example/desktopclient/styles/universalStyles.css").toExternalForm();

        scene.getStylesheets().add(css);
        layout.getStyleClass().add("main-layout");

        MenuComponent menuComponent = new MenuComponent();
        SearchComponent searchComponent = new SearchComponent();

        layout.getChildren().addAll(menuComponent.getComponent(), searchComponent.getComponent());
        layout.setPadding(new Insets(25, 0, 0, 0)); // (top, right, bottom, left)

        primaryStage.setMinWidth(1048);
        primaryStage.setMinHeight(550);

        primaryStage.setScene(scene);
        return scene;
    }
}
