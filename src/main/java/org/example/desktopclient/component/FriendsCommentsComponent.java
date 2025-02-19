package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FriendsCommentsComponent {
    private VBox layout;
    private VBox commentsVbox;
    private PaginationComponent paginationComponent;

    public FriendsCommentsComponent() {
        layout = new VBox();
        layout.setStyle("-fx-background-color: #333352");
        layout.setPadding(new Insets(20));

        Text text = new Text("Comments");
        text.setStyle("-fx-fill: white; -fx-font-size: 25; -fx-font-weight: 700;");
        layout.getChildren().add(text);

        commentsVbox = new VBox();
        commentsVbox.setPadding(new Insets(12,0,0,0));
        commentsVbox.setSpacing(6);
        layout.getChildren().add(commentsVbox);

        paginationComponent = new PaginationComponent();
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

    public VBox getCommentsVbox() {
        return commentsVbox;
    }

    public void setCommentsVbox(VBox commentsVbox) {
        this.commentsVbox = commentsVbox;
    }

    public PaginationComponent getPaginationComponent() {
        return paginationComponent;
    }

    public void setPaginationComponent(PaginationComponent paginationComponent) {
        this.paginationComponent = paginationComponent;
    }

}
