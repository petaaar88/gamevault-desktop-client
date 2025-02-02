package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class GameDetailsComponent {

    public VBox getComponent() {
        VBox layout = new VBox();

        layout.setStyle("-fx-background-color:#333352");
        layout.setPadding(new Insets(17));
        String css = getClass().getResource("/org/example/desktopclient/styles/gameDetailsComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        Label gameDescriptionLabel = new Label("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC.");
        gameDescriptionLabel.setWrapText(true);
        gameDescriptionLabel.setFont(new Font(13.6));


        HBox reviewAndReleaseDateHbox = new HBox();

        reviewAndReleaseDateHbox.setPadding(new Insets(14, 0, 0, 0));


        String reviewTextTypeString = "negative";
        String reviewTextClass = "game-description-review-" + reviewTextTypeString + "-color";


        Text gameReviewText = new Text("Reviews");
        gameReviewText.getStyleClass().add("game-description-text-heading");
        Text review = new Text("Negative");
        review.getStyleClass().add("game-description-text-body");
        review.getStyleClass().add(reviewTextClass);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        Integer reviewNumberInteger = 12334;
        Text reviewNumber = new Text("(" + nf.format(reviewNumberInteger) + ")");
        reviewNumber.getStyleClass().add("game-description-text-body");
        HBox reviewsAndNumber = new HBox(review, reviewNumber);
        VBox gameReviewVbox = new VBox(gameReviewText, reviewsAndNumber);

        HBox.setHgrow(gameReviewVbox, Priority.ALWAYS);

        Text gameReleaseDateText = new Text("Release Date");
        gameReleaseDateText.getStyleClass().add("game-description-text-heading");
        Text releaseDateText = new Text("29. Oct 2023");
        releaseDateText.getStyleClass().add("game-description-text-body");
        VBox gameReleaseVbox = new VBox(gameReleaseDateText, releaseDateText);

        reviewAndReleaseDateHbox.getChildren().addAll(gameReviewVbox, gameReleaseVbox);


        VBox gameDeveloperVbox = new VBox();

        Text gameDeveloperText = new Text("Developer");
        gameDeveloperText.getStyleClass().add("game-description-text-heading");
        Text gameDeveloperNameText = new Text("Rocstar Games");
        gameDeveloperNameText.getStyleClass().add("game-description-text-body");
        gameDeveloperVbox.getChildren().addAll(gameDeveloperText, gameDeveloperNameText);

        VBox gameGenresVbox = new VBox();

        Text gameGenresText = new Text("Genres");
        gameGenresText.getStyleClass().add("game-description-text-heading");
        GameGenresComponent gameGenresComponent = new GameGenresComponent();
        gameGenresVbox.getChildren().addAll(gameGenresText, gameGenresComponent.getComponent());



        layout.getChildren().addAll(gameDescriptionLabel, reviewAndReleaseDateHbox, gameDeveloperVbox, gameGenresVbox);

        return layout;

    }
}
