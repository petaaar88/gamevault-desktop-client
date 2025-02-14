package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.example.desktopclient.component.CustomerReviewComponent;
import org.example.desktopclient.component.CustomerReviewsComponent;
import org.example.desktopclient.model.game.GameOverview;
import org.example.desktopclient.model.game.GameReviewDTO;
import org.example.desktopclient.model.page.Pages;
import org.example.desktopclient.service.game.GameService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class CustomerReviewsController implements IPaginable {
    private CustomerReviewsComponent component;
    private Integer currentPage;
    private Integer limit;
    private Integer gameId;
    private GameService gameService;

    public CustomerReviewsController(CustomerReviewsComponent component) {
        this.component = component;
        this.gameService = new GameService();
    }

    public void setContent(Pages<GameReviewDTO> reviewDTOPages){
        this.setupPagination(reviewDTOPages);
        component.getReviewsVbox().getChildren().clear();
        List<GameReviewDTO> reviews = reviewDTOPages.getResoult();

        reviews.forEach(review->{
            CustomerReviewComponent customerReviewComponent = new CustomerReviewComponent();
            customerReviewComponent.getCommentContentLabel().setText(review.getContent());

            customerReviewComponent.getRatingTypeText().setText(review.getRating());
            String reviewTextTypeString = review.getRating().toLowerCase().replace(' ', '_');
            String reviewTextClass = "game-description-review-" + reviewTextTypeString + "-color";
            customerReviewComponent.getRatingTypeText().getStyleClass().add(reviewTextClass);

            LocalDate date = LocalDate.parse(review.getPostedOn(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. MMM yyyy.", Locale.ENGLISH);
            String formattedDate = date.format(formatter);
            customerReviewComponent.getPostedDateText().setText(formattedDate);

            FriendController friendController = new FriendController(customerReviewComponent.getFriendComponent());
            friendController.setUserId(Integer.parseInt(review.getUser().get("id")));
            friendController.getComponent().getUsernameLabel().setText(review.getUser().get("username"));
            friendController.getComponent().getImageView().setImage(new Image(review.getUser().get("icon")));
            friendController.handleClick();

            component.getReviewsVbox().getChildren().add(customerReviewComponent.getComponent());
        });

        component.getReviewsVbox().getChildren().add(component.getPaginationComponent().getCompoenent());

    }

    private void setupPagination(Pages<GameReviewDTO> pages){
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
            if(!pages.getNextPages().isEmpty()){
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(pages.getNextPages().get(0).getPage().toString()));

                if (pages.getNextPages().size() >= 2) {
                    Integer rightPageNumber = pages.getNextPages().get(1).getPage();
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(rightPageNumber.toString()));

                }

            }
        }
        else{
            if(!pages.getPreviousPages().isEmpty() && !pages.getNextPages().isEmpty()){
                Integer previousPageNumber = pages.getPreviousPages().getLast().getPage();
                Integer nextPageNumber = pages.getNextPages().getFirst().getPage();
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(previousPageNumber.toString()));
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(nextPageNumber.toString()));
            }
            else if(pages.getNextPages().isEmpty()){
                if(pages.getPreviousPages().size() >=2){
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(pages.getPreviousPages().getFirst().getPage().toString()));
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(pages.getPreviousPages().getLast().getPage().toString()));
                }
                else
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(pages.getPreviousPages().getLast().getPage().toString()));


                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
            }
        }
    }


    public CustomerReviewsComponent getComponent() {
        return component;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public void nextPage() {
        currentPage++;
        gameService.fetchGamerReviews(gameId, currentPage, limit, callback1 -> {
            Platform.runLater(() -> {
                this.setContent(callback1);
            });
        });
    }

    @Override
    public void previousPage() {
        currentPage--;
        gameService.fetchGamerReviews(gameId, currentPage, limit, callback1 -> {
            Platform.runLater(() -> {
                this.setContent(callback1);
            });
        });
    }

    @Override
    public void page(int page) {
        currentPage = page;
        gameService.fetchGamerReviews(gameId, currentPage, limit, callback1 -> {
            Platform.runLater(() -> {
                this.setContent(callback1);
            });
        });
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
