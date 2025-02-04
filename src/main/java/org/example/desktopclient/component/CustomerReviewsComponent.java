package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class CustomerReviewsComponent {

    public VBox getComponent(){
        VBox layout = new VBox();
        layout.setMinWidth(1000);
        layout.setMaxWidth(1000);
        layout.setStyle("-fx-background-color: #333352");
        layout.setPadding(new Insets(20));
        layout.setSpacing(12);

        Text title = new Text("Customer Reviews");
        title.setStyle("-fx-fill: white;-fx-font-size: 19px");

        HBox overallReviewHbox = new HBox();
        Text overallText = new Text("Overall Review: ");
        overallText.setStyle("-fx-fill: white;-fx-font-weight: 700;-fx-font-size: 16px");
        overallReviewHbox.setStyle("-fx-background-color: #191B2E");
        overallReviewHbox.getChildren().add(overallText);
        overallReviewHbox.setMaxWidth(Region.USE_PREF_SIZE);
        overallReviewHbox.setPadding(new Insets(10,17,10,17));

        HBox reviewRatingHbox = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/gameDetailsComponentStyles.css").toExternalForm();
        reviewRatingHbox.getStylesheets().add(css);

        String reviewTextTypeString = "negative";
        String reviewTextClass = "game-description-review-" + reviewTextTypeString + "-color";

        Text review = new Text("Negative");
        review.setStyle("-fx-font-size: 16px");
        review.getStyleClass().add("game-description-text-body");
        review.getStyleClass().add(reviewTextClass);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        Integer reviewNumberInteger = 12334;
        Text reviewNumber = new Text("(" + nf.format(reviewNumberInteger) + ")");
        reviewNumber.setStyle("-fx-font-size: 16px");
        reviewNumber.getStyleClass().add("game-description-text-body");

        reviewRatingHbox.getChildren().addAll(review, reviewNumber);
        overallReviewHbox.getChildren().add(reviewRatingHbox);
        overallReviewHbox.setAlignment(Pos.CENTER);

        VBox reviewsVbox = new VBox();
        PaginationComponent paginationComponent = new PaginationComponent();
        reviewsVbox.setSpacing(6);

        reviewsVbox.getChildren().addAll(new CustomerReviewComponent().getComponent(), new CustomerReviewComponent().getComponent(),paginationComponent.getCompoenent());

        layout.getChildren().addAll(title,overallReviewHbox,reviewsVbox);
        return layout;
    }
}
