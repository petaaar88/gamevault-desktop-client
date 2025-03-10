package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.model.user.User;
import org.example.desktopclient.scene.*;
import org.example.desktopclient.service.game.GameService;
import org.example.desktopclient.service.user.UserService;
import org.example.desktopclient.util.ChangeSceneUtil;

import java.util.Arrays;

public class MenuController {
    private MenuComponent component;
    private String activePage;
    private Stage primaryStage;
    private User user;

    public MenuController(MenuComponent component, Stage primaryStage) {
        this.component = component;
        this.primaryStage = primaryStage;
        this.handleClick();
        this.handleProfileButtonClick();
        this.handleLogoutButtonClick();
    }


    public void setMenuComponent(MenuComponent component) {
        this.component = component;
    }

    public MenuComponent getMenuComponent() {
        return component;
    }

    public void setActivePage(String activePage) {
        this.activePage = activePage;
    }

    public String getActivePage() {
        return activePage;
    }

    public void handleProfileButtonClick() {
        component.getProfileButton().setOnMouseClicked(e -> {
            component.getLogoutButton().setVisible(!component.getLogoutButton().isVisible());
        });
    }

    public void handleLogoutButtonClick() {
        component.getLogoutButton().setOnMouseClicked(e -> {
            if (component.getLogoutButton().isVisible()) {
                component.getLogoutButton().setVisible(false); // Sakrij dropdown dugme
                UserService userService = new UserService();

                userService.logoutUser(user.getId(), c -> {
                    Platform.runLater(() -> {
                        ChangeSceneUtil.changeScene(LoginScene.getInstance().createScene());
                    });
                });

            }
        });
    }

    public void handleClick() {

        component.getCatalogText().setOnMouseClicked(e -> {
            changeScene("Catalog", GameCatalogScene.getInstance());

        });

        component.getMyGamesText().setOnMouseClicked(e -> {
            if (activePage != "My Games"){
                GameService gameService = new GameService();
                gameService.fetchUserGameCollection(user.getId(), games -> {
                    Platform.runLater(() -> {
                        if(!games.isEmpty())
                            changeScene("My Games", UserGameCollectionScene.getInstance());
                        else
                            showAlert("You don't have any games in your collection!");
                    });
                });
            }
        });

        component.getFriendsText().setOnMouseClicked(e -> {
            if (activePage != "Friends")
                changeScene("Friends", FriendsScene.getInstance());
        });

        component.getProfileText().setOnMouseClicked(e -> {
            ProfilePageScene.getInstance().setUserId(user.getId());
            changeScene("Profile", ProfilePageScene.getInstance());
        });

    }

    public void changeScene(String activePage, CustomScene customScene) {
        setActivePage(activePage);
        Double width = primaryStage.getWidth();
        Double height = primaryStage.getHeight();

        customScene.getPrimaryStage().setScene(customScene.createScene());
        primaryStage.setWidth(width.doubleValue());
        primaryStage.setHeight(height.doubleValue());
    }


    public void setActiveItemInMenu(String activePage) {

        this.activePage = activePage;
        //if(!component.getMenuItems().isEmpty() || component.getMenuItems() !=null)
        // component.getMenuItems().clear();

        switch (activePage) {
            case "Catalog":
                component.setLeftBorder(10);
                component.setActiveText(component.getCatalogText());
                component.setStartLinePosition(10);
                component.setEndLinePosition(80);
                component.setMenuItems(Arrays.asList(component.getActivePageBox(), component.getMyGamesText(), component.getFriendsText(), component.getProfileText()));
                break;
            case "My Games":
                component.setLeftBorder(10);
                component.setActiveText(component.getMyGamesText());
                component.setStartLinePosition(10);
                component.setEndLinePosition(114);
                component.setMenuItems(Arrays.asList(component.getCatalogText(), component.getActivePageBox(), component.getFriendsText(), component.getProfileText()));
                break;
            case "Friends":
                component.setLeftBorder(10);
                component.setActiveText(component.getFriendsText());
                component.setStartLinePosition(10);
                component.setEndLinePosition(70);
                component.setMenuItems(Arrays.asList(component.getCatalogText(), component.getMyGamesText(), component.getActivePageBox(), component.getProfileText()));
                break;
            case "Profile":
                component.setLeftBorder(10);
                component.setActiveText(component.getProfileText());
                component.setStartLinePosition(10);
                component.setEndLinePosition(62);
                component.setMenuItems(Arrays.asList(component.getCatalogText(), component.getMyGamesText(), component.getFriendsText(), component.getActivePageBox()));
                break;
            default:
                break;
        }

        component.setActivePageBottomLineStartX(component.getStartLinePosition());
        component.setActivePageBottomLineEndX(component.getEndLinePosition());// Uvučenje s leve strane


        VBox.setMargin(component.getActivePageBottomLine(), new Insets(7, 0, 0, component.getLeftBorder())); // Pomera liniju dole i ulevo
        component.getActivePageBox().getChildren().clear();
        component.getActivePageBox().getChildren().addAll(component.getActiveText(), component.getActivePageBottomLine());

        component.getLeftSide().getChildren().clear();
        component.getLeftSide().getChildren().addAll(component.getMenuItems());

    }

    public void setUser(User user) {
        this.user = user;
        component.setContent(user);

    }

    public User getUser() {
        return user;
    }

    public void showAlert(String message) {
        Stage alertStage = new Stage();
        alertStage.initStyle(StageStyle.UNDECORATED); // Uklanja naslovnu traku
        alertStage.initModality(Modality.APPLICATION_MODAL); // Blokira interakciju sa glavnim prozorom dok je alert otvoren

        // Tekst poruke
        Label alertText = new Label(message);
        alertText.setStyle("-fx-font-size: 25px;-fx-text-fill: white");

        // Dugme za zatvaranje
        Button closeButton = new Button("OK");
        closeButton.setStyle("-fx-background-color: #0084FF;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:14px;-fx-padding: 5 14 5 14;-fx-font-weight:700");
        closeButton.setOnAction(ec -> alertStage.close());

        // Pravljenje layout-a
        VBox alertLayout = new VBox(10, alertText, closeButton);
        alertLayout.setAlignment(Pos.CENTER);
        alertLayout.setStyle("-fx-background-color: #191B2E;-fx-border-color:#333352;-fx-border-width: 2px; -fx-padding: 25px 50px 25px 50px;");

        Scene alertScene = new Scene(alertLayout);
        alertScene.setFill(Color.TRANSPARENT); // Ako želiš prozirnu pozadinu

        alertStage.setScene(alertScene);
        alertStage.showAndWait();
    }


}
