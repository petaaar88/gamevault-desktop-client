package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GamesCatalogComponent {

    public ScrollPane getComponent() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(0, 0, 0, 0));

        // Dodavanje redova sa komponentama
        gridPane.addRow(0, new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent());
        gridPane.addRow(1, new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent(), new CatalogGameComponent().getComponent());

        // Omotač (StackPane) koji centrira GridPane
        StackPane stackPane = new StackPane(gridPane);
        stackPane.setAlignment(Pos.CENTER); // Centriranje sadržaja
        stackPane.setPrefWidth(1000); // Širina omotača

        // Kreiranje ScrollPane
        ScrollPane scrollPane = new ScrollPane(stackPane);
        scrollPane.setFitToWidth(true); // Osigurava da StackPane zauzima celu širinu
        scrollPane.setFitToHeight(true); // Prilagođava visinu

        // Postavljamo minimalnu visinu ScrollPane-a
        scrollPane.setMinHeight(400);

        // Onemogućavanje horizontalnog skrolovanja ako nije potrebno
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPadding(new Insets(0, 0, 0, 0));
        scrollPane.setStyle("-fx-background:#191B2E");
        String css = getClass().getResource("/org/example/desktopclient/styles/scrollPaneStyles.css").toExternalForm();
        scrollPane.getStylesheets().add(css);
        scrollPane.getStyleClass().add("scroll-pane");

        return scrollPane;
    }

}
