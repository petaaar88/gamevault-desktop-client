package org.example.desktopclient.component;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;

public class UsersGamesCollectionComponent {

    Collection<HBox> gamesHbox;

    public UsersGamesCollectionComponent() {
        gamesHbox = new ArrayList<>();
    }

    public VBox getComponent(){

        VBox layout = new VBox();
        layout.setMinWidth(300);
        layout.setMaxWidth(300);
        layout.setStyle("-fx-background-color: #333352");

        SearchComponent searchComponent = new SearchComponent();
        VBox searchComponentVbox = new VBox(searchComponent.getComponent("Search Games"));

        VBox gamesInCollectionVbox = new VBox();

        gamesInCollectionVbox.getChildren().addAll(gamesHbox);

        layout.getChildren().addAll(searchComponentVbox, gamesInCollectionVbox);

        return layout;
    }

    public void setContent(Collection<HBox> gamesHbox){
        this.gamesHbox = gamesHbox;
    }
}
