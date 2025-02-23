package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class UserGameInCollectionComponent {

    private ImageView iconImageView;
    private Label gameNameLabel;
    private Button selectionButton;
    private HBox layout;
    private HBox imageAndTitleHbox;

    public UserGameInCollectionComponent() {
        iconImageView = new ImageView();
        gameNameLabel = new Label();
        selectionButton = new Button();
        layout = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/userGameInCollectionStyles.css").toExternalForm();
        layout.getStylesheets().add(css);
        selectionButton.getStyleClass().add("game-in-collection-button");
        imageAndTitleHbox = new HBox();
        selectionButton = new Button("", imageAndTitleHbox);


        iconImageView.setFitHeight(25);
        iconImageView.setFitWidth(25);

        gameNameLabel.setStyle("-fx-text-fill: white;-fx-font-size: 13px;-fx-font-weight: 700");

        imageAndTitleHbox.getChildren().addAll(iconImageView, gameNameLabel);
        imageAndTitleHbox.setSpacing(8);
        imageAndTitleHbox.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(selectionButton, Priority.ALWAYS);
        selectionButton.setMaxWidth(Double.MAX_VALUE);
        selectionButton.setPadding(new Insets(1, 15, 1, 15));
        layout.getChildren().add(selectionButton);

    }

    public HBox getComponent() {
        return layout;
    }

    public void setContent(String iconUrl, String gameTitle){
        iconImageView.setImage(new Image(iconUrl));
        gameNameLabel.setText(gameTitle);

    }

    public void setButtonDeselected(){
        selectionButton.getStyleClass().removeLast();
        selectionButton.getStyleClass().add("game-in-collection-button");
    }

    public void setButtonSelected(){
        selectionButton.getStyleClass().removeLast();
        selectionButton.getStyleClass().add("selected-game-in-collection-button");
    }

    public Button getSelectionButton() {
        return selectionButton;
    }
}
