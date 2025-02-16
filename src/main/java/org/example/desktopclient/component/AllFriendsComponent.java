package org.example.desktopclient.component;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AllFriendsComponent {

    private VBox layout;
    private GridPane onlineFriendsGridPane;
    private GridPane offlineFriendsGridPane;

    public AllFriendsComponent() {
        layout = new VBox();

        Text title = new Text();
        title.setText("Friends");
        title.setStyle("-fx-fill: white; -fx-font-size: 25px; -fx-font-weight: bold;");
        layout.getChildren().add(title);


        Text onlineText = new Text();
        onlineText.setText("Online");
        onlineText.setStyle("-fx-fill: white; -fx-font-size: 18px; -fx-font-weight: 700;");

        onlineFriendsGridPane = new GridPane();
        onlineFriendsGridPane.setHgap(8);
        onlineFriendsGridPane.setVgap(8);

        layout.getChildren().add(onlineText);
        layout.getChildren().add(onlineFriendsGridPane);


        Text offlineText = new Text();
        offlineText.setText("Offline");
        offlineText.setStyle("-fx-fill: white; -fx-font-size: 18px; -fx-font-weight: 700;");
        offlineFriendsGridPane = new GridPane();
        offlineFriendsGridPane.setHgap(8);
        offlineFriendsGridPane.setVgap(8);

        layout.getChildren().add(offlineText);
        layout.getChildren().add(offlineFriendsGridPane);

        layout.setSpacing(10);

    }

    public VBox getComponent() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public GridPane getOnlineFriendsGridPane() {
        return onlineFriendsGridPane;
    }

    public void setOnlineFriendsGridPane(GridPane onlineFriendsGridPane) {
        this.onlineFriendsGridPane = onlineFriendsGridPane;
    }

    public GridPane getOfflineFriendsGridPane() {
        return offlineFriendsGridPane;
    }

    public void setOfflineFriendsGridPane(GridPane offlineFriendsGridPane) {
        this.offlineFriendsGridPane = offlineFriendsGridPane;
    }
}
