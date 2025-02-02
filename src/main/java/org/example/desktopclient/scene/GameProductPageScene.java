package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.GameDescription;
import org.example.desktopclient.component.GameProductPageVerticalMainComponent;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.component.ScrollComponent;

import java.util.Arrays;
import java.util.Collection;

public class GameProductPageScene extends CustomScene{

    public GameProductPageScene(Stage primaryStage) {
        super(primaryStage);
        this.setup();
    }
    @Override
    public Scene createScene() {

        MenuComponent menuComponent = new MenuComponent();
        GameProductPageVerticalMainComponent gameProductPageVerticalMainComponent = new GameProductPageVerticalMainComponent();
        ScrollComponent scrollComponent = new ScrollComponent();

        Collection<Node> elements = Arrays.asList(menuComponent.getComponent(), scrollComponent.getComponent(gameProductPageVerticalMainComponent.getComponent()));
        this.addNodesToLayout(elements);

        return scene;
    }
}
