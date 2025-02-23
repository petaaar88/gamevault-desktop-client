package org.example.desktopclient.controller;

import org.example.desktopclient.component.UserGameCollectionHorizontalMainComponent;

public class UserGameMainController {
    private UserGameCollectionHorizontalMainComponent component;
    private Integer userId;

    public UserGameMainController(UserGameCollectionHorizontalMainComponent component, Integer userId) {
        this.component = component;
        this.userId = userId;

        UserGameInCollectionDetailsController userGameInCollectionDetailsController = new UserGameInCollectionDetailsController(component.getUserGameInCollectionDetailsComponent());

        UsersGamesCollectionController usersGamesCollectionController = new UsersGamesCollectionController(component.getUsersGamesCollectionComponent(), userGameInCollectionDetailsController);


    }

    public UserGameCollectionHorizontalMainComponent getComponent() {
        return component;
    }

    public void setComponent(UserGameCollectionHorizontalMainComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
