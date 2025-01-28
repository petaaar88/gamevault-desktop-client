package org.example.desktopclient.component;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchComponent {
    public HBox getComponent() {
        HBox layout = new HBox();
        TextField textField = new TextField("Unestite nesto");

        layout.getChildren().add(textField);
        return layout;
    }
}

