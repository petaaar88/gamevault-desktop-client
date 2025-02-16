package org.example.desktopclient.controller;

import org.example.desktopclient.component.FriendsVerticalMainComponent;

public class FriendsVerticalMainController {
    private FriendsVerticalMainComponent component;
    private AddFriendController addFriendController;
    private FriendRequestsController friendRequestsController;
    private AllFriendsController allFriendsController;
    private Integer userId;

    public FriendsVerticalMainController(FriendsVerticalMainComponent component,Integer userId) {
        this.component = component;
        this.userId = userId;

        addFriendController = new AddFriendController(this.component.getAddFriendComponent());
        addFriendController.setUserId(userId);

        friendRequestsController = new FriendRequestsController(this.component.getFriendRequestsComponent());
        friendRequestsController.setUserId(userId);
        friendRequestsController.initialize();

        allFriendsController = new AllFriendsController(this.component.getAllFriendsComponent());
        allFriendsController.setUserId(userId);
        allFriendsController.initialize();

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
