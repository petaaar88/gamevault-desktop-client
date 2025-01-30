package org.example.desktopclient.component;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.lang.foreign.GroupLayout;

public class CatalogGameComponent {

    public Button getComponent() {

        VBox layout = new VBox();

        layout.setStyle("-fx-background-color: #333352");

        Image gameCatalogImage = new Image("https://store-images.s-microsoft.com/image/apps.21181.14244061853036130.7c2802a8-1b30-475c-bf05-1f4138de9fd0.0ff00a6d-8e75-4346-980c-12dcdb64778d?q=90&w=480&h=270");

        ImageView gameCatalogImageView = new ImageView(gameCatalogImage);
        gameCatalogImageView.setFitWidth(310);
        gameCatalogImageView.setFitHeight(180);

        Text gameTitleText = new Text("Red Dead Redemtion");


        layout.getChildren().addAll(gameCatalogImageView, gameTitleText,getGameStatsGridPane());

        Button button = new Button("", layout);

        return button;
    }

    private GridPane getGameStatsGridPane(){
        GridPane gameStatsGridPane = new GridPane();

        Image downloadIconImage = new Image(getClass().getResource("/org/example/desktopclient/icons/downloadIcon.png").toExternalForm());
        ImageView downloadIconImageView = new ImageView(downloadIconImage);
        downloadIconImageView.setFitHeight(30);
        downloadIconImageView.setFitWidth(30);

        Text downloadNumberText = new Text("123");
        HBox downloadHbox = new HBox(downloadIconImageView, downloadNumberText);


        Image reviewIconImage = new Image(getClass().getResource("/org/example/desktopclient/icons/downloadIcon.png").toExternalForm());
        ImageView reviewIconImageView = new ImageView(reviewIconImage);
        reviewIconImageView.setFitHeight(30);
        reviewIconImageView.setFitWidth(30);

        Text reviewPercentageText = new Text("85%");
        Text reviewNumberText = new Text("123");
        HBox reviewHbox = new HBox(reviewIconImageView, reviewPercentageText,reviewNumberText);

        Image developerIconImage = new Image( getClass().getResource("/org/example/desktopclient/icons/developerIcon.png").toExternalForm());
        ImageView developerIconImageView = new ImageView(developerIconImage);
        developerIconImageView.setFitWidth(30);
        developerIconImageView.setFitHeight(30);

        Text developerNameText = new Text("Rocstar");
        HBox developerHbox = new HBox(developerIconImageView, developerNameText);

        gameStatsGridPane.addRow(0,reviewHbox,downloadHbox);
        gameStatsGridPane.addRow(1,developerHbox);

        return gameStatsGridPane;
    }
}
