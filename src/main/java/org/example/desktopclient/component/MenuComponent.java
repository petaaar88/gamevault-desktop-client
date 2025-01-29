package org.example.desktopclient.component;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MenuComponent {
    public MenuComponent() {
    }

    public HBox getComponent() {
        HBox layout = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/menuScene.css").toExternalForm();
        layout.getStylesheets().add(css);

        layout.setMaxWidth(1000);
        layout.setMinWidth(1000);

        HBox leftSide = new HBox(18);


        // Pravimo VBox za Catalog tekst i liniju
        VBox activePageBox = new VBox();


        Text catalogText = new Text("Catalog");
        Text myGamesText = new Text("My Games");
        Text friendsText = new Text("Friends");
        Text profileText = new Text("Profile");

        catalogText.getStyleClass().add("menu-item");
        myGamesText.getStyleClass().add("menu-item");
        friendsText.getStyleClass().add("menu-item");
        profileText.getStyleClass().add("menu-item");


        // Linija ispod Catalog sa uvučenjem
        Line activePageBottomLine = new Line();
        activePageBottomLine.getStyleClass().add("menu-item-line"); // CSS klasa za dodatni stil

        ////////////////////////////////////////////////

        String activePage = "catalog";

        Collection<Node> menuItems = new ArrayList<>();
        double leftBorder = 0;
        Text activeText = new Text();
        double startLinePosition = 0;
        double endLinePosition = 0;

        switch (activePage){
            case "catalog":
                leftBorder =10;
                activeText = catalogText;
                startLinePosition = 10;
                endLinePosition = 80;
                menuItems = Arrays.asList(activePageBox, myGamesText,friendsText,profileText);
                break;
            case "myGames":
                leftBorder =10;
                activeText = myGamesText;
                startLinePosition = 10;
                endLinePosition = 114;
                menuItems = Arrays.asList(catalogText, activePageBox,friendsText,profileText);
                break;
            case "friends":
                leftBorder =10;
                activeText = friendsText;
                startLinePosition = 10;
                endLinePosition = 70;
                menuItems = Arrays.asList(catalogText, myGamesText,activePageBox,profileText);
                break;
            case "profile":
                leftBorder =10;
                activeText = profileText;
                startLinePosition = 10;
                endLinePosition = 62;
                menuItems = Arrays.asList(catalogText, myGamesText,friendsText,activePageBox);
                break;
            default:
                break;
        }


        activePageBottomLine.setStartX(startLinePosition); // Uvučenje s leve strane
        activePageBottomLine.setEndX(endLinePosition); // Dužina linije

        VBox.setMargin(activePageBottomLine, new Insets(7, 0, 0, leftBorder)); // Pomera liniju dole i ulevo
        activePageBox.getChildren().addAll(activeText, activePageBottomLine);


        leftSide.getChildren().addAll(menuItems);


        //////////////////////////////////////////////////////


        HBox rightSide = new HBox();
        Text usernameText = new Text("username");
        HBox.setMargin(usernameText, new Insets(5, 0, 0, 5));

        usernameText.getStyleClass().add("menu-username");

        Image image = new Image("https://cdn-icons-png.flaticon.com/512/9187/9187604.png");
        ImageView profileIcon = new ImageView(image);
        profileIcon.setFitWidth(40);
        profileIcon.setFitHeight(40);

        rightSide.getChildren().addAll(profileIcon, usernameText);

        HBox.setHgrow(leftSide, Priority.SOMETIMES);
        layout.getChildren().addAll(leftSide, rightSide);

        return layout;
    }



}
