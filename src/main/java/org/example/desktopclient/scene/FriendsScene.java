package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.*;
import org.example.desktopclient.controller.MenuController;
import org.example.desktopclient.service.ApplicationContextService;

import java.util.Arrays;
import java.util.Collection;

public class FriendsScene extends CustomScene{

    private static FriendsScene instance;
    private ApplicationContextService applicationContextService;
    private MenuController menuController;

    public static FriendsScene getInstance(Stage primaryStage, MenuController menuController) {
        if (instance == null) {
            instance = new FriendsScene(primaryStage,menuController);
        }
        return instance;
    }

    public static FriendsScene getInstance(){
        return instance;
    }

    private FriendsScene(Stage primaryStage, MenuController menuController) {
        super(primaryStage);
        this.setup();
        this.menuController = menuController;

    }

    @Override
    public Scene createScene() {

        menuController.setActiveItemInMenu("Friends");

        FriendsVerticalMainComponent friendsVerticalMainComponent = new FriendsVerticalMainComponent();
        ScrollComponent scrollComponent = new ScrollComponent();

        Collection<Node> elements = Arrays.asList(menuController.getMenuComponent().getComponent(),scrollComponent.getComponent(friendsVerticalMainComponent.getComponent()));

        this.addNodesToLayout(elements);

        return scene;
    }
}
