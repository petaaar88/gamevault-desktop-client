package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.*;

import java.util.Arrays;
import java.util.Collection;

public class FriendsScene extends CustomScene{

    public FriendsScene(Stage primaryStage) {
        super(primaryStage);
        this.setup();

    }

    @Override
    public Scene createScene() {
        MenuComponent menuComponent = new MenuComponent();
        FriendsVerticalMainComponent friendsVerticalMainComponent = new FriendsVerticalMainComponent();
        ScrollComponent scrollComponent = new ScrollComponent();

        Collection<Node> elements = Arrays.asList(menuComponent.getComponent(),scrollComponent.getComponent(friendsVerticalMainComponent.getComponent()));

        this.addNodesToLayout(elements);

        return scene;
    }
}
