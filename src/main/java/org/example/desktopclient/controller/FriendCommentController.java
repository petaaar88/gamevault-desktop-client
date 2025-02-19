package org.example.desktopclient.controller;

import javafx.scene.image.Image;
import org.example.desktopclient.component.CustomerReviewComponent;
import org.example.desktopclient.model.user.FriendCommentDTO;
import org.example.desktopclient.util.CustomDateFormatter;

public class FriendCommentController {
    private CustomerReviewComponent component;

    public FriendCommentController(CustomerReviewComponent component) {
        this.component = component;
    }

    public void setContent(FriendCommentDTO friendComment) {
        {

            component.getRatingHbox().getChildren().clear();
            component.getCommentContentLabel().setText(friendComment.getContent());
            component.getPostedDateText().setText(CustomDateFormatter.formatDateOfPattern(friendComment.getAddedAt(), "d. MMM yyyy"));
            FriendController friendController = new FriendController(component.getFriendComponent());
            friendController.setUserId(friendComment.getUser().getId());
            friendController.getComponent().getUsernameLabel().setText(friendComment.getUser().getUsername());
            friendController.getComponent().getImageView().setImage(new Image(friendComment.getUser().getIcon()));
            friendController.handleClick();

        }
    }

}
