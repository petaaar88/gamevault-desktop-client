package org.example.desktopclient.component;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FriendRequest {

    public HBox getComponent() {
        HBox layout = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        FriendComponent friendComponent = new FriendComponent();
        VBox friendComponentVBox = friendComponent.getComponent("https://cdn-icons-png.flaticon.com/512/219/219986.png", "user123", "");

        Button acceptRequest = new Button("Accept Request");
        acceptRequest.getStyleClass().add("normal-action-button");

        Button declineRequest = new Button("Decline Request");
        declineRequest.getStyleClass().add("normal-action-button");

        layout.getChildren().addAll(friendComponentVBox, acceptRequest, declineRequest);

        return layout;
    }
}
