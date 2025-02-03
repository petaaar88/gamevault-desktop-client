package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class FriendComponent {

    public VBox getComponent(String imageUrl, String username, String text) {
        VBox layout = new VBox();
        layout.setMaxHeight(Region.USE_PREF_SIZE);


        layout.setStyle("-fx-background-color: #191B2E");
        layout.setPadding(new Insets(10));

        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);

        Label usernameLabel = new Label(username);
        usernameLabel.setStyle("-fx-font-size: 17;-fx-font-weight: bold");
        Button button = new Button("",usernameLabel);
        button.setPadding(new Insets(0));
        button.setStyle("-fx-background-color: transparent;-fx-cursor: hand");


        Label textLabel = new Label(text);
        textLabel.setStyle("-fx-font-weight: 200");

        VBox vBox = new VBox(button, textLabel);

        HBox hBox = new HBox(imageView, vBox);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_LEFT);

        layout.getChildren().add(hBox);

        return layout;
    }

    public VBox getComponent(String imageUrl, String username, String text, boolean inGame) {
        VBox layout = new VBox();
        layout.setMaxHeight(Region.USE_PREF_SIZE);


        layout.setStyle("-fx-background-color: #191B2E");
        layout.setPadding(new Insets(10));

        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);

        Label usernameLabel = new Label(username);
        usernameLabel.setStyle("-fx-font-size: 17;-fx-font-weight: bold");

        Button button = new Button("",usernameLabel);
        button.setPadding(new Insets(0));
        button.setStyle("-fx-background-color: transparent;-fx-cursor: hand");

        Label textLabel = new Label(text);
        textLabel.setStyle("-fx-font-weight: 200;-fx-text-fill: #D8E212");

        VBox vBox = new VBox(button, textLabel);

        HBox hBox = new HBox(imageView, vBox);
        hBox.setSpacing(7);
        hBox.setAlignment(Pos.CENTER_LEFT);
        layout.getChildren().add(hBox);

        return layout;
    }
}
