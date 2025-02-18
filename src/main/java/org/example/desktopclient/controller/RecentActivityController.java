package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.text.Text;
import org.example.desktopclient.component.RecentActivityComponent;
import org.example.desktopclient.component.RecentGameComponent;
import org.example.desktopclient.service.user.UserService;

import java.lang.foreign.PaddingLayout;

public class RecentActivityController {
    private RecentActivityComponent component;
    private Integer userId;
    private UserService userService;
    private final Integer LIMIT = 2;

    public RecentActivityController(RecentActivityComponent component) {
        this.component = component;
        this.userService = new UserService();
    }

    public void setContent() {
        userService.fetchRecentPlayedGames(userId, 1, LIMIT, games -> {
            Platform.runLater(() -> {
                if (!games.getResoult().isEmpty()) {
                    games.getResoult().forEach(game -> {
                        RecentGameComponent recentGameComponent = new RecentGameComponent();
                        RecentGameController recentGameController = new RecentGameController(recentGameComponent);
                        recentGameComponent.setContent(game);
                        component.getGames().getChildren().add(recentGameComponent.getComponent());


                        recentGameController.setGameId(game.getId());
                        recentGameController.handleClick();
                    });
                    if(!games.getNextPages().isEmpty()){
                        component.getGames().getChildren().add(component.getShowAllGamesButton());
                        component.getShowAllGamesButton().setOnMouseClicked(e -> {
                            this.setContent(-1);
                        });
                    }
                }
                else{
                    Text noActivityText = new Text("No recent activity found.");
                    noActivityText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
                    component.getGames().getChildren().add(noActivityText);
                }

            });
        });
    }

    public void setContent(Integer limit) {
        userService.fetchRecentPlayedGames(userId, 1, limit, games -> {
            Platform.runLater(() -> {
                component.getGames().getChildren().clear();

                if (!games.getResoult().isEmpty()) {
                    games.getResoult().forEach(game -> {
                        RecentGameComponent recentGameComponent = new RecentGameComponent();
                        RecentGameController recentGameController = new RecentGameController(recentGameComponent);
                        recentGameComponent.setContent(game);
                        component.getGames().getChildren().add(recentGameComponent.getComponent());


                        recentGameController.setGameId(game.getId());
                        recentGameController.handleClick();
                    });

                }


            });
        });
    }

    public RecentActivityComponent getComponent() {
        return component;
    }

    public void setComponent(RecentActivityComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
