package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collection;

public class EditProfileMainVerticalComponent extends VerticalMainComponent {

    public EditProfileMainVerticalComponent() {

    }


    @Override
    public VBox getComponent() {

        this.setup();

        VBox layout2 = new VBox();
        layout2.setPadding(new Insets(20,0,0,0));
        layout2.setMaxWidth(1000);
        layout2.setMinWidth(1000);
        layout2.setStyle("-fx-background-color: #333352");

        Text text = new Text("safdasd");


        layout2.getChildren().add(text);

        Collection<Node> elements = Arrays.asList(layout2);
        this.addElements(elements);

        return layout;
    }
}
