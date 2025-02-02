package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameDescriptionComponent {

    public VBox getComponent(){
        VBox layout = new VBox();

        layout.setPadding(new Insets(20,0,0,0));

        layout.setMinWidth(1000);
        layout.setMaxWidth(1000);

        Text gameTitleText = new Text("Red Dead Redemption 2");
        String css = getClass().getResource("/org/example/desktopclient/styles/gameDescriptionStyles.css").toExternalForm();
        layout.getStylesheets().add(css);
        gameTitleText.getStyleClass().add("game-description-title");

        HBox imageSliderAndDetailsHbox = new HBox();
        ImagesSliderComponent imagesSliderComponent = new ImagesSliderComponent();


        GameDetailsComponent gameDetailsComponent = new GameDetailsComponent();
        imageSliderAndDetailsHbox.setSpacing(24);
        imageSliderAndDetailsHbox.setPadding(new Insets(15,0,0,0));

        imageSliderAndDetailsHbox.getChildren().addAll(imagesSliderComponent.getComponent(),gameDetailsComponent.getComponent());


        layout.getChildren().addAll(gameTitleText, imageSliderAndDetailsHbox);
        return layout;
    }
}
