package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import org.example.desktopclient.component.AllFriendsComponent;
import org.example.desktopclient.component.FriendComponent;
import org.example.desktopclient.model.user.FriendDTO;
import org.example.desktopclient.service.user.UserService;

import java.util.List;

public class AllFriendsController {
    private AllFriendsComponent component;
    private Integer userId;
    private UserService userService;
    private final Integer MAX_FRIENDS_PER_ROW = 4;

    public AllFriendsController(AllFriendsComponent component) {
        this.component = component;
        userService = new UserService();

    }

    public AllFriendsController(AllFriendsComponent component, Integer userId) {
        this.component = component;
        this.userId = userId;

        userService = new UserService();
    }

    public void initialize() {
        Text loadingText = new Text("Loading...");
        loadingText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
        Text loadingText2 = new Text("Loading...");
        loadingText2.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");

        component.getOnlineFriendsGridPane().add(loadingText, 1, 0);
        component.getOfflineFriendsGridPane().add(loadingText2, 1, 0);

        userService.fetchAllFriends(userId, friends -> {
            Platform.runLater(() -> {
                List<FriendDTO> onlineFriendsList = friends.getFriends().get("online");
                List<FriendDTO> offlineFriendsList = friends.getFriends().get("offline");

                component.getOnlineFriendsGridPane().getChildren().clear();
                component.getOfflineFriendsGridPane().getChildren().clear();

                int col = 0;
                int row = 0;

                if (!onlineFriendsList.isEmpty()) {
                    for (int i = 1; i <= onlineFriendsList.size(); i++) {
                        FriendComponent friendComponent = new FriendComponent();
                        friendComponent.getLayout().setMinWidth(220);
                        friendComponent.getLayout().setMaxWidth(220);

                        if (onlineFriendsList.get(i - 1).getInGame() != null) {
                            friendComponent.getTextLabel().setStyle(null);
                            friendComponent.getTextLabel().setStyle("-fx-font-weight: 200;-fx-text-fill: #D8E212");
                            friendComponent.getTextLabel().setText(onlineFriendsList.get(i - 1).getInGame());
                        }

                        FriendController friendController = new FriendController(friendComponent);
                        friendController.setUserId(onlineFriendsList.get(i - 1).getId());
                        friendController.getComponent().getUsernameLabel().setText(onlineFriendsList.get(i - 1).getUsername());
                        friendController.getComponent().getImageView().setImage(new Image(onlineFriendsList.get(i - 1).getIcon()));
                        friendController.handleClick();
                        component.getOnlineFriendsGridPane().add(friendComponent.getComponent(), col, row);
                        col += 1;
                        if (col == MAX_FRIENDS_PER_ROW) {
                            col = 0;
                            row += 1;
                        }
                    }

                    col = 0;
                    row = 0;

                } else {
                    Text noOnlineFriendsText = new Text("No online friends");
                    noOnlineFriendsText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
                    component.getOnlineFriendsGridPane().add(noOnlineFriendsText, 1, 0);
                }

                if (!offlineFriendsList.isEmpty()) {
                    for (int i = 1; i <= offlineFriendsList.size(); i++) {
                        FriendComponent friendComponent = new FriendComponent();
                        FriendController friendController = new FriendController(friendComponent);

                        friendComponent.getLayout().setMinWidth(220);
                        friendComponent.getLayout().setMaxWidth(220);

                        friendController.setUserId(offlineFriendsList.get(i - 1).getId());
                        friendController.getComponent().getUsernameLabel().setText(offlineFriendsList.get(i - 1).getUsername());
                        friendController.getComponent().getImageView().setImage(new Image(offlineFriendsList.get(i - 1).getIcon()));
                        friendController.handleClick();
                        component.getOfflineFriendsGridPane().add(friendComponent.getComponent(), col, row);
                        col += 1;
                        if (col == MAX_FRIENDS_PER_ROW) {
                            col = 0;
                            row += 1;
                        }
                    }
                } else {
                    Text noOfflineFriendsText = new Text("No offline friends");
                    noOfflineFriendsText.setStyle("-fx-fill: #575C96;-fx-font-size: 19px;-fx-font-weight: 700;-fx-padding: 350;");
                    component.getOfflineFriendsGridPane().add(noOfflineFriendsText, 1, 0);
                }

            });
        });

    }

    public AllFriendsComponent getComponent() {
        return component;
    }

    public void setComponent(AllFriendsComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
