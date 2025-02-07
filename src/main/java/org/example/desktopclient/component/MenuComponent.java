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
    private HBox layout;
    private HBox leftSide;
    private VBox activePageBox;
    private Line activePageBottomLine;
    private Collection<Node> menuItems;
    private double leftBorder = 0;
    private Text activeText;
    private double startLinePosition = 0;
    private double endLinePosition = 0;
    private Text catalogText;
    private Text myGamesText;
    private Text friendsText;
    private Text profileText;

    public MenuComponent() {
        layout = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/menuScene.css").toExternalForm();
        layout.getStylesheets().add(css);

        layout.setMaxWidth(1000);
        layout.setMinWidth(1000);

        leftSide = new HBox(18);
        // Pravimo VBox za Catalog tekst i liniju
        activePageBox = new VBox();

        // Linija ispod Catalog sa uvučenjem
        activePageBottomLine = new Line();
        activePageBottomLine.getStyleClass().add("menu-item-line"); // CSS klasa za dodatni stil

        menuItems = new ArrayList<>();

        catalogText = new Text("Catalog");
        myGamesText = new Text("My Games");
        friendsText = new Text("Friends");
        profileText = new Text("Profile");

        catalogText.getStyleClass().add("menu-item");
        myGamesText.getStyleClass().add("menu-item");
        friendsText.getStyleClass().add("menu-item");
        profileText.getStyleClass().add("menu-item");
    }

    public HBox getComponent() {


        ////////////////////////////////////////////////

       // String activePage = "catalog";


//        switch (activePage){
//            case "catalog":
//                leftBorder =10;
//                activeText = catalogText;
//                startLinePosition = 10;
//                endLinePosition = 80;
//                menuItems = Arrays.asList(activePageBox, myGamesText,friendsText,profileText);
//                break;
//            case "myGames":
//                leftBorder =10;
//                activeText = myGamesText;
//                startLinePosition = 10;
//                endLinePosition = 114;
//                menuItems = Arrays.asList(catalogText, activePageBox,friendsText,profileText);
//                break;
//            case "friends":
//                leftBorder =10;
//                activeText = friendsText;
//                startLinePosition = 10;
//                endLinePosition = 70;
//                menuItems = Arrays.asList(catalogText, myGamesText,activePageBox,profileText);
//                break;
//            case "profile":
//                leftBorder =10;
//                activeText = profileText;
//                startLinePosition = 10;
//                endLinePosition = 62;
//                menuItems = Arrays.asList(catalogText, myGamesText,friendsText,activePageBox);
//                break;
//            default:
//                break;
//        }


//        activePageBottomLine.setStartX(startLinePosition); // Uvučenje s leve strane
//        activePageBottomLine.setEndX(endLinePosition); // Dužina linije

//        VBox.setMargin(activePageBottomLine, new Insets(7, 0, 0, leftBorder)); // Pomera liniju dole i ulevo
//        activePageBox.getChildren().addAll(activeText, activePageBottomLine);
//
//
//        leftSide.getChildren().addAll(menuItems);


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
        //TODO: prepravi ovo
        layout.getChildren().clear();
        layout.getChildren().addAll(leftSide, rightSide);

        return layout;
    }


    public HBox getLayout() {
        return layout;
    }

    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    public HBox getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(HBox leftSide) {
        this.leftSide = leftSide;
    }

    public VBox getActivePageBox() {
        return activePageBox;
    }

    public void setActivePageBox(VBox activePageBox) {
        this.activePageBox = activePageBox;
    }

    public Line getActivePageBottomLine() {
        return activePageBottomLine;
    }

    public void setActivePageBottomLine(Line activePageBottomLine) {
        this.activePageBottomLine = activePageBottomLine;
    }

    public void setActivePageBottomLineStartX(Double startX) {
        this.activePageBottomLine.setStartX(startX);
    }

    public void setActivePageBottomLineEndX(Double endX) {
        this.activePageBottomLine.setEndX(endX);
    }


    public Collection<Node> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Collection<Node> menuItems) {
        this.menuItems = menuItems;
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public Text getActiveText() {
        return activeText;
    }

    public void setActiveText(Text activeText) {
        this.activeText = activeText;
    }

    public double getStartLinePosition() {
        return startLinePosition;
    }

    public void setStartLinePosition(double startLinePosition) {
        this.startLinePosition = startLinePosition;
    }

    public double getEndLinePosition() {
        return endLinePosition;
    }

    public void setEndLinePosition(double endLinePosition) {
        this.endLinePosition = endLinePosition;
    }

    public Text getCatalogText() {
        return catalogText;
    }

    public void setCatalogText(Text catalogText) {
        this.catalogText = catalogText;
    }

    public Text getMyGamesText() {
        return myGamesText;
    }

    public void setMyGamesText(Text myGamesText) {
        this.myGamesText = myGamesText;
    }

    public Text getFriendsText() {
        return friendsText;
    }

    public void setFriendsText(Text friendsText) {
        this.friendsText = friendsText;
    }

    public Text getProfileText() {
        return profileText;
    }

    public void setProfileText(Text profileText) {
        this.profileText = profileText;
    }
}
