package org.example.desktopclient.controller;

import org.example.desktopclient.component.FriendComponent;

public class FriendController {
    private Integer userId;
    private FriendComponent component;

    public FriendController(FriendComponent component) {
        this.component = component;
    }

    public void handleClick(){
        component.getButton().setOnMouseClicked(e->{
            //TODO: dodaj logiku da se prebaci na profile stranicu
            System.out.println(userId);
        });
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public FriendComponent getComponent() {
        return component;
    }

    public void setComponent(FriendComponent component) {
        this.component = component;
    }
}
