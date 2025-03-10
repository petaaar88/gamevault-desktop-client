package org.example.desktopclient.component;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FooterComponent {

    public HBox getComponents(){
        HBox hBox = new HBox();
        hBox.setMinHeight(40);
        hBox.setMaxHeight(40);
        Text text = new Text("");
        text.setStyle("-fx-fill: #575C96");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(text);
        hBox.setStyle("-fx-background-color:#0E0F1A");

        return hBox;
    }
}
