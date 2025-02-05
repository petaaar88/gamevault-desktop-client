package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AddFriendComponent {

    public VBox getComponent() {
        VBox layout = new VBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        Text title = new Text();
        title.setText("Add Friend");
        title.setStyle("-fx-fill: white; -fx-font-size: 25px; -fx-font-weight: bold;");

        SearchComponent searchComponent = new SearchComponent();
        HBox searchComponentHBox = searchComponent.getComponent("Search Users");
        searchComponentHBox.setPadding(new Insets(10, 0, 10, 0));

        VBox usersVbox = new VBox();

        usersVbox.getChildren().addAll(new FoundUserComponent().getComponent(),new FoundUserComponent().getComponent(),new FoundUserComponent().getComponent());
        usersVbox.setSpacing(8);

        layout.getChildren().addAll(title, searchComponentHBox, usersVbox);

        return layout;
    }
}
