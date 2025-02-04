package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CustomerReviewComponent {

    public VBox getComponent() {
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #191B2E");
        layout.setPadding(new Insets(17,25,17,25));
        layout.setSpacing(8);

        HBox postedAtHbox = new HBox();
        Text postedText = new Text("Posted: ");
        postedText.setStyle("-fx-fill: #575C96;-fx-font-size: 16px");
        Text postedDateText = new Text("29. Nov 2023.");
        postedDateText.setStyle("-fx-fill: #575C96;-fx-font-size: 16px");
        postedAtHbox.getChildren().addAll(postedText,postedDateText);

        FriendComponent friendComponent = new FriendComponent();
        VBox friendComponentHbox = friendComponent.getComponent("https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/man-user-circle-icon.png","user123","");
        HBox friendAndPostingDateHBox = new HBox(friendComponentHbox,postedAtHbox);
        friendAndPostingDateHBox.setAlignment(Pos.CENTER);

        HBox.setHgrow(friendComponentHbox, Priority.ALWAYS);

        HBox ratingHbox = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/gameDetailsComponentStyles.css").toExternalForm();
        ratingHbox.getStylesheets().add(css);

        Text ratingText = new Text("Rating: ");
        ratingText.setStyle("-fx-fill:white; -fx-font-size: 16px;-fx-font-weight: 700;");
        Text ratingTypeText = new Text("Negative");

        String reviewTextTypeString = "negative";
        String reviewTextClass = "game-description-review-" + reviewTextTypeString + "-color";
        ratingTypeText.setStyle("-fx-font-size: 16px");
        ratingTypeText.getStyleClass().add("game-description-text-body");
        ratingTypeText.getStyleClass().add(reviewTextClass);

        ratingHbox.getChildren().addAll(ratingText, ratingTypeText);
        ratingHbox.setPadding(new Insets(0, 0,10,0));

        Label commentContentLabel = new Label("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages");
        commentContentLabel.setWrapText(true);
        commentContentLabel.setMinHeight(Region.USE_PREF_SIZE);
        commentContentLabel.setStyle("-fx-font-size: 15px");


        layout.getChildren().addAll(friendAndPostingDateHBox,ratingHbox, commentContentLabel);

        return layout;

    }

}
