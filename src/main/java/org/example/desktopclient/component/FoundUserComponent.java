package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FoundUserComponent {

    private VBox layout;
    private Button sendRequestButton;
    private FriendComponent friendComponent;

    public FoundUserComponent() {
        layout = new VBox();
        HBox hBox = new HBox(-20);
        hBox.setPadding(new Insets(0,15,0,8));
        hBox.setStyle("-fx-background-color: #191B2E;");

        friendComponent = new FriendComponent();
        sendRequestButton = new Button("Send Request");
        sendRequestButton.getStyleClass().add("small-action-button");

        VBox friendComponentVBox = friendComponent.getComponent();
        friendComponentVBox.setMinWidth(200);
        friendComponentVBox.setMaxWidth(200);

        hBox.getChildren().addAll(friendComponentVBox, sendRequestButton);


        hBox.setAlignment(Pos.CENTER_LEFT);

        layout.getChildren().addAll(hBox);
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

    public Button getSendRequestButton() {
        return sendRequestButton;
    }

    public void setSendRequestButton(Button sendRequestButton) {
        this.sendRequestButton = sendRequestButton;
    }

    public FriendComponent getFriendComponent() {
        return friendComponent;
    }

    public void setFriendComponent(FriendComponent friendComponent) {
        this.friendComponent = friendComponent;
    }
}
