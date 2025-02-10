package org.example.desktopclient.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.CatalogGameComponent;
import org.example.desktopclient.scene.GameProductPageScene;

public class CatalogGameController {
    private CatalogGameComponent component;
    private Integer gameId;

    public CatalogGameController(CatalogGameComponent component) {
        this.component = component;
        this.handleButtonClick();

    }

    public CatalogGameComponent getComponent() {
        return component;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void handleButtonClick(){
        component.getButton().setOnMouseClicked(e->{

            GameProductPageScene gameProductPageScene = GameProductPageScene.getInstance();
            gameProductPageScene.setGameId(gameId);
            gameProductPageScene.getPrimaryStage().setScene(gameProductPageScene.createScene());

            Stage primaryStage = gameProductPageScene.getPrimaryStage();

            Double width =  primaryStage.getWidth();
            Double height =  primaryStage.getHeight();

            primaryStage.setWidth(width.doubleValue());
            primaryStage.setHeight(height.doubleValue());

        });
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
