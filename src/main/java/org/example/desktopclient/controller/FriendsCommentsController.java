package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.CustomerReviewComponent;
import org.example.desktopclient.component.FriendCommentComponent;
import org.example.desktopclient.component.FriendsCommentsComponent;
import org.example.desktopclient.model.game.GameReviewDTO;
import org.example.desktopclient.model.page.Pages;
import org.example.desktopclient.model.user.FriendCommentDTO;
import org.example.desktopclient.service.user.UserService;
import org.example.desktopclient.util.CustomDateFormatter;

import java.util.List;

public class FriendsCommentsController implements IPaginable {
    private FriendsCommentsComponent component;
    private Integer userId;
    private UserService userService;
    private final Integer LIMIT = 3;
    private Integer currentPage = 1;

    public FriendsCommentsController(FriendsCommentsComponent component, Integer userId) {
        this.component = component;
        this.userId = userId;

        userService = new UserService();

    }

    public void setContent() {
        userService.fetchAllCommentsOnUserProfile(userId, currentPage, LIMIT, comments -> {
            Platform.runLater(() -> {
                PaginationController paginationController = new PaginationController(component.getPaginationComponent());
                paginationController.handleClick();
                paginationController.setPaginableController(this);

                this.setupPagination(comments);
                component.getCommentsVbox().getChildren().clear();


                List<FriendCommentDTO> friendsComments = comments.getResoult();


                for (int i = 1; i <= friendsComments.size(); i++) {
                    CustomerReviewComponent customerReviewComponent = new CustomerReviewComponent();
                    customerReviewComponent.getLayout().setSpacing(0);
                    FriendCommentController friendCommentController = new FriendCommentController(customerReviewComponent);
                    friendCommentController.setContent(friendsComments.get(i - 1));

                    component.getCommentsVbox().getChildren().add(customerReviewComponent.getComponent());
                }

                component.getCommentsVbox().getChildren().add(component.getPaginationComponent().getCompoenent());
            });
        });
    }

    private void setupPagination(Pages<FriendCommentDTO> pages) {
        component.getPaginationComponent().getPagesHbox().getChildren().clear();

        if (pages.getPreviousPages().isEmpty() && pages.getNextPages().isEmpty()) {
            component.getPaginationComponent().getCompoenent().setVisible(false);
        } else
            component.getPaginationComponent().getCompoenent().setVisible(true);


        if (pages.getPreviousPages().isEmpty())
            component.getPaginationComponent().getLeftArrow().setVisible(false);
        else
            component.getPaginationComponent().getLeftArrow().setVisible(true);

        if (pages.getNextPages().isEmpty())
            component.getPaginationComponent().getRightArrow().setVisible(false);
        else
            component.getPaginationComponent().getRightArrow().setVisible(true);

        if (pages.getPreviousPages().isEmpty()) {
            component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
            if (!pages.getNextPages().isEmpty()) {
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(pages.getNextPages().get(0).getPage().toString()));

                if (pages.getNextPages().size() >= 2) {
                    Integer rightPageNumber = pages.getNextPages().get(1).getPage();
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(rightPageNumber.toString()));

                }

            }
        } else {
            if (!pages.getPreviousPages().isEmpty() && !pages.getNextPages().isEmpty()) {
                Integer previousPageNumber = pages.getPreviousPages().getLast().getPage();
                Integer nextPageNumber = pages.getNextPages().getFirst().getPage();
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(previousPageNumber.toString()));
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(nextPageNumber.toString()));
            } else if (pages.getNextPages().isEmpty()) {
                if (pages.getPreviousPages().size() >= 2) {
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(pages.getPreviousPages().getFirst().getPage().toString()));
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(pages.getPreviousPages().getLast().getPage().toString()));
                } else
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(pages.getPreviousPages().getLast().getPage().toString()));


                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
            }
        }
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


    @Override
    public void nextPage() {
        currentPage++;
        this.setContent();
    }

    @Override
    public void previousPage() {
        currentPage--;
        this.setContent();
    }

    @Override
    public void page(int page) {
        currentPage = page;
        this.setContent();
    }
}
