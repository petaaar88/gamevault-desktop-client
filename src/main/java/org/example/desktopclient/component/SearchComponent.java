package org.example.desktopclient.component;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class SearchComponent {

    TextField textField;

    public HBox getComponent(String placeholder) {
        HBox layout = new HBox();

        String css = getClass().getResource("/org/example/desktopclient/styles/searchComponent.css").toExternalForm();
        layout.getStylesheets().add(css);

        textField = new TextField();
        textField.getStyleClass().add("search-text");

        ImageView imageView = new ImageView(new Image(getClass().getResource("/org/example/desktopclient/icons/searchIcon1.png").toExternalForm()));

        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        Button button = new Button("", imageView);
        button.getStyleClass().add("search-button");
        StackPane stackPane = new StackPane(button);
        stackPane.setMaxHeight(33); // Veličina dugmeta
        stackPane.setTranslateX(-42); // Pomeranje dugmeta unutar textField-a
        StackPane.setAlignment(button, Pos.CENTER_RIGHT);


        textField.requestFocus();

        textField.setPromptText(placeholder);
        layout.setMaxWidth(1000);
        layout.setMinWidth(1000);
        layout.getChildren().addAll(textField, stackPane);

        layout.setPadding(new Insets(30, 0, 30, 0));

        return layout;
    }

    public void settingFocus(Scene scene) {

        Platform.runLater(() -> textField.getParent().requestFocus());
        scene.setOnMousePressed(event -> {
            if (!textField.isFocused()) {
                return;
            }
            textField.getParent().requestFocus(); // Fokusira roditelj, tj. defokusira TextField
        });
    }

}

