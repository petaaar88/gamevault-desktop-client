package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AddFriendComponent {

    private VBox layout;
    private GridPane foundUsers;
    private SearchComponent searchComponent;

    public AddFriendComponent() {
        layout = new VBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        Text title = new Text();
        title.setText("Add Friend");
        title.setStyle("-fx-fill: white; -fx-font-size: 25px; -fx-font-weight: bold;");

        searchComponent = new SearchComponent();
        HBox searchComponentHBox = searchComponent.getComponent("Search Users");
        searchComponentHBox.setPadding(new Insets(10, 0, 10, 0));

        foundUsers = new GridPane();
        foundUsers.setVgap(7);
        foundUsers.setHgap(7);


        layout.getChildren().addAll(title, searchComponentHBox, foundUsers);
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

    public GridPane getFoundUsers() {
        return foundUsers;
    }

    public void setFoundUsers(GridPane foundUsers) {
        this.foundUsers = foundUsers;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public void setSearchComponent(SearchComponent searchComponent) {
        this.searchComponent = searchComponent;
    }
}
