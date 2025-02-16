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
    private FriendRequestsComponent friendRequestsComponent;
    private AllFriendsComponent allFriendsComponent;

    public FriendsVerticalMainComponent() {
        addFriendComponent = new AddFriendComponent();
        friendRequestsComponent = new FriendRequestsComponent();
        allFriendsComponent = new AllFriendsComponent();
    }

    @Override
    public VBox getComponent() {
        this.setup();
        layout.setPadding(new Insets(20,0,0,0));


        VBox mainContentVbox = new VBox(addFriendComponent.getComponent(),allFriendsComponent.getComponent(),friendRequestsComponent.getComponent());
        mainContentVbox.setSpacing(30);
        mainContentVbox.setStyle("-fx-background-color: #333352");
        mainContentVbox.setMinWidth(1000);
        mainContentVbox.setMaxWidth(1000);
        mainContentVbox.setPadding(new Insets(23));

        Collection<Node> elements = Arrays.asList(mainContentVbox);

        this.addElements(elements);

        return layout;
    }

    public AddFriendComponent getAddFriendComponent() {
        return addFriendComponent;
    }

    public void setAddFriendComponent(AddFriendComponent addFriendComponent) {
        this.addFriendComponent = addFriendComponent;
    }

    public FriendRequestsComponent getFriendRequestsComponent() {
        return friendRequestsComponent;
    }

    public void setFriendRequestsComponent(FriendRequestsComponent friendRequestsComponent) {
        this.friendRequestsComponent = friendRequestsComponent;
    }

    public AllFriendsComponent getAllFriendsComponent() {
        return allFriendsComponent;
    }

    public void setAllFriendsComponent(AllFriendsComponent allFriendsComponent) {
        this.allFriendsComponent = allFriendsComponent;
    }
}
