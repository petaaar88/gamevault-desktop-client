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
    private AddFriendComponent  addFriendComponent;

    public FriendsVerticalMainComponent() {
        addFriendComponent = new AddFriendComponent();
    }

    @Override
    public VBox getComponent() {
        this.setup();
        layout.setPadding(new Insets(20,0,0,0));

        FriendRequestsComponent friendRequestsComponent = new FriendRequestsComponent();

        VBox addFriendAndReceivedRequestsVBox = new VBox(addFriendComponent.getComponent(),friendRequestsComponent.getComponent());
        addFriendAndReceivedRequestsVBox.setStyle("-fx-background-color: #333352");
        addFriendAndReceivedRequestsVBox.setMinWidth(1000);
        addFriendAndReceivedRequestsVBox.setMaxWidth(1000);
        addFriendAndReceivedRequestsVBox.setPadding(new Insets(23));

        Collection<Node> elements = Arrays.asList(addFriendAndReceivedRequestsVBox);

        this.addElements(elements);

        return layout;
    }

    public AddFriendComponent getAddFriendComponent() {
        return addFriendComponent;
    }

    public void setAddFriendComponent(AddFriendComponent addFriendComponent) {
        this.addFriendComponent = addFriendComponent;
    }
}
