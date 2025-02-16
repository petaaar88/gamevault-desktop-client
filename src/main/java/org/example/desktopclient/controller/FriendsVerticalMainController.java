package org.example.desktopclient.controller;

import org.example.desktopclient.component.FriendsVerticalMainComponent;

public class FriendsVerticalMainController {
    private FriendsVerticalMainComponent component;
    private AddFriendController addFriendController;
    private Integer userId;

    public FriendsVerticalMainController(FriendsVerticalMainComponent component,Integer userId) {
        this.component = component;
        this.userId = userId;

        addFriendController = new AddFriendController(this.component.getAddFriendComponent());
        addFriendController.setUserId(userId);

    }

    public FriendsVerticalMainComponent getComponent() {
        return component;
    }

    public void setComponent(FriendsVerticalMainComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
