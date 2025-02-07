package org.example.desktopclient.component;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FriendRequestsComponent {

    public VBox getComponent() {
        VBox layout = new VBox();

        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        Text title = new Text();
        title.setText("Friend Requests");
        title.setStyle("-fx-fill: white; -fx-font-size: 25px; -fx-font-weight: bold;");

        

        return layout;
    }
}
