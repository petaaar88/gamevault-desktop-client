package org.example.desktopclient.controller;

import org.example.desktopclient.component.RecentGameComponent;
import org.example.desktopclient.scene.GameProductPageScene;
import org.example.desktopclient.util.SceneChanger;

public class RecentGameController {
    private RecentGameComponent component;
    private Integer gameId;

    public RecentGameController(RecentGameComponent component) {
        this.component = component;
    }

    public void handleClick() {
        this.component.getGameTitleLabel().setOnMouseEntered(e->{
            component.getGameTitleLabel().setStyle("-fx-underline: true; -fx-cursor: hand;-fx-text-fill: #0084FF;-fx-font-size: 23;-fx-font-weight: bold");
        });

        this.component.getGameTitleLabel().setOnMouseExited(e->{
            component.getGameTitleLabel().setStyle("-fx-underline: false; -fx-cursor: hand;-fx-text-fill: white;-fx-font-size: 23;-fx-font-weight: bold");
        });

        this.component.getGameTitleLabel().setOnMouseClicked(e -> {
            GameProductPageScene.getInstance().setGameId(gameId);
            SceneChanger.changeScene(GameProductPageScene.getInstance().createScene());
        });
    }

    public RecentGameComponent getComponent() {
        return component;
    }

    public void setComponent(RecentGameComponent component) {
        this.component = component;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
