package org.example.desktopclient.component;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.List;

public class GameGenresComponent {

    private GridPane layout;

    public GameGenresComponent(){
        layout = new GridPane();
        layout.setHgap(5);

        String css = getClass().getResource("/org/example/desktopclient/styles/gameGenresComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);
    }


    public GridPane getComponent() {
        return layout;
    }

    public GridPane getLayout() {
        return layout;
    }

    public void setLayout(GridPane layout) {
        this.layout = layout;
    }
}
