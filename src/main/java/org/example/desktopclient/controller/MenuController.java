package org.example.desktopclient.controller;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.desktopclient.component.MenuComponent;
import org.example.desktopclient.scene.CustomScene;
import org.example.desktopclient.scene.GameCatalogScene;
import org.example.desktopclient.scene.GameProductPageScene;
import org.example.desktopclient.scene.UserGameCollectionScene;

import javax.swing.*;
import java.util.Arrays;

public class MenuController {
    private MenuComponent component;
    private String activePage;
    private Stage primaryStage;

    public MenuController(MenuComponent component, Stage primaryStage) {
        this.component = component;
        this.primaryStage = primaryStage;
        this.handleClick();
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

    public void handleClick() {

        component.getCatalogText().setOnMouseClicked(e -> {
            if (activePage != "Catalog")
                changeScene("Catalog", GameCatalogScene.getInstance());

        });

        component.getMyGamesText().setOnMouseClicked(e -> {
            if (activePage != "My Games")
                changeScene("My Games", UserGameCollectionScene.getInstance());
        });


    }

    public void changeScene(String activePage, CustomScene customScene) {
        setActivePage(activePage);
        Double width =  primaryStage.getWidth();
        Double height =  primaryStage.getHeight();

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


}
