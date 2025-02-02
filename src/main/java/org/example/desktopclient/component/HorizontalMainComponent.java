package org.example.desktopclient.component;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.util.Collection;

public abstract class HorizontalMainComponent {

    protected HBox layout;

    public abstract HBox getComponent();

    protected void setup(){
        layout = new HBox();
        //TODO: mozda ovo treba da se prepravi. Proveri kada bude pravio ovo
        layout.setAlignment(Pos.CENTER); // Centriranje sadržaja
        layout.setPrefWidth(1000); // Širina omotača
    }

    protected void addElements(Collection<Node> elements){
        layout.getChildren().addAll(elements);
    }
}
