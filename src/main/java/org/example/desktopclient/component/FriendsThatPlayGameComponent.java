package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FriendsThatPlayGameComponent {

    private VBox layout;
    private VBox friendsVbox;

    public FriendsThatPlayGameComponent(){
        layout = new VBox();
        layout.setMinWidth(345);
        layout.setMaxWidth(345);
        layout.setPadding(new Insets(15));
        layout.setMaxHeight(Region.USE_PREF_SIZE);

        layout.setStyle("-fx-background-color: #333352");

        Text friendsThatPlayGameText = new Text("Friends That Play This Game");
        friendsThatPlayGameText.setStyle("-fx-fill: white;-fx-font-size: 19px");

        friendsVbox = new VBox();
        friendsVbox.setPadding(new Insets(10,0,0,0));
        friendsVbox.setSpacing(10);


        layout.getChildren().addAll(friendsThatPlayGameText,friendsVbox);
    }

    public VBox getComponent(){
        return layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public VBox getFriendsVbox() {
        return friendsVbox;
    }

    public void setFriendsVbox(VBox friendsVbox) {
        this.friendsVbox = friendsVbox;
    }
}
