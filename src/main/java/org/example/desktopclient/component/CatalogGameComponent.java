package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CatalogGameComponent {

    public Button getComponent() {

        VBox layout = new VBox();

        String css = getClass().getResource("/org/example/desktopclient/styles/catalogGameComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        layout.getStyleClass().add("game-button-layout");

        Image gameCatalogImage = new Image("https://store-images.s-microsoft.com/image/apps.21181.14244061853036130.7c2802a8-1b30-475c-bf05-1f4138de9fd0.0ff00a6d-8e75-4346-980c-12dcdb64778d?q=90&w=480&h=270");

        ImageView gameCatalogImageView = new ImageView(gameCatalogImage);
        gameCatalogImageView.setFitWidth(320);
        gameCatalogImageView.setFitHeight(180);

        String gameTitle = "Red Dead Redemtion 2 DLC Back to the future";

        Label gameTitleLabel = new Label(gameTitle);
        gameTitleLabel.getStyleClass().add("game-title");

        Tooltip tooltip = new Tooltip(gameTitle);
        Tooltip.install(gameTitleLabel, tooltip);


        VBox gameDetailsVbox = new VBox( gameTitleLabel,getGameStatsGridPane());
        gameDetailsVbox.setPadding(new Insets(10,17,10,17));
        layout.getChildren().addAll(gameCatalogImageView, gameDetailsVbox);

        Button button = new Button("", layout);
        button.setPadding(new Insets(0));

        String css2 = getClass().getResource("/org/example/desktopclient/styles/catalogGameComponentStyles.css").toExternalForm();
        button.getStylesheets().add(css2);
        button.getStyleClass().add("game-button");
        button.setMinWidth(320);
        button.setMaxWidth(320);
        return button;
    }

    private GridPane getGameStatsGridPane(){
        GridPane gameStatsGridPane = new GridPane();
        gameStatsGridPane.setPadding(new Insets(3,0,0,0));

        Image downloadIconImage = new Image(getClass().getResource("/org/example/desktopclient/icons/downloadIcon.png").toExternalForm());
        ImageView downloadIconImageView = new ImageView(downloadIconImage);
        downloadIconImageView.setFitHeight(23);
        downloadIconImageView.setFitWidth(23);

        Label downloadNumberLabel = new Label("123");
        downloadNumberLabel.getStyleClass().add("game-details-text");
        HBox downloadHbox = new HBox(downloadIconImageView, downloadNumberLabel);

        Image reviewIconImage = new Image(getClass().getResource("/org/example/desktopclient/icons/emoji/mostlyNegativeEmojiDark.png").toExternalForm());
        ImageView reviewIconImageView = new ImageView(reviewIconImage);
        reviewIconImageView.setFitHeight(23);
        reviewIconImageView.setFitWidth(23);

        Label reviewPercentageLabel = new Label("85%");
        reviewPercentageLabel.getStyleClass().add("game-details-text");
        Label reviewNumberLabel = new Label("123");
        reviewNumberLabel.setPadding(new Insets(0,0,0,5));
        reviewNumberLabel.getStyleClass().add("game-details-text");
        HBox reviewHbox = new HBox(reviewIconImageView, reviewPercentageLabel,reviewNumberLabel);

        Image developerIconImage = new Image( getClass().getResource("/org/example/desktopclient/icons/developerIcon.png").toExternalForm());
        ImageView developerIconImageView = new ImageView(developerIconImage);
        developerIconImageView.setFitWidth(23);
        developerIconImageView.setFitHeight(23);

        Label developerNameLabel = new Label("Rocstar Games");
        developerNameLabel.getStyleClass().add("game-details-text");
        HBox developerHbox = new HBox(developerIconImageView, developerNameLabel);

        gameStatsGridPane.addRow(0,reviewHbox,downloadHbox);
        gameStatsGridPane.addRow(1,developerHbox);

        return gameStatsGridPane;
    }
}
