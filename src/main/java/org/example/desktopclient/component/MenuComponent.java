package org.example.desktopclient.component;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class MenuComponent {
    public MenuComponent() {
    }

    public HBox getComponent(){
        HBox layout = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/menuScene.css").toExternalForm();
        layout.getStylesheets().add(css);



        layout.setMaxWidth(1000);
        layout.setMinWidth(1000);


        HBox leftSide = new HBox(18);
        Text catalogText = new Text("Catalog");
        Text myGamesText = new Text("My Games");
        Text friendsText = new Text("Friends");
        Text profileText = new Text("Profile");

        catalogText.getStyleClass().add("menu-item");
        myGamesText.getStyleClass().add("menu-item");
        friendsText.getStyleClass().add("menu-item");
        profileText.getStyleClass().add("menu-item");


        HBox rightSide = new HBox();
        Text usernameText = new Text("username");
        HBox.setMargin(usernameText, new Insets(5,0,0,5));

        usernameText.getStyleClass().add("menu-username");

        Image image = new Image("https://cdn-icons-png.flaticon.com/512/9187/9187604.png");
        ImageView profileIcon = new ImageView(image);
        profileIcon.setFitWidth(40);
        profileIcon.setFitHeight(40);

        rightSide.getChildren().addAll(profileIcon,usernameText);
        leftSide.getChildren().addAll(catalogText,myGamesText,friendsText,profileText);


        HBox.setHgrow(leftSide, Priority.SOMETIMES);

        layout.getChildren().addAll(leftSide,rightSide);

        return layout;
    }

}
