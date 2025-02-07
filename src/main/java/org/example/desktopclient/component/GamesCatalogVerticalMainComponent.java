package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Collection;

public class GamesCatalogVerticalMainComponent extends VerticalMainComponent {

    private GridPane gridPane;
    private PaginationComponent paginationComponent;


    public GamesCatalogVerticalMainComponent() {
        this.setup();
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(0, 0, 0, 0));

        paginationComponent = new PaginationComponent();

        Collection<Node> elements = Arrays.asList(gridPane, paginationComponent.getCompoenent());

        this.addElements(elements);
    }

    @Override
    public VBox getComponent() {

        return layout;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public PaginationComponent getPaginationComponent() {
        return paginationComponent;
    }

    public void setPaginationComponent(PaginationComponent paginationComponent) {
        this.paginationComponent = paginationComponent;
    }
}
