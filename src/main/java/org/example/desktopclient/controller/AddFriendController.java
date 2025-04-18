package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.text.Text;
import org.example.desktopclient.component.AddFriendComponent;
import org.example.desktopclient.component.FoundUserComponent;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

public class AddFriendController implements ISearchable {
    private AddFriendComponent component;
    private Integer userId;
    private SearchController searchController;
    private UserService userService;
    private final Integer RESULT_LIMIT_PER_PAGE = 6;
    private final Integer COLUMNS_PER_ROW = 3;
    private final Integer FIRST_PAGE_OF_RESULT = 1;

    public AddFriendController(AddFriendComponent component) {
        this.component = component;
        searchController = new SearchController(this.component.getSearchComponent());
        searchController.setSearchableController(this);

        userService = new UserService();
    }

    @Override
    public void search(String username) {

        if (username.isEmpty()) {
            return;
        }
        this.component.getFoundUsers().getChildren().clear();
        Text loadingText = new Text("Loading...");
        loadingText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
        this.component.getFoundUsers().add(loadingText, 1, 0);

        userService.fetchUsers(FIRST_PAGE_OF_RESULT, RESULT_LIMIT_PER_PAGE, userId, username, pages -> {
            Platform.runLater(() -> {
                List<FriendDTO> users = pages.getResoult();
                List<Integer> userIdsThatUserSendRequest = new ArrayList<>();
                List<Integer> userIdsThatUserReceiveRequest = new ArrayList<>();

                userService.fetchFriendRequest(userId, friendRequestsDTO -> {
                    Platform.runLater(() -> { // Dodajemo Platform.runLater ovde
                        friendRequestsDTO.getReceived().forEach(singleFriendRequestDTO ->
                                userIdsThatUserReceiveRequest.add(singleFriendRequestDTO.getUser().getId()));

                        friendRequestsDTO.getSent().forEach(singleFriendRequestDTO ->
                                userIdsThatUserSendRequest.add(singleFriendRequestDTO.getUser().getId()));

                        if (!users.isEmpty()) {
                            component.getFoundUsers().getChildren().clear();
                            int col = 0;
                            int row = 0;

                            for (int i = 1; i <= users.size(); i++) {
                                FoundUserComponent foundUserComponent = new FoundUserComponent();
                                FoundUserController foundUserController = new FoundUserController(foundUserComponent);
                                foundUserController.setUserId(users.get(i - 1).getId());

                                if (userIdsThatUserSendRequest.contains(users.get(i - 1).getId())) {
                                    foundUserController.getComponent().getSendRequestButton().setText("Request Sent");
                                    foundUserController.getComponent().getSendRequestButton().setDisable(true);
                                } else if (userIdsThatUserReceiveRequest.contains(users.get(i - 1).getId())) {
                                    foundUserController.getComponent().getSendRequestButton().setText("Received");
                                    foundUserController.getComponent().getSendRequestButton().setDisable(true);
                                } else {
                                    foundUserController.setSenderId(userId);
                                    foundUserController.handleClick();
                                }

                                foundUserController.setContent(users.get(i - 1));
                                component.getFoundUsers().add(foundUserComponent.getComponent(), col, row);

                                col++;
                                if (col == COLUMNS_PER_ROW) {
                                    col = 0;
                                    row++;
                                }
                            }
                        } else {
                            component.getFoundUsers().getChildren().clear();
                            Text noGameFound = new Text("No users found");
                            noGameFound.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
                            component.getFoundUsers().add(noGameFound, 1, 0);
                        }
                    });
                });
            });
        });

    }

    public AddFriendComponent getComponent() {
        return component;
    }

    public void setComponent(AddFriendComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
