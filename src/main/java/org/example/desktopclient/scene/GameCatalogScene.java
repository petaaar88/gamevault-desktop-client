package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.*;

import java.util.Arrays;
import java.util.Collection;

public class GameCatalogScene extends CustomScene {

    public GameCatalogScene(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public Scene createScene() {

        this.setup();

        MenuComponent menuComponent = new MenuComponent();
        SearchComponent searchComponent = new SearchComponent();
        searchComponent.settingFocus(scene);
        GamesCatalogVerticalMainComponent gamesCatalogVerticalMainComponent = new GamesCatalogVerticalMainComponent();

        ScrollComponent scrollComponent = new ScrollComponent();

        Collection<Node> elements = Arrays.asList(menuComponent.getComponent(), searchComponent.getComponent("Search Games"), scrollComponent.getComponent(gamesCatalogVerticalMainComponent.getComponent()));

        this.addNodesToLayout(elements);

        primaryStage.setScene(scene);
        return scene;
    }
}
