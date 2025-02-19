package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FriendsOnProfileComponent {
    private VBox layout;
    private VBox friendsVbox;

    public FriendsOnProfileComponent() {
        layout = new VBox();
        layout.setMinWidth(270);
        layout.setMaxWidth(270);
        layout.setMinHeight(Region.USE_PREF_SIZE);
        layout.setMaxHeight(Region.USE_PREF_SIZE);
        layout.setStyle("-fx-background-color: #333352");
        layout.setPadding(new Insets(18));
        Text text = new Text("Friends");
        text.setStyle("-fx-fill: white; -fx-font-size: 25; -fx-font-weight: 700;");
        layout.getChildren().add(text);

        friendsVbox = new VBox();
        friendsVbox.setPadding(new Insets(12,0,0,0));
        friendsVbox.setSpacing(6);
        layout.getChildren().add(friendsVbox);

    }

    public VBox getComponent() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public VBox getFriendsVbox() {
        return friendsVbox;
    }

    public void setFriendsVbox(VBox friendsVbox) {
        this.friendsVbox = friendsVbox;
    }
}
