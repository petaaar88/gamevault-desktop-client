package org.example.desktopclient.controller;

import javafx.scene.image.Image;
import org.example.desktopclient.component.FoundUserComponent;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.service.user.UserService;

public class FoundUserController {
    private FoundUserComponent component;
    private Integer userId;
    private UserService userService;

    public FoundUserController(FoundUserComponent component) {
        this.component = component;
        userService = new UserService();
    }

    public void handleClick(){
        component.getSendRequestButton().setOnMouseClicked(e->{
            //TODO: dodaj logiku da se prebaci na profile stranicu
            System.out.println(userId);

            component.getSendRequestButton().setDisable(true);
            component.getSendRequestButton().setText("Request Sent");
        });
    }

    public void setContent(FriendDTO user){
        FriendController friendController = new FriendController(component.getFriendComponent());
        friendController.setUserId(user.getId());
        friendController.getComponent().getUsernameLabel().setText(user.getUsername());
        friendController.getComponent().getImageView().setImage(new Image(user.getIcon()));
        friendController.handleClick();
    }


    public FoundUserComponent getComponent() {
        return component;
    }

    public void setComponent(FoundUserComponent component) {
        this.component = component;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
