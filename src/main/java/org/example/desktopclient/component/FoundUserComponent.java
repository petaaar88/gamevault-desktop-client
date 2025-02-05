package org.example.desktopclient.component;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FoundUserComponent {

    public VBox getComponent() {
        VBox layout = new VBox();
        HBox hBox = new HBox();
        hBox.setSpacing(10);

        FriendComponent friendComponent = new FriendComponent();
        Button sendRequestButton = new Button("Send Request");
        sendRequestButton.getStyleClass().add("normal-action-button");

        VBox friendComponentVBox = friendComponent.getComponent("https://cdn-icons-png.flaticon.com/512/219/219986.png", "user123", "");
        friendComponentVBox.setMinWidth(200);
        friendComponentVBox.setMaxWidth(200);

        hBox.getChildren().addAll(friendComponentVBox, sendRequestButton);


        hBox.setAlignment(Pos.CENTER_LEFT);

        layout.getChildren().addAll(hBox);
        return layout;
    }
}
