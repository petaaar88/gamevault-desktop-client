package org.example.desktopclient.controller;

import org.example.desktopclient.component.UserGameCollectionHorizontalMainComponent;
import org.example.desktopclient.service.ApplicationContextService;

public class UserGameMainController {
    private UserGameCollectionHorizontalMainComponent component;
    private Integer userId;
    private ApplicationContextService applicationContextService;

    public UserGameMainController(UserGameCollectionHorizontalMainComponent component, Integer userId, ApplicationContextService applicationContextService) {
        this.component = component;
        this.userId = userId;
        this.applicationContextService = applicationContextService;

        UserGameInCollectionDetailsController userGameInCollectionDetailsController = new UserGameInCollectionDetailsController(component.getUserGameInCollectionDetailsComponent(), userId, applicationContextService);

        UsersGamesCollectionController usersGamesCollectionController = new UsersGamesCollectionController(userId, component.getUsersGamesCollectionComponent(), userGameInCollectionDetailsController);
        usersGamesCollectionController.setUserId(userId);
        usersGamesCollectionController.initializeGameCollectionComponent();

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

    public ApplicationContextService getApplicationContextService() {
        return applicationContextService;
    }

    public void setApplicationContextService(ApplicationContextService applicationContextService) {
        this.applicationContextService = applicationContextService;
    }
}
