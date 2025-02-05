package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

public class ScrollComponent {

    private StackPane stackPane;
    private ScrollPane scrollPane;

    public StackPane getComponent(Node item) {

        scrollPane = new ScrollPane(item);
        scrollPane.setFitToWidth(true); // Osigurava da StackPane zauzima celu širinu
        scrollPane.setFitToHeight(true); // Prilagođava visinu

        // Postavljamo minimalnu visinu ScrollPane-a

        // Onemogućavanje horizontalnog skrolovanja ako nije potrebno
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPadding(new Insets(0, 0, 20, 0));
        scrollPane.setStyle("-fx-background:#191B2E");
        String css = getClass().getResource("/org/example/desktopclient/styles/scrollPaneStyles.css").toExternalForm();
        scrollPane.getStylesheets().add(css);
        scrollPane.getStyleClass().add("scroll-pane");

        stackPane = new StackPane(scrollPane);
        stackPane.setPadding(new Insets(0, 6, 0, 6));

        return stackPane;
    }

    public void setPaddingInline(Integer padding) {
        stackPane.setPadding(new Insets(0, padding, 0, padding));
    }

    public void setBackgroundColor(String color){
        scrollPane.setStyle("-fx-background: "+color);
    }
}
