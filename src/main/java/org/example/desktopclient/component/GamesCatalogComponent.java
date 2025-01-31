package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GamesCatalogComponent {

    public VBox getComponent() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(0, 0, 0, 0));

        // Dodavanje redova sa komponentama
        gridPane.addRow(0, new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent());
        gridPane.addRow(1, new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent());

        // Omotač (StackPane) koji centrira GridPane
        VBox layout = new VBox(gridPane);
        layout.setAlignment(Pos.CENTER); // Centriranje sadržaja
        layout.setPrefWidth(1000); // Širina omotača


        PaginationComponent paginationComponent = new PaginationComponent();
        layout.getChildren().add(paginationComponent.getCompoenent());

        return layout;
    }

}
