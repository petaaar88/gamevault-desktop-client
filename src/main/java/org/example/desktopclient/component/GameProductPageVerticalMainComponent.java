package org.example.desktopclient.component;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collection;

public class GameProductPageVerticalMainComponent extends VerticalMainComponent{

    public GameProductPageVerticalMainComponent() {
    }

    @Override
    public VBox getComponent() {

        this.setup();

        GameDescription gameDescription = new GameDescription();

        Collection<Node> elements = Arrays.asList(gameDescription.getComponent());
        this.addElements(elements);

        return layout;
    }
}
