package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class RecentActivityComponent {
    private VBox layout;
    private VBox games;
    private Button showAllGamesButton;

    public RecentActivityComponent(){
        this.layout = new VBox();
        layout.setStyle("-fx-background-color: #333352");
        layout.setPadding(new Insets(20));


        Text titleText = new Text("Recent Activity");
        titleText.setStyle("-fx-fill: white; -fx-font-size: 25px; -fx-font-weight: bold;");

        layout.getChildren().add(titleText);
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm());
        games = new VBox();
        games.setPadding(new Insets(10,0,0,0));
        games.setSpacing(7);
        showAllGamesButton = new Button("Show All Games");
        showAllGamesButton.getStyleClass().add("small-action-button");

        games.setAlignment(Pos.CENTER);


        layout.getChildren().add(games);
    }

    public VBox getComponent(){
        return layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public VBox getGames() {
        return games;
    }

    public void setGames(VBox games) {
        this.games = games;
    }

    public Button getShowAllGamesButton() {
        return showAllGamesButton;
    }

    public void setShowAllGamesButton(Button showAllGamesButton) {
        this.showAllGamesButton = showAllGamesButton;
    }
}
