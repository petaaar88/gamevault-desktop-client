package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.util.*;

public class UsersGamesCollectionComponent {

    private VBox layout;
    private SearchComponent searchComponent;
    private VBox gamesInCollectionVbox;

    public UsersGamesCollectionComponent() {

        layout = new VBox();
        layout.setMinWidth(240);
        layout.setMaxWidth(240);
        layout.setStyle("-fx-background-color: #333352");

        searchComponent = new SearchComponent();
        gamesInCollectionVbox = new VBox();

        VBox searchComponentVbox = new VBox(searchComponent.getComponent("Search Games"));

        searchComponentVbox.setAlignment(Pos.CENTER);
        searchComponentVbox.setPadding(new Insets(32, 0, 0, 12));


        ScrollComponent scrollComponent = new ScrollComponent();

        layout.getChildren().addAll(searchComponentVbox, scrollComponent.getComponent(gamesInCollectionVbox));
        scrollComponent.setPaddingInline(0);
        scrollComponent.setBackgroundColor("transparent");
    }

    public VBox getComponent() {
        return layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public void setSearchComponent(SearchComponent searchComponent) {
        this.searchComponent = searchComponent;
    }

    public VBox getGamesInCollectionVbox() {
        return gamesInCollectionVbox;
    }

    public void setGamesInCollectionVbox(VBox gamesInCollectionVbox) {
        this.gamesInCollectionVbox = gamesInCollectionVbox;
    }
}
