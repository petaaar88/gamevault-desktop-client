package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        layout.setMinWidth(240);
        layout.setMaxWidth(240);
        layout.setStyle("-fx-background-color: #333352");

        SearchComponent searchComponent = new SearchComponent();
        VBox searchComponentVbox = new VBox(searchComponent.getComponent("Search Games"));

        searchComponentVbox.setAlignment(Pos.CENTER);
        searchComponentVbox.setPadding(new Insets(0,0,0,12));

        VBox gamesInCollectionVbox = new VBox();

        gamesInCollectionVbox.getChildren().addAll(gamesHbox);
        ScrollComponent scrollComponent = new ScrollComponent();

        layout.getChildren().addAll(searchComponentVbox,scrollComponent.getComponent(gamesInCollectionVbox));
        scrollComponent.setPaddingInline(0);
        scrollComponent.setBackgroundColor("transparent");
        return layout;
    }

    public void setContent(Collection<HBox> gamesHbox){
        this.gamesHbox = gamesHbox;
    }
}
