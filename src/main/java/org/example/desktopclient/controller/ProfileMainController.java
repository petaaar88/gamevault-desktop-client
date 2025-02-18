package org.example.desktopclient.controller;

import org.example.desktopclient.component.ProfileVerticalMainComponent;

public class ProfileMainController {
    private ProfileVerticalMainComponent component;
    private Integer mainUserId;
    private Integer viewUserId;

    public ProfileMainController(ProfileVerticalMainComponent component, Integer mainUserId, Integer viewUserId) {
        this.component = component;
        this.mainUserId = mainUserId;
        this.viewUserId = viewUserId;

        ProfileDescriptionController profileDescriptionController = new ProfileDescriptionController(this.component.getProfileDescriptionComponent());
        profileDescriptionController.setMainUserId(mainUserId);
        profileDescriptionController.setViewUserId(viewUserId);
        profileDescriptionController.setContent();

        RecentActivityController recentActivityController = new RecentActivityController(this.component.getRecentActivityComponent());
        recentActivityController.setUserId(viewUserId);
        recentActivityController.setContent();

    }

    public ProfileVerticalMainComponent getComponent() {
        return component;
    }

    public void setComponent(ProfileVerticalMainComponent component) {
        this.component = component;
    }

    public Integer getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(Integer mainUserId) {
        this.mainUserId = mainUserId;
    }

    public Integer getViewUserId() {
        return viewUserId;
    }

    public void setViewUserId(Integer viewUserId) {
        this.viewUserId = viewUserId;
    }
}
