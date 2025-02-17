package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ProfileDescriptionComponent {

    private HBox layout;
    private ImageView imageView;
    private Label username;
    private Label description;
    private Button actionButton;
    private Label createdAtDateLabel;

    public ProfileDescriptionComponent() {
        layout = new HBox();
        layout.setStyle("-fx-background-color: #333352");
        layout.setPadding(new Insets(25));
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm());

        imageView = new ImageView(new Image("https://img.freepik.com/free-vector/cute-ninja-gaming-cartoon-vector-icon-illustration-people-technology-icon-concept-isolated-flat_138676-8079.jpg?semt=ais_hybrid"));
        imageView.setFitHeight(160);
        imageView.setFitWidth(160);


        username = new Label("Dragan__");
        username.setStyle("-fx-font-size: 27px;-fx-font-weight: 700;");

        description = new Label("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked.");
        description.setStyle("-fx-font-size: 15px;");
        description.setWrapText(true);
        description.setMinWidth(620);
        description.setMaxWidth(620);

        HBox createdAtHbox = new HBox();
        Label createdAtLabel = new Label("Since: ");
        createdAtLabel.setStyle("-fx-font-size: 17px;-fx-text-fill: #8079CB;");
        createdAtDateLabel = new Label("01.01.2022");
        createdAtDateLabel.setStyle("-fx-font-size: 17px;-fx-text-fill: #8079CB;");
        createdAtHbox.getChildren().addAll(createdAtLabel, createdAtDateLabel);
        createdAtHbox.setPadding(new Insets(0, 0, 0, 10));

        HBox usernameHbox = new HBox(username);
        HBox usernameCreatedAtHbox = new HBox(usernameHbox, createdAtHbox);
        HBox.setHgrow(usernameHbox, Priority.ALWAYS);

        VBox vBox = new VBox(usernameCreatedAtHbox, description);
        vBox.setSpacing(10);

        actionButton = new Button("Edit Profile");
        actionButton.getStyleClass().add("small-action-button");

        HBox hBox = new HBox(imageView, vBox);
        hBox.setSpacing(25);

        layout.getChildren().addAll(hBox, actionButton);

        HBox.setHgrow(hBox, Priority.ALWAYS);
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER_LEFT);


    }

    public HBox getComponent() {
        return layout;
    }

    public HBox getLayout() {
        return layout;
    }

    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Label getUsername() {
        return username;
    }

    public void setUsername(Label username) {
        this.username = username;
    }

    public Label getDescription() {
        return description;
    }

    public void setDescription(Label description) {
        this.description = description;
    }

    public Button getActionButton() {
        return actionButton;
    }

    public void setActionButton(Button actionButton) {
        this.actionButton = actionButton;
    }

    public Label getCreatedAtDateLabel() {
        return createdAtDateLabel;
    }

    public void setCreatedAtDateLabel(Label createdAtDateLabel) {
        this.createdAtDateLabel = createdAtDateLabel;
    }
}
