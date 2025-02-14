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
import javafx.scene.shape.Circle;

public class FriendComponent {

    private VBox layout;
    private ImageView imageView;
    private Label usernameLabel;
    private Button button;
    private Label textLabel;

    public FriendComponent(){
        layout = new VBox();
        layout.setMaxHeight(Region.USE_PREF_SIZE);


        layout.setStyle("-fx-background-color: #191B2E");
        layout.setPadding(new Insets(10));

        imageView = new ImageView();
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);

        Circle clip = new Circle(17.6, 17.6, 17.6);
        imageView.setClip(clip);

        usernameLabel = new Label("");
        usernameLabel.setStyle("-fx-font-size: 17;-fx-font-weight: bold");
        button = new Button("",usernameLabel);
        button.setPadding(new Insets(0));
        button.setStyle("-fx-background-color: transparent;-fx-cursor: hand");


        textLabel = new Label("");
        textLabel.setStyle("-fx-font-weight: 200");

        VBox vBox = new VBox(button, textLabel);

        HBox hBox = new HBox(imageView, vBox);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_LEFT);

        layout.getChildren().add(hBox);


    }

    public VBox getComponent(){
        return layout;
    }

    //TODO: izbrisi ovo
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

    //TODO: izbrisi ovo
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

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(Label usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Label getTextLabel() {
        return textLabel;
    }

    public void setTextLabel(Label textLabel) {
        this.textLabel = textLabel;
    }
}
