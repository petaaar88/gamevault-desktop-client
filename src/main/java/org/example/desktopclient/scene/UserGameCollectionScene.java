package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.*;
import org.example.desktopclient.controller.MenuController;
import org.example.desktopclient.controller.TitleBarController;
import org.example.desktopclient.controller.UserGameMainController;
import org.example.desktopclient.service.ApplicationContextService;

import java.util.Arrays;
import java.util.Collection;

public class UserGameCollectionScene extends CustomScene {

    private static UserGameCollectionScene instance;
    private ApplicationContextService applicationContextService;
    private MenuController menuController;

    public static UserGameCollectionScene getInstance(Stage primaryStage, MenuController menuController) {
        if (instance == null) {
            instance = new UserGameCollectionScene(primaryStage, menuController);
        }
        return instance;
    }

    public static void restartInstance(){
        instance = null;
    }

    public static UserGameCollectionScene getInstance() {
        return instance;
    }

    private UserGameCollectionScene(Stage primaryStage, MenuController menuController) {
        super(primaryStage);
        this.setup();
        this.menuController = menuController;
    }

    @Override
    public Scene createScene() {

        menuController.setActiveItemInMenu("My Games");

        UserGameCollectionHorizontalMainComponent userGameCollectionHorizontalMainComponent = new UserGameCollectionHorizontalMainComponent();
        UserGameMainController userGameMainController = new UserGameMainController(userGameCollectionHorizontalMainComponent, applicationContextService.getUser().getId(), applicationContextService);
        userGameMainController.setApplicationContextService(applicationContextService);

        Collection<Node> elements = Arrays.asList(menuController.getMenuComponent().getComponent(), userGameCollectionHorizontalMainComponent.getComponent());
        TitleBarController titleBarController = new TitleBarController(titleBar);
        titleBarController.handleCloseButtonClick(applicationContextService.getUser().getId());

        this.addNodesToLayout(elements);

        return scene;
    }

    @Override
    public ApplicationContextService getApplicationContextService() {
        return applicationContextService;
    }

    @Override
    public void setApplicationContextService(ApplicationContextService applicationContextService) {
        this.applicationContextService = applicationContextService;
    }
}
