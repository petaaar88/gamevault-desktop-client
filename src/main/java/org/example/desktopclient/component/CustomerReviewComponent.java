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

    private VBox layout;
    private Text postedDateText;
    private Label commentContentLabel;
    private FriendComponent friendComponent;
    private Text ratingTypeText;

    public CustomerReviewComponent() {
        layout = new VBox();
        layout.setStyle("-fx-background-color: #191B2E");
        layout.setPadding(new Insets(17, 25, 17, 25));
        layout.setSpacing(8);

        HBox postedAtHbox = new HBox();
        Text postedText = new Text("Posted: ");
        postedText.setStyle("-fx-fill: #575C96;-fx-font-size: 16px");
        postedDateText = new Text("");
        postedDateText.setStyle("-fx-fill: #575C96;-fx-font-size: 16px");
        postedAtHbox.getChildren().addAll(postedText, postedDateText);

        friendComponent = new FriendComponent();
        VBox friendComponentHbox = friendComponent.getComponent();
        HBox friendAndPostingDateHBox = new HBox(friendComponentHbox, postedAtHbox);
        friendAndPostingDateHBox.setAlignment(Pos.CENTER);
        friendComponentHbox.setPadding(new Insets(0, -12, 0, 0));

        HBox.setHgrow(friendComponentHbox, Priority.ALWAYS);

        HBox ratingHbox = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/gameDetailsComponentStyles.css").toExternalForm();
        ratingHbox.getStylesheets().add(css);

        Text ratingText = new Text("Rating: ");
        ratingText.setStyle("-fx-fill:white; -fx-font-size: 16px;-fx-font-weight: 700;");
        ratingTypeText = new Text("");


        ratingTypeText.setStyle("-fx-font-size: 16px");
        ratingTypeText.getStyleClass().add("game-description-text-body");

        ratingHbox.getChildren().addAll(ratingText, ratingTypeText);
        ratingHbox.setPadding(new Insets(0, 0, 10, 0));

        commentContentLabel = new Label("");
        commentContentLabel.setWrapText(true);
        commentContentLabel.setMinHeight(Region.USE_PREF_SIZE);
        commentContentLabel.setStyle("-fx-font-size: 15px");
        commentContentLabel.setPadding(new Insets(0, 0, 13, 0));

        layout.getChildren().addAll(friendAndPostingDateHBox, ratingHbox, commentContentLabel);

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

    public Text getPostedDateText() {
        return postedDateText;
    }

    public void setPostedDateText(Text postedDateText) {
        this.postedDateText = postedDateText;
    }

    public Label getCommentContentLabel() {
        return commentContentLabel;
    }

    public void setCommentContentLabel(Label commentContentLabel) {
        this.commentContentLabel = commentContentLabel;
    }

    public FriendComponent getFriendComponent() {
        return friendComponent;
    }

    public void setFriendComponent(FriendComponent friendComponent) {
        this.friendComponent = friendComponent;
    }

    public Text getRatingTypeText() {
        return ratingTypeText;
    }

    public void setRatingTypeText(Text ratingTypeText) {
        this.ratingTypeText = ratingTypeText;
    }
}
