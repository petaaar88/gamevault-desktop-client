package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameDescription {

    public VBox getComponent(){
        VBox layout = new VBox();

        layout.setPadding(new Insets(20,0,0,0));

        layout.setMinWidth(1000);
        layout.setMaxWidth(1000);

        Text gameTitleText = new Text("Red Dead Redemption 2");
        String css = getClass().getResource("/org/example/desktopclient/styles/gameDescriptionStyles.css").toExternalForm();
        layout.getStylesheets().add(css);
        gameTitleText.getStyleClass().add("game-description-title");

        HBox hBox = new HBox();
        ImageView imageView = new ImageView(new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2933620/ss_bf4e9aa33ea2cf6846e26ffdec5f1cdecbc39e61.600x338.jpg?t=1738088305"));
        imageView.setFitHeight(350);
        imageView.setFitWidth(630);
        GameDetailsComponent gameDetailsComponent = new GameDetailsComponent();
        hBox.setSpacing(24);
        hBox.setPadding(new Insets(15,0,0,0));

        hBox.getChildren().addAll(imageView,gameDetailsComponent.getComponent());

        layout.getChildren().addAll(gameTitleText, hBox);
        return layout;
    }
}
