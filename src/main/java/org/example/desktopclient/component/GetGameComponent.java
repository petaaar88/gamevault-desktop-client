package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class GetGameComponent {
    public VBox getComponent(String title, String downloadUrl){
        VBox layout = new VBox();
        layout.setMaxHeight(Region.USE_PREF_SIZE);


        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        layout.setMinWidth(630);
        layout.setMaxWidth(630);

        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #333352");


        Label gameTitle = new Label("Get " + title);
        gameTitle.setStyle("-fx-font-size: 21px");
        HBox gameTitleHbox = new HBox(gameTitle);
        ImageView imageView = new ImageView(new Image(getClass().getResource("/org/example/desktopclient/icons/windowsLogoIcon.png").toExternalForm()));
        imageView.setFitWidth(55);
        imageView.setFitHeight(30);
        HBox hBox = new HBox(gameTitleHbox, imageView);
        hBox.setPadding(new Insets(0,0,7,0));
        HBox.setHgrow(gameTitleHbox, Priority.ALWAYS);

        Button downloadButton = new Button("Add In Collection");
        downloadButton.getStyleClass().add("normal-action-button");
        layout.getChildren().addAll(hBox,downloadButton);

        return layout;
    }
}
