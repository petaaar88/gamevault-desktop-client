package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.*;

import java.util.Arrays;
import java.util.Collection;

public class UserGameCollectionScene extends CustomScene{
    public UserGameCollectionScene(Stage primaryStage) {
        super(primaryStage);
        this.setup();

    }

    @Override
    public Scene createScene() {

        MenuComponent menuComponent = new MenuComponent();
        UserGameCollectionHorizontalMainComponent userGameCollectionHorizontalMainComponent = new UserGameCollectionHorizontalMainComponent();


        Collection<Node> elements = Arrays.asList(menuComponent.getComponent(), userGameCollectionHorizontalMainComponent.getComponent());

        this.addNodesToLayout(elements);

        return scene;
    }
}
