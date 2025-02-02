package org.example.desktopclient.component;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Collection;

public class GameProductPageVerticalMainComponent extends VerticalMainComponent{

    public GameProductPageVerticalMainComponent() {
    }

    @Override
    public VBox getComponent() {

        this.setup();

        GameDescriptionComponent gameDescriptionComponent = new GameDescriptionComponent();

        Collection<Node> elements = Arrays.asList(gameDescriptionComponent.getComponent());
        this.addElements(elements);

        return layout;
    }
}
