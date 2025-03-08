package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.desktopclient.model.game.RecentPlayedGameDTO;
import org.example.desktopclient.util.CustomDateFormatter;
import org.example.desktopclient.util.RoundNumberUtil;

import java.util.Objects;

public class RecentGameComponent {
    private HBox layout;
    private ImageView imageView;
    private Label gameTitleLabel;
    private Label lastPlayedAtLabel;
    private Label playtimeOfGameLabel;

    public RecentGameComponent(){
        this.layout = new HBox();
        layout.setStyle("-fx-background-color: #191B2E");
        layout.setPadding(new Insets(13));
        imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setFitHeight(110);
        gameTitleLabel = new Label();
        gameTitleLabel.setStyle("-fx-font-size: 23;-fx-font-weight: bold");

        Label lastPlayedLabel = new Label("Last Played");
        lastPlayedLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 18");
        lastPlayedAtLabel = new Label();
        lastPlayedAtLabel.setStyle("-fx-font-size: 16");

        VBox lastPlayedVbox = new VBox(lastPlayedLabel,lastPlayedAtLabel);

        Label playtimeLabel = new Label("Playtime");
        playtimeLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 18");
        playtimeOfGameLabel = new Label();
        playtimeOfGameLabel.setStyle("-fx-font-size: 16");

        VBox playtimeVbox = new VBox(playtimeLabel, playtimeOfGameLabel);
        layout.setSpacing(15);
        HBox hBox = new HBox(lastPlayedVbox,playtimeVbox);
        hBox.setSpacing(15);

        VBox vbox = new VBox(gameTitleLabel,hBox);
        vbox.setSpacing(24);

        layout.getChildren().addAll(imageView,vbox);

    }

    public void setContent(RecentPlayedGameDTO recentPlayedGameDTO){
        imageView.setImage(new Image(recentPlayedGameDTO.getImage()));
        gameTitleLabel.setText(recentPlayedGameDTO.getTitle());

        String lastPlayedAt = Objects.isNull(recentPlayedGameDTO.getLastPlayedAt()) ? "Never Played" : CustomDateFormatter.formatDateTimeOfPattern2(recentPlayedGameDTO.getLastPlayedAt(),"d. MMM yyyy");

        lastPlayedAtLabel.setText(lastPlayedAt);

        playtimeOfGameLabel.setText(String.valueOf(RoundNumberUtil.roundDecimals(Double.parseDouble(recentPlayedGameDTO.getPlaytime())))  + " Hours");
    }

    public HBox getComponent(){
        return layout;
    }

    public HBox getLayout() {
        return layout;
    }

    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Label getGameTitleLabel() {
        return gameTitleLabel;
    }

    public void setGameTitleLabel(Label gameTitleLabel) {
        this.gameTitleLabel = gameTitleLabel;
    }

    public Label getLastPlayedAtLabel() {
        return lastPlayedAtLabel;
    }

    public void setLastPlayedAtLabel(Label lastPlayedAtLabel) {
        this.lastPlayedAtLabel = lastPlayedAtLabel;
    }

    public Label getPlaytimeOfGameLabel() {
        return playtimeOfGameLabel;
    }

    public void setPlaytimeOfGameLabel(Label playtimeOfGameLabel) {
        this.playtimeOfGameLabel = playtimeOfGameLabel;
    }
}
