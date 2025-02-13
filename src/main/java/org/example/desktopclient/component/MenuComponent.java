package org.example.desktopclient.component;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import org.example.desktopclient.model.user.User;

import java.util.ArrayList;
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
    private HBox rightSide;
    private Text usernameText;
    private ImageView profileIcon;
    private Button logoutButton;
    private Button profileButton;

    public MenuComponent() {
        layout = new HBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/menuScene.css").toExternalForm();
        layout.getStylesheets().add(css);

        layout.setMaxWidth(1000);
        layout.setMinWidth(1000);

        leftSide = new HBox(18);
        leftSide.setPadding(new Insets(5,0,0,0));
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

        rightSide = new HBox();
        usernameText = new Text("username");
        HBox.setMargin(usernameText, new Insets(8, 0, 0, 3));

        usernameText.getStyleClass().add("menu-username");


        profileIcon = new ImageView();
        profileIcon.setFitWidth(40);
        profileIcon.setFitHeight(40);
        profileIcon.setStyle("-fx-border-radius: 50px");
        Circle clip = new Circle(20, 20, 20);
        profileIcon.setClip(clip);

        Circle profileBorder = new Circle(23);
        profileBorder.setFill(Paint.valueOf("#0084FF"));

        StackPane profileIconStack = new StackPane(profileBorder, profileIcon);

        HBox hBox = new HBox(profileIconStack, usernameText);
        hBox.setSpacing(7);

        profileButton = new Button("", hBox);
        profileButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        profileButton.setOnMouseEntered(e->{
            profileButton.setStyle("-fx-background-color: #333352; -fx-cursor: hand;");
        });
        profileButton.setOnMouseExited(e->{
            profileButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        });

        logoutButton = new Button("Logout");
        logoutButton.setVisible(false); // U početku dugme nije vidljivo
        logoutButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-cursor: hand;-fx-font-weight: bold;-fx-font-size: 15px;-fx-padding: 5 18;");

        VBox profileBox = new VBox(profileButton, logoutButton);
        profileBox.setAlignment(Pos.CENTER_RIGHT);


        rightSide.getChildren().addAll(profileBox);

        HBox.setHgrow(leftSide, Priority.SOMETIMES);

        layout.getChildren().addAll(leftSide, rightSide);
    }

    public HBox getComponent() {
        return layout;
    }

    public void setContent(User user) {
        usernameText.setText(user.getUsername());
        profileIcon.setImage(new Image(user.getImageUrl()));
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

    public Button getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(Button logoutButton) {
        this.logoutButton = logoutButton;
    }

    public Button getProfileButton() {
        return profileButton;
    }

    public void setProfileButton(Button profileButton) {
        this.profileButton = profileButton;
    }
}
