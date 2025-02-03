package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FriendsThatPlayGameComponent {

    public VBox getComponent(){
        VBox layout = new VBox();
        layout.setMinWidth(345);
        layout.setMaxWidth(345);
        layout.setPadding(new Insets(15));
        layout.setMaxHeight(Region.USE_PREF_SIZE);

        layout.setStyle("-fx-background-color: #333352");

        Text friendsThatPlayGameText = new Text("Friends That Play This Game");
        friendsThatPlayGameText.setStyle("-fx-fill: white;-fx-font-size: 19px");

        VBox friendsVbox = new VBox();
        friendsVbox.setPadding(new Insets(10,0,0,0));
        friendsVbox.setSpacing(10);

        friendsVbox.getChildren().addAll(new FriendComponent().getComponent("https://cdn-icons-png.flaticon.com/512/3135/3135823.png","Killder",""),new FriendComponent().getComponent("https://cdn-icons-png.flaticon.com/512/3135/3135823.png","Killder","Gran Threft Auto 5", true));

        layout.getChildren().addAll(friendsThatPlayGameText,friendsVbox);

        return layout;
    }
}
