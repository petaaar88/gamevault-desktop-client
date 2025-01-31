package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class PaginationComponent {

    public HBox getCompoenent(){
        HBox layout = new HBox();

        layout.setPadding(new Insets(20));

        String css = getClass().getResource("/org/example/desktopclient/styles/paginationComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        Button leftArrow =new Button("<");
        leftArrow.getStyleClass().add("pagination-item");
        Button text =new Button("1");
        text.getStyleClass().add("pagination-item");
        Button text2 =new Button("2");
        text2.getStyleClass().add("current-page");
        Button text3 =new Button("3");
        text3.getStyleClass().add("pagination-item");
        Button rightArrow =new Button(">");
        rightArrow.getStyleClass().add("pagination-item");

        text.setStyle("-fx-fill: white");
        layout.getChildren().addAll(leftArrow,text,text2, text3, rightArrow);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
