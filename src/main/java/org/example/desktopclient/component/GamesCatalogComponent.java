package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class GamesCatalogComponent {

    public GridPane getComponent(){
        GridPane gridPane = new GridPane();
        gridPane.setMaxWidth(1000);
        gridPane.setMinWidth(1000);
        gridPane.setPadding(new Insets(25,0,0,0));
        gridPane.addRow(0,new CatalogGameComponent().getComponent(),new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent());

        return gridPane;
    }

}
