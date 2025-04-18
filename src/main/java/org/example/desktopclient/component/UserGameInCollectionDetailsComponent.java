package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.desktopclient.model.game.GameInUserCollectionDetails;
import org.example.desktopclient.scene.ProfilePageScene;
import org.example.desktopclient.util.SceneChanger;
import org.example.desktopclient.util.CustomDateFormatter;
import org.example.desktopclient.util.NumberFormatter;

import java.util.Objects;

public class UserGameInCollectionDetailsComponent {
    private ImageView coverImage;
    private GameInLibraryActionButtonComponent gameInLibraryActionButtonComponent;
    private VBox layout;
    private Label descriptionLabel;
    private Text lastPlayedText;
    private Text playtimeText;
    private HBox descriptionAndFriendsHBox;
    private Label gameTitleLabel;
    private Button deleteButton;

    public UserGameInCollectionDetailsComponent() {
        coverImage = new ImageView();
        gameInLibraryActionButtonComponent = new GameInLibraryActionButtonComponent();
        layout = new VBox();


        coverImage.setFitWidth(760);
        coverImage.setFitHeight(260);
        layout.setSpacing(15);
        gameTitleLabel = new Label("");
        gameTitleLabel.setLayoutX(25);
        gameTitleLabel.setLayoutY(205);
        gameTitleLabel.setStyle("-fx-font-size: 32px;-fx-fill: white;-fx-font-weight: 700;-fx-stroke: black; -fx-stroke-width: 1;");
        Rectangle gradientOverlay = new Rectangle(760, 260);
        gradientOverlay.setFill(new LinearGradient(
                0, 1, 0, 0,  // Od dole ka gore
                true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.color(0, 0, 0, 0.6)),  // Tamnija nijansa na dnu
                new Stop(1, Color.color(0, 0, 0, 0))     // Prozirno na vrhu
        ));


        gradientOverlay.setBlendMode(BlendMode.MULTIPLY);
        Pane coverImagePane = new Pane(coverImage,gradientOverlay, gameTitleLabel);
        coverImagePane.setMinHeight(260);
        coverImagePane.setMaxHeight(260);

        HBox actionAndStatsHbox = new HBox();
        actionAndStatsHbox.setPadding(new Insets(13, 18, 13, 18));
        VBox imageAndActionVbox = new VBox(coverImagePane, actionAndStatsHbox);
        actionAndStatsHbox.setStyle("-fx-background-color: #333352");
        Text lastPlayedTitle = new Text("Last Played");
        lastPlayedTitle.setStyle("-fx-fill: white;-fx-font-size: 15px;-fx-font-weight: 700;");
        lastPlayedText = new Text("");
        lastPlayedText.setStyle("-fx-fill: white;-fx-font-size: 14px;-fx-font-weight: 600");
        VBox lastPlayedVBox = new VBox(lastPlayedTitle, lastPlayedText);

        Text playtimeTitle = new Text("Playtime");
        playtimeTitle.setStyle("-fx-fill: white;-fx-font-size: 15px;-fx-font-weight: 700;");
        playtimeText = new Text("");
        playtimeText.setStyle("-fx-fill: white;-fx-font-size: 14px;-fx-font-weight: 600");
        VBox playtimeVBox = new VBox(playtimeTitle, playtimeText);

        ImageView deleteImageView = new ImageView(new Image(getClass().getResource("/org/example/desktopclient/icons/settingsIcon.png").toExternalForm()));
        deleteImageView.setFitHeight(33);
        deleteImageView.setFitWidth(33);
        deleteButton = new Button("", deleteImageView);
        deleteButton.setStyle("-fx-background-color:transparent; -fx-cursor: hand");
        deleteButton.setVisible(false);

        HBox hbox = new HBox(gameInLibraryActionButtonComponent.getComponent(), lastPlayedVBox, playtimeVBox);
        HBox.setHgrow(hbox, Priority.ALWAYS);
        hbox.setSpacing(22);
        actionAndStatsHbox.getChildren().addAll(hbox, deleteButton);

        Text descriptionText = new Text("Description");
        descriptionText.setStyle("-fx-fill: #8079CB; -fx-font-size: 20px; -fx-font-weight: 700;");
        descriptionLabel = new Label("");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setMaxWidth(350); // Postavi na širinu pri kojoj treba da se wrapuje
        descriptionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white");
        descriptionLabel.setMinHeight(Region.USE_PREF_SIZE);
        descriptionLabel.setPadding(new Insets(8, 0, 0, 0));

        VBox descriptionVbox = new VBox(descriptionText, descriptionLabel);
        descriptionVbox.setStyle("-fx-background-color: #333352");
        descriptionVbox.setPadding(new Insets(10));
        descriptionVbox.setMinHeight(250);


        descriptionAndFriendsHBox = new HBox(descriptionVbox);
        HBox.setHgrow(descriptionVbox, Priority.ALWAYS);
        descriptionAndFriendsHBox.setSpacing(15);

        ScrollComponent scrollComponent = new ScrollComponent();

        VBox vBox = new VBox(imageAndActionVbox, descriptionAndFriendsHBox);
        vBox.setSpacing(15);

        layout.getChildren().addAll(scrollComponent.getComponent(vBox));
        scrollComponent.setPaddingX(0);
    }

    public VBox getComponent() {
        return layout;
    }


    public void setNewContent(GameInUserCollectionDetails game) {
        coverImage.setImage(new Image(game.getImage()));
        descriptionLabel.setText(game.getDescription());
        gameTitleLabel.setText(game.getTitle());

        String lastPlayed = Objects.isNull(game.getLastPlayed()) ? "Never played" : CustomDateFormatter.formatDateTimeOfPattern2(game.getLastPlayed(), "d MMM yyyy");
        lastPlayedText.setText(lastPlayed);

        String playtime = String.valueOf(NumberFormatter.roundDecimals(game.getPlayTime()));

        playtimeText.setText(playtime + " Hours");
        if (descriptionAndFriendsHBox.getChildren().size() == 2)
            descriptionAndFriendsHBox.getChildren().removeLast();

        if (!game.getFriends().isEmpty()) {
            FriendsThatPlayGameComponent friendsThatPlayGameComponent = new FriendsThatPlayGameComponent();
            descriptionAndFriendsHBox.getChildren().add(friendsThatPlayGameComponent.getComponent());

            game.getFriends().forEach(friendDTO -> {
                FriendComponent friendComponent = new FriendComponent();
                friendComponent.getImageView().setImage(new Image(friendDTO.getIcon()));
                friendComponent.getUsernameLabel().setText(friendDTO.getUsername());
                friendComponent.getTextLabel().setText( NumberFormatter.roundDecimals(friendDTO.getHoursPlayed()) + " Hours");
                friendComponent.getUsernameLabel().setOnMouseClicked(e->{
                    ProfilePageScene.getInstance().setUserId(friendDTO.getId());

                    SceneChanger.changeScene(ProfilePageScene.getInstance().createScene());
                });
                friendsThatPlayGameComponent.getFriendsVbox().getChildren().add(friendComponent.getComponent());
            });
        }
    }

    public Label getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setDescriptionLabel(Label descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public GameInLibraryActionButtonComponent getGameInLibraryActionButtonComponent() {
        return gameInLibraryActionButtonComponent;
    }

    public void setGameInLibraryActionButtonComponent(GameInLibraryActionButtonComponent gameInLibraryActionButtonComponent) {
        this.gameInLibraryActionButtonComponent = gameInLibraryActionButtonComponent;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }
}
