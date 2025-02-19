package org.example.desktopclient.component;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class FriendCommentComponent {
    private VBox layout;
    private FriendComponent friendComponent;
    private Label commentLabel;
    private Label addedAtLabel;
    private Label addedAtLableContent;

    public FriendCommentComponent() {
        layout = new VBox();
        layout.setStyle("-fx-background-color: #191B2E");

        friendComponent = new FriendComponent();

        HBox addedAtHbox = new HBox();
        addedAtLabel = new Label("Posted At: ");
        addedAtLableContent = new Label();
        addedAtHbox.getChildren().addAll(addedAtLabel, addedAtLableContent);

        HBox hBox = new HBox(friendComponent.getComponent(), addedAtHbox);

        HBox.setHgrow(friendComponent.getComponent(), Priority.ALWAYS);

        commentLabel = new Label("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n" +
                "Why do we use it?\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes b");
        commentLabel.setWrapText(true);

        layout.getChildren().addAll(hBox, commentLabel);
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

    public Label getCommentLabel() {
        return commentLabel;
    }

    public FriendComponent getFriendComponent() {
        return friendComponent;
    }

    public void setFriendComponent(FriendComponent friendComponent) {
        this.friendComponent = friendComponent;
    }

    public void setCommentLabel(Label commentLabel) {
        this.commentLabel = commentLabel;
    }

    public Label getAddedAtLabel() {
        return addedAtLabel;
    }

    public void setAddedAtLabel(Label addedAtLabel) {
        this.addedAtLabel = addedAtLabel;
    }

    public Label getAddedAtLableContent() {
        return addedAtLableContent;
    }

    public void setAddedAtLableContent(Label addedAtLableContent) {
        this.addedAtLableContent = addedAtLableContent;
    }
}
