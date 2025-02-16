package org.example.desktopclient.component;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FriendRequestsComponent {

    private VBox layout;
    private GridPane sentRequestsGridPane;
    private GridPane receivedRequestsGridPane;

    public FriendRequestsComponent() {
        layout = new VBox();

        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        Text title = new Text();
        title.setText("Friend Requests");
        title.setStyle("-fx-fill: white; -fx-font-size: 25px; -fx-font-weight: bold;");
        layout.getChildren().add(title);


        Text sendRequestText = new Text();
        sendRequestText.setText("Sent Requests");
        sendRequestText.setStyle("-fx-fill: white; -fx-font-size: 18px; -fx-font-weight: 700;");

        sentRequestsGridPane = new GridPane();
        sentRequestsGridPane.setHgap(8);
        sentRequestsGridPane.setVgap(8);

        Text receiveRequestText = new Text();
        receiveRequestText.setText("Received Request");
        receiveRequestText.setStyle("-fx-fill: white; -fx-font-size: 18px; -fx-font-weight: 700;");
        receivedRequestsGridPane = new GridPane();
        receivedRequestsGridPane.setHgap(8);
        receivedRequestsGridPane.setVgap(8);

        layout.getChildren().add(sendRequestText);
        layout.getChildren().add(sentRequestsGridPane);
        layout.getChildren().add(receiveRequestText);
        layout.getChildren().add(receivedRequestsGridPane);

        layout.setSpacing(10);
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

    public GridPane getSentRequestsGridPane() {
        return sentRequestsGridPane;
    }

    public void setSentRequestsGridPane(GridPane sentRequestsGridPane) {
        this.sentRequestsGridPane = sentRequestsGridPane;
    }

    public GridPane getReceivedRequestsGridPane() {
        return receivedRequestsGridPane;
    }

    public void setReceivedRequestsGridPane(GridPane receivedRequestsGridPane) {
        this.receivedRequestsGridPane = receivedRequestsGridPane;
    }
}
