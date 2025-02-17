package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.GameProductPageVerticalMainComponent;
import org.example.desktopclient.component.ScrollComponent;
import org.example.desktopclient.controller.GameProductPageMainController;
import org.example.desktopclient.controller.MenuController;

import java.util.Arrays;
import java.util.Collection;

public class ProfilePageScene extends CustomScene {

    private static ProfilePageScene instance;
    private MenuController menuController;
    private Integer userId;

    public static ProfilePageScene getInstance(Stage primaryStage, MenuController menuController) {
        if (instance == null) {
            instance = new ProfilePageScene(primaryStage, menuController);
        }
        return instance;
    }

    public ProfilePageScene(Stage primaryStage, MenuController menuController) {
        super(primaryStage);
        this.setup();
        this.menuController = menuController;
    }

    @Override
    public Scene createScene() {
        menuController.setActiveItemInMenu("Profile");


        Collection<Node> elements = Arrays.asList(menuController.getMenuComponent().getComponent());
        this.addNodesToLayout(elements);

        return scene;
    }

    public static ProfilePageScene getInstance() {
        return instance;
    }

    public static void setInstance(ProfilePageScene instance) {
        ProfilePageScene.instance = instance;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
