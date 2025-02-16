package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FoundUserComponent {

    private VBox layout;

    public FoundUserComponent() {
        layout = new VBox();
        HBox hBox = new HBox(-20);
        hBox.setPadding(new Insets(0,15,0,8));
        hBox.setStyle("-fx-background-color: #191B2E;");

        FriendComponent friendComponent = new FriendComponent();
        Button sendRequestButton = new Button("Send Request");
        sendRequestButton.getStyleClass().add("small-action-button");

        VBox friendComponentVBox = friendComponent.getComponent("https://cdn-icons-png.flaticon.com/512/219/219986.png", "user123", "");
        friendComponentVBox.setMinWidth(200);
        friendComponentVBox.setMaxWidth(200);

        hBox.getChildren().addAll(friendComponentVBox, sendRequestButton);


        hBox.setAlignment(Pos.CENTER_LEFT);

        layout.getChildren().addAll(hBox);
    }

    public VBox getComponent() {

        return layout;
    }
}
