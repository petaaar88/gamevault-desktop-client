package org.example.desktopclient.scene;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.GameProductPageVerticalMainComponent;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.component.ScrollComponent;
import org.example.desktopclient.controller.GameProductPageMainController;
import org.example.desktopclient.controller.MenuController;
import org.example.desktopclient.service.ApplicationContextService;

import java.util.Arrays;
import java.util.Collection;

public class GameProductPageScene extends CustomScene{

    private static GameProductPageScene instance;
    private ApplicationContextService applicationContextService;
    private MenuController menuController;
    private Integer gameId;

    public static GameProductPageScene getInstance(Stage primaryStage, MenuController menuController) {
        if (instance == null) {
            instance = new GameProductPageScene(primaryStage,menuController);
        }
        return instance;
    }
    public static GameProductPageScene getInstance(){
        return instance;
    }

    private GameProductPageScene(Stage primaryStage, MenuController menuController) {
        super(primaryStage);
        this.setup();
        this.menuController = menuController;

    }
    @Override
    public Scene createScene() {

        menuController.setActiveItemInMenu("Catalog");

        GameProductPageVerticalMainComponent gameProductPageVerticalMainComponent = new GameProductPageVerticalMainComponent();
        GameProductPageMainController gameProductPageMainController = new GameProductPageMainController(gameProductPageVerticalMainComponent, gameId, applicationContextService.getUser().getId());
        ScrollComponent scrollComponent = new ScrollComponent();

        Collection<Node> elements = Arrays.asList(menuController.getMenuComponent().getComponent(), scrollComponent.getComponent(gameProductPageVerticalMainComponent.getComponent()));
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

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
