package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collection;


public class FriendsVerticalMainComponent extends VerticalMainComponent{
    @Override
    public VBox getComponent() {
        this.setup();
        layout.setPadding(new Insets(20,0,0,0));

        AddFriendComponent  addFriendComponent = new AddFriendComponent();

        HBox addFriendAndReceivedRequestsHBox = new HBox(addFriendComponent.getComponent());
        addFriendAndReceivedRequestsHBox.setStyle("-fx-background-color: #333352");
        addFriendAndReceivedRequestsHBox.setMinWidth(1000);
        addFriendAndReceivedRequestsHBox.setMaxWidth(1000);
        addFriendAndReceivedRequestsHBox.setPadding(new Insets(23));

        Collection<Node> elements = Arrays.asList(addFriendAndReceivedRequestsHBox);

        this.addElements(elements);

        return layout;
    }
}
