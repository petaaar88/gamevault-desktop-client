package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class GameDetailsComponent {

    private VBox layout;
    private Label gameDescriptionLabel;
    private Text releaseDateText;
    private Text gameDeveloperNameText;
    private Text reviewNumber;
    private Text review;

    public GameDetailsComponent(){
        layout = new VBox();
        layout.setMaxHeight(Region.USE_PREF_SIZE);

        layout.setStyle("-fx-background-color:#333352");
        layout.setPadding(new Insets(17));
        String css = getClass().getResource("/org/example/desktopclient/styles/gameDetailsComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        gameDescriptionLabel = new Label("");
        gameDescriptionLabel.setWrapText(true);
        gameDescriptionLabel.setFont(new Font(13.6));
        gameDescriptionLabel.setMinHeight(Region.USE_PREF_SIZE);



        HBox reviewAndReleaseDateHbox = new HBox();

        reviewAndReleaseDateHbox.setPadding(new Insets(14, 0, 0, 0));


        String reviewTextTypeString = "negative";
        String reviewTextClass = "game-description-review-" + reviewTextTypeString + "-color";


        Text gameReviewText = new Text("Reviews");
        gameReviewText.getStyleClass().add("game-description-text-heading");
        review = new Text("");
        review.getStyleClass().add("game-description-text-body");
        review.getStyleClass().add(reviewTextClass);

        reviewNumber = new Text("");
        reviewNumber.getStyleClass().add("game-description-text-body");
        HBox reviewsAndNumber = new HBox(review, reviewNumber);
        reviewsAndNumber.setSpacing(3);
        VBox gameReviewVbox = new VBox(gameReviewText, reviewsAndNumber);

        HBox.setHgrow(gameReviewVbox, Priority.ALWAYS);

        Text gameReleaseDateText = new Text("Release Date");
        gameReleaseDateText.getStyleClass().add("game-description-text-heading");
        releaseDateText = new Text("29. Oct 2023");
        releaseDateText.getStyleClass().add("game-description-text-body");
        VBox gameReleaseVbox = new VBox(gameReleaseDateText, releaseDateText);

        reviewAndReleaseDateHbox.getChildren().addAll(gameReviewVbox, gameReleaseVbox);


        VBox gameDeveloperVbox = new VBox();

        Text gameDeveloperText = new Text("Developer");
        gameDeveloperText.getStyleClass().add("game-description-text-heading");
        gameDeveloperNameText = new Text("");
        gameDeveloperNameText.getStyleClass().add("game-description-text-body");
        gameDeveloperVbox.getChildren().addAll(gameDeveloperText, gameDeveloperNameText);

        VBox gameGenresVbox = new VBox();

        Text gameGenresText = new Text("Genres");
        gameGenresText.getStyleClass().add("game-description-text-heading");
        GameGenresComponent gameGenresComponent = new GameGenresComponent();
        gameGenresVbox.getChildren().addAll(gameGenresText, gameGenresComponent.getComponent());



        layout.getChildren().addAll(gameDescriptionLabel, reviewAndReleaseDateHbox, gameDeveloperVbox, gameGenresVbox);

    }

    public VBox getComponent() {
        return layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public Label getGameDescriptionLabel() {
        return gameDescriptionLabel;
    }

    public void setGameDescriptionLabel(Label gameDescriptionLabel) {
        this.gameDescriptionLabel = gameDescriptionLabel;
    }

    public Text getReleaseDateText() {
        return releaseDateText;
    }

    public void setReleaseDateText(Text releaseDateText) {
        this.releaseDateText = releaseDateText;
    }

    public Text getGameDeveloperNameText() {
        return gameDeveloperNameText;
    }

    public void setGameDeveloperNameText(Text gameDeveloperNameText) {
        this.gameDeveloperNameText = gameDeveloperNameText;
    }

    public Text getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(Text reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public Text getReview() {
        return review;
    }

    public void setReview(Text review) {
        this.review = review;
    }
}
