package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Collection;

public class GamesCatalogVerticalMainComponent extends VerticalMainComponent{

    @Override
    public VBox getComponent() {
        this.setup();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(0, 0, 0, 0));

        // Dodavanje redova sa komponentama
        gridPane.addRow(0, new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent());
        gridPane.addRow(1, new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent());

        PaginationComponent paginationComponent = new PaginationComponent();

        Collection<Node> elements = Arrays.asList(gridPane,paginationComponent.getCompoenent());

        this.addElements(elements);

        return layout;
    }

}
