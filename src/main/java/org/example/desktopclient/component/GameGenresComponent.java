package org.example.desktopclient.component;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.List;

public class GameGenresComponent {

    public GridPane getComponent() {

        GridPane layout = new GridPane();
        layout.setHgap(5);

        String css = getClass().getResource("/org/example/desktopclient/styles/gameGenresComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        List<String> genres = Arrays.asList("RPG","Action", "Adventure");

        genres.forEach(genre->{
            Label genreText = new Label(genre);
            genreText.getStyleClass().add("game-genre");

            layout.addRow(0, genreText);

        });

        return layout;

    }
}
