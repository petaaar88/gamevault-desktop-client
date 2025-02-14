package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.text.NumberFormat;
import java.util.Locale;

public class CustomerReviewsComponent {

    private VBox layout;
    private Text review;
    private Text reviewNumber;
    private VBox reviewsVbox;
    private PaginationComponent paginationComponent;

    public CustomerReviewsComponent() {
        layout = new VBox();
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


        review = new Text("");
        review.setStyle("-fx-font-size: 16px");
        review.getStyleClass().add("game-description-text-body");


        reviewNumber = new Text("");
        reviewNumber.setStyle("-fx-font-size: 16px");
        reviewNumber.getStyleClass().add("game-description-text-body");

        reviewRatingHbox.getChildren().addAll(review, reviewNumber);
        overallReviewHbox.getChildren().add(reviewRatingHbox);
        overallReviewHbox.setAlignment(Pos.CENTER);

        reviewsVbox = new VBox();
        paginationComponent = new PaginationComponent();
        reviewsVbox.setSpacing(6);


        layout.getChildren().addAll(title,overallReviewHbox,reviewsVbox);

    }

    public PaginationComponent getPaginationComponent() {
        return paginationComponent;
    }

    public void setPaginationComponent(PaginationComponent paginationComponent) {
        this.paginationComponent = paginationComponent;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public Text getReview() {
        return review;
    }

    public void setReview(Text review) {
        this.review = review;
    }

    public VBox getComponent(){
        return layout;
    }

    public Text getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(Text reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public VBox getReviewsVbox() {
        return reviewsVbox;
    }

    public void setReviewsVbox(VBox reviewsVbox) {
        this.reviewsVbox = reviewsVbox;
    }
}
