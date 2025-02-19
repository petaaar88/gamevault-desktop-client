package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.CustomerReviewComponent;
import org.example.desktopclient.component.FriendCommentComponent;
import org.example.desktopclient.component.FriendsCommentsComponent;
import org.example.desktopclient.model.user.FriendCommentDTO;
import org.example.desktopclient.service.user.UserService;
import org.example.desktopclient.util.CustomDateFormatter;

import java.util.List;

public class FriendsCommentsController {
    private FriendsCommentsComponent component;
    private Integer userId;
    private UserService userService;
    private final Integer LIMIT = 5;
    private Integer currentPage = 1;

    public FriendsCommentsController(FriendsCommentsComponent component, Integer userId) {
        this.component = component;
        this.userId = userId;

        userService = new UserService();

    }

    public void setContent() {
        userService.fetchAllCommentsOnUserProfile(userId, currentPage, LIMIT, comments -> {
            Platform.runLater(() -> {
                List<FriendCommentDTO> friendsComments = comments.getResoult();

                component.getCommentsVbox().getChildren().clear();

                for (int i = 1; i <= friendsComments.size(); i++) {
                    CustomerReviewComponent customerReviewComponent = new CustomerReviewComponent();
                    customerReviewComponent.getLayout().setSpacing(0);
                    FriendCommentController friendCommentController = new FriendCommentController(customerReviewComponent);
                    friendCommentController.setContent(friendsComments.get(i-1));

                    component.getCommentsVbox().getChildren().add(customerReviewComponent.getComponent());
                }
            });
        });
    }

    public FriendsCommentsComponent getComponent() {
        return component;
    }

    public void setComponent(FriendsCommentsComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
