package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.*;
import org.example.desktopclient.controller.GamesCatalogController;
import org.example.desktopclient.controller.MenuController;
import org.example.desktopclient.controller.SearchController;

import java.util.Arrays;
import java.util.Collection;

public class GameCatalogScene extends CustomScene {

    private static GameCatalogScene instance;
    private MenuController menuController;

    public static GameCatalogScene getInstance() {
        return instance;
    }


    public static GameCatalogScene getInstance(Stage primaryStage, MenuController menuController) {
        if (instance == null) {
            instance = new GameCatalogScene(primaryStage, menuController);
        }
        return instance;
    }

    private GameCatalogScene(Stage primaryStage, MenuController menuController) {
        super(primaryStage);
        this.setup();
        this.menuController = menuController;

    }


    @Override
    public Scene createScene() {

        menuController.setActiveItemInMenu("Catalog");

        SearchComponent searchComponent = new SearchComponent();
        searchComponent.settingFocus(scene);
        SearchController searchController = new SearchController(searchComponent);

        GamesCatalogVerticalMainComponent gamesCatalogVerticalMainComponent = new GamesCatalogVerticalMainComponent();
        GamesCatalogController gamesCatalogController = new GamesCatalogController(gamesCatalogVerticalMainComponent, searchController);
        gamesCatalogController.setContent("");
        searchController.setSearchableController(gamesCatalogController);
        gamesCatalogController.getComponent().getPaginationController().setPaginableController(gamesCatalogController);


        ScrollComponent scrollComponent = new ScrollComponent();

        Collection<Node> elements = Arrays.asList(menuController.getMenuComponent().getComponent(), searchComponent.getComponent("Search Games"), scrollComponent.getComponent(gamesCatalogVerticalMainComponent.getComponent()));

        this.addNodesToLayout(elements);

        return scene;
    }
}
