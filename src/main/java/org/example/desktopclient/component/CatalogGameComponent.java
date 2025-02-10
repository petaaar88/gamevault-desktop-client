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
import org.example.desktopclient.model.game.GameOverview;

public class CatalogGameComponent {

    private VBox layout;
    private Button button;
    private Label gameTitleLabel;
    private Tooltip tooltip;
    private ImageView gameCatalogImageView;
    private Label developerNameLabel;
    private Label downloadNumberLabel;
    private Label reviewNumberLabel;
    private Label reviewPercentageLabel;
    private ImageView reviewIconImageView;

    public CatalogGameComponent() {
        layout = new VBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/catalogGameComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        layout.getStyleClass().add("game-button-layout");

        gameCatalogImageView = new ImageView();
        gameCatalogImageView.setFitWidth(320);
        gameCatalogImageView.setFitHeight(180);


        gameTitleLabel = new Label("");
        gameTitleLabel.getStyleClass().add("game-title");

        tooltip = new Tooltip("");
        Tooltip.install(gameTitleLabel, tooltip);


        VBox gameDetailsVbox = new VBox(gameTitleLabel, getGameStatsGridPane());
        gameDetailsVbox.setPadding(new Insets(10, 17, 10, 17));
        layout.getChildren().addAll(gameCatalogImageView, gameDetailsVbox);

        button = new Button("", layout);
        button.setPadding(new Insets(0));

        String css2 = getClass().getResource("/org/example/desktopclient/styles/catalogGameComponentStyles.css").toExternalForm();
        button.getStylesheets().add(css2);
        button.getStyleClass().add("game-button");
        button.setMinWidth(320);
        button.setMaxWidth(320);
    }

    public Button getComponent() {

        return button;
    }

    private GridPane getGameStatsGridPane() {
        GridPane gameStatsGridPane = new GridPane();
        gameStatsGridPane.setPadding(new Insets(3, 0, 0, 0));

        Image downloadIconImage = new Image(getClass().getResource("/org/example/desktopclient/icons/downloadIcon.png").toExternalForm());
        ImageView downloadIconImageView = new ImageView(downloadIconImage);
        downloadIconImageView.setFitHeight(23);
        downloadIconImageView.setFitWidth(23);

        downloadNumberLabel = new Label("123");
        downloadNumberLabel.getStyleClass().add("game-details-text");
        HBox downloadHbox = new HBox(downloadIconImageView, downloadNumberLabel);

        Image reviewIconImage = new Image(getClass().getResource("/org/example/desktopclient/icons/emoji/mostlyNegativeEmojiDark.png").toExternalForm());
        reviewIconImageView = new ImageView(reviewIconImage);
        reviewIconImageView.setFitHeight(23);
        reviewIconImageView.setFitWidth(23);

        reviewPercentageLabel = new Label("");
        reviewPercentageLabel.getStyleClass().add("game-details-text");
        reviewNumberLabel = new Label("");
        reviewNumberLabel.setPadding(new Insets(0, 0, 0, 5));
        reviewNumberLabel.getStyleClass().add("game-details-text");
        HBox reviewHbox = new HBox(reviewIconImageView, reviewPercentageLabel, reviewNumberLabel);
        reviewHbox.setSpacing(5);

        Image developerIconImage = new Image(getClass().getResource("/org/example/desktopclient/icons/developerIcon.png").toExternalForm());
        ImageView developerIconImageView = new ImageView(developerIconImage);
        developerIconImageView.setFitWidth(23);
        developerIconImageView.setFitHeight(23);

        developerNameLabel = new Label();
        developerNameLabel.getStyleClass().add("game-details-text");
        HBox developerHbox = new HBox(developerIconImageView, developerNameLabel);
        developerHbox.setSpacing(5);

        gameStatsGridPane.addRow(0, reviewHbox, downloadHbox);
        gameStatsGridPane.addRow(1, developerHbox);

        return gameStatsGridPane;
    }

    public Button getButton() {
        return button;
    }

    public void setContent(GameOverview gameOverview) {
        gameTitleLabel.setText(gameOverview.getTitle());
        tooltip.setText(gameOverview.getTitle());
        gameCatalogImageView.setImage(new Image(gameOverview.getImageUrl()));
        developerNameLabel.setText(gameOverview.getDeveloper());
        downloadNumberLabel.setText(gameOverview.getAcquisitions().toString());

        String rating = gameOverview.getRating().get("rating");

        if(rating == null)
            rating = "mixed";

        rating = rating.toLowerCase();

        String[] words = rating.split(" "); // Razdvajamo po donjoj crti
        StringBuilder camelCaseString = new StringBuilder(words[0]); // Prvi deo ostaje mali

        for (int i = 1; i < words.length; i++) {
            camelCaseString.append(Character.toUpperCase(words[i].charAt(0))) // Prvo slovo veliko
                    .append(words[i].substring(1)); // Ostatak ostaje isti
        }

        String iconUrl = getClass().getResource("/org/example/desktopclient/icons/emoji/"+camelCaseString.toString()+"EmojiDark.png").toExternalForm();

        reviewIconImageView.setImage(new Image(iconUrl));
        reviewNumberLabel.setText(gameOverview.getRating().get("reviews"));
        reviewPercentageLabel.setText((gameOverview.getRating().get("rating_percentage") == null) ? "TBA" : gameOverview.getRating().get("rating_percentage") + "%");
    }
}


