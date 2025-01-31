package org.example.desktopclient.component;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.Collection;

public abstract class VerticalMainComponent {

    protected VBox layout;

    public abstract VBox getComponent();

    protected void setup(){
        layout = new VBox();
        layout.setAlignment(Pos.CENTER); // Centriranje sadržaja
        layout.setPrefWidth(1000); // Širina omotača
    }

    protected void addElements(Collection<Node> elements){
        layout.getChildren().addAll(elements);
    }
}
