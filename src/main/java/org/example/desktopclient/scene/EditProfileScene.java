package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.EditProfileMainVerticalComponent;
import org.example.desktopclient.component.ScrollComponent;
import org.example.desktopclient.controller.EditProfileMainController;
import org.example.desktopclient.controller.MenuController;

import java.util.Arrays;
import java.util.Collection;

public class EditProfileScene extends CustomScene{

    private static EditProfileScene instance;
    private MenuController menuController;
    private Integer userId;

    public static EditProfileScene getInstance(Stage primaryStage, MenuController menuController) {
        if (instance == null) {
            instance = new EditProfileScene(primaryStage,menuController);
        }
        return instance;
    }

    public static EditProfileScene getInstance(){
        return instance;
    }

    private EditProfileScene(Stage primaryStage, MenuController menuController) {
        super(primaryStage);
        this.setup();
        this.menuController = menuController;

    }



    @Override
    public Scene createScene() {

        EditProfileMainVerticalComponent editProfileMainVerticalComponent = new EditProfileMainVerticalComponent();
        EditProfileMainController editProfileMainController = new EditProfileMainController(editProfileMainVerticalComponent, userId);

        ScrollComponent scrollComponent = new ScrollComponent();
        Collection<Node> elements = Arrays.asList(menuController.getMenuComponent().getComponent(),scrollComponent.getComponent(editProfileMainVerticalComponent.getComponent()));

        this.addNodesToLayout(elements);

        return scene;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
