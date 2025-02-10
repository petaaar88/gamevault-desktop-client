package org.example.desktopclient.controller;

import javafx.scene.control.Label;
import org.example.desktopclient.component.GameGenresComponent;

import java.util.Arrays;
import java.util.List;

public class GameGenresController {
    private GameGenresComponent component;
    private final Integer MAX_GENRES_IN_ROW = 3;

    public GameGenresController(GameGenresComponent component){
        this.component = component;
    }

    public GameGenresComponent getComponent() {
        return component;
    }

    public void setContent(List<String> genres) {
        component.getLayout().getChildren().clear(); // Brisanje prethodnog sadržaja

        int colIndex = 0;
        int rowIndex = 0;

        for (String genre : genres) {
            Label genreText = new Label(genre);
            genreText.getStyleClass().add("game-genre");

            component.getComponent().addRow(rowIndex, genreText); // Dodavanje u GridPane
            component.getComponent().setColumnIndex(genreText, colIndex); // Postavljanje kolone
            component.getComponent().setRowIndex(genreText, rowIndex); // Postavljanje reda
            component.getLayout().setVgap(5);

            colIndex++;
            if (colIndex == MAX_GENRES_IN_ROW) { // Kada popunimo dva žanra u redu, prebacujemo se na sledeći red
                colIndex = 0;
                rowIndex++;
            }
        }
    }

    public void setComponent(GameGenresComponent component) {
        this.component = component;
    }
}
