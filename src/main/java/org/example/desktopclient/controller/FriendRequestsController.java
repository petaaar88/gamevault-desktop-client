package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import org.example.desktopclient.component.FoundUserComponent;
import org.example.desktopclient.component.FriendRequestsComponent;
import org.example.desktopclient.model.user.SingleFriendRequestDTO;
import org.example.desktopclient.service.user.UserService;

import java.util.List;

public class FriendRequestsController {
    private FriendRequestsComponent component;
    private Integer userId;
    private UserService userService;
    private final Integer COLUMNS_PER_ROW_RECEIVED_REQUESTS = 2;
    private final Integer COLUMNS_PER_ROW_SENT_REQUESTS = 3;

    public FriendRequestsController(FriendRequestsComponent component) {
        this.component = component;

        userService = new UserService();
    }

    public void initialize() {
        Text loadingText = new Text("Loading...");
        loadingText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
        Text loadingText2 = new Text("Loading...");
        loadingText2.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");

        component.getReceivedRequestsGridPane().add(loadingText, 1, 0);
        component.getSentRequestsGridPane().add(loadingText2, 1, 0);


        userService.fetchFriendRequest(userId, requestsDTO -> {


            Platform.runLater(() -> {

                List<SingleFriendRequestDTO> receivedRequests = requestsDTO.getReceived();
                List<SingleFriendRequestDTO> sentRequests = requestsDTO.getSent();

                int col = 0;
                int row = 0;

                component.getReceivedRequestsGridPane().getChildren().clear();

                if (!receivedRequests.isEmpty()) {
                    for (int i = 1; i <= receivedRequests.size(); i++) {

                        FoundUserComponent foundUserComponent = new FoundUserComponent();
                        foundUserComponent.gethBox().getChildren().add(foundUserComponent.getDeleteRequestButton());
                        foundUserComponent.gethBox().setSpacing(5);
                        foundUserComponent.getSendRequestButton().setText("Accept");

                        foundUserComponent.getFriendComponent().getImageView().setImage(new Image(receivedRequests.get(i - 1).getUser().getIcon()));
                        foundUserComponent.getFriendComponent().getUsernameLabel().setText(receivedRequests.get(i - 1).getUser().getUsername());
                        FriendController friendController = new FriendController(foundUserComponent.getFriendComponent());
                        friendController.setUserId(receivedRequests.get(i - 1).getUser().getId());
                        friendController.handleClick();

                        FoundUserController foundUserController = new FoundUserController(foundUserComponent);
                        foundUserController.setUserId(receivedRequests.get(i - 1).getUser().getId());
                        foundUserController.setRequestId(receivedRequests.get(i - 1).getRequestId());
                        foundUserController.setSenderId(userId);
                        foundUserController.setUserId(userId);
                        foundUserController.handleAcceptButtonClick();
                        foundUserController.handleDeleteButtonClick();


                        component.getReceivedRequestsGridPane().add(foundUserComponent.getComponent(), col, row);

                        col++;
                        if (col == COLUMNS_PER_ROW_RECEIVED_REQUESTS) {
                            col = 0;
                            row++;
                        }
                    }
                    col = 0;
                    row = 0;
                } else {
                    Text noRequestsText = new Text("No requests");
                    noRequestsText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
                    component.getReceivedRequestsGridPane().add(noRequestsText, 1, 0);
                }

                component.getSentRequestsGridPane().getChildren().clear();

                if(!sentRequests.isEmpty()) {
                    for (int i = 1; i <= sentRequests.size(); i++) {

                        FoundUserComponent foundUserComponent = new FoundUserComponent();
                        foundUserComponent.gethBox().getChildren().removeLast();
                        foundUserComponent.gethBox().getChildren().add(foundUserComponent.getDeleteRequestButton());
                        foundUserComponent.gethBox().setSpacing(5);

                        FoundUserController foundUserController = new FoundUserController(foundUserComponent);
                        foundUserController.setUserId(sentRequests.get(i - 1).getUser().getId());
                        foundUserController.setRequestId(sentRequests.get(i - 1).getRequestId());
                        foundUserController.handleDeleteButtonClick();

                        foundUserComponent.getFriendComponent().getImageView().setImage(new Image(sentRequests.get(i - 1).getUser().getIcon()));
                        foundUserComponent.getFriendComponent().getUsernameLabel().setText(sentRequests.get(i - 1).getUser().getUsername());
                        FriendController friendController = new FriendController(foundUserComponent.getFriendComponent());
                        friendController.setUserId(sentRequests.get(i - 1).getUser().getId());
                        friendController.handleClick();

                        component.getSentRequestsGridPane().add(foundUserComponent.getComponent(), col, row);

                        col++;
                        if (col == COLUMNS_PER_ROW_SENT_REQUESTS) {
                            col = 0;
                            row++;
                        }
                    }
                }
                else {
                    Text noRequestsText = new Text("No requests");
                    noRequestsText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
                    component.getSentRequestsGridPane().add(noRequestsText, 1, 0);
                }




            });
        });

    }

    public FriendRequestsComponent getComponent() {
        return component;
    }

    public void setComponent(FriendRequestsComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
