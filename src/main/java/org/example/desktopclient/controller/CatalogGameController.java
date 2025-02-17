package org.example.desktopclient.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.desktopclient.component.CatalogGameComponent;
import org.example.desktopclient.scene.GameProductPageScene;
import org.example.desktopclient.util.ChangeSceneUtil;

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
            GameProductPageScene.getInstance().setGameId(gameId);
            ChangeSceneUtil.changeScene( GameProductPageScene.getInstance().createScene());
        });
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
