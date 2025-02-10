package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.desktopclient.controller.GameDetailsController;

public class GameDescriptionComponent {

    private Text gameTitleText;
    private VBox layout;
    private HBox imageSliderAndDetailsHbox;
    private GameDetailsController gameDetailsController;


    public GameDescriptionComponent() {
        layout = new VBox();

        layout.setPadding(new Insets(20,0,0,0));

        layout.setMinWidth(1000);
        layout.setMaxWidth(1000);


        gameTitleText = new Text();

        String css = getClass().getResource("/org/example/desktopclient/styles/gameDescriptionStyles.css").toExternalForm();
        layout.getStylesheets().add(css);
        gameTitleText.getStyleClass().add("game-description-title");

        imageSliderAndDetailsHbox = new HBox();
        ImagesSliderComponent imagesSliderComponent = new ImagesSliderComponent();


        GameDetailsComponent gameDetailsComponent = new GameDetailsComponent();
        gameDetailsController = new GameDetailsController(gameDetailsComponent);

        imageSliderAndDetailsHbox.setSpacing(24);
        imageSliderAndDetailsHbox.setPadding(new Insets(15,0,0,0));

        imageSliderAndDetailsHbox.getChildren().addAll(imagesSliderComponent.getComponent(),gameDetailsComponent.getComponent());


        layout.getChildren().addAll(gameTitleText, imageSliderAndDetailsHbox);
    }

    public VBox getComponent(){

        return layout;
    }

    public Text getGameTitleText() {
        return gameTitleText;
    }

    public void setGameTitleText(Text gameTitleText) {
        this.gameTitleText = gameTitleText;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public HBox getImageSliderAndDetailsHbox() {
        return imageSliderAndDetailsHbox;
    }

    public void setImageSliderAndDetailsHbox(HBox imageSliderAndDetailsHbox) {
        this.imageSliderAndDetailsHbox = imageSliderAndDetailsHbox;
    }

    public GameDetailsController getGameDetailsController() {
        return gameDetailsController;
    }

    public void setGameDetailsController(GameDetailsController gameDetailsController) {
        this.gameDetailsController = gameDetailsController;
    }
}
