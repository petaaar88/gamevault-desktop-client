package org.example.desktopclient.component;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class GameInLibraryActionButtonComponent {
    private Button actionButton;
    private ProgressBar progressBar;
    private VBox layout;

    public GameInLibraryActionButtonComponent() {
        layout = new VBox();
        layout.setSpacing(7);
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/progressBarStyless.css").toExternalForm());
        actionButton = new Button();
        progressBar = new ProgressBar();
        progressBar.setPrefWidth(200);
        progressBar.setMinHeight(14);
        progressBar.setMaxHeight(14);
        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);
        progressBar.setStyle("-fx-accent: #0084FF; -fx-background-color: transparent; -fx-border-width: 0px;");

        actionButton.getStyleClass().add("large-action-button");
        layout.getChildren().add(actionButton);

    }

    public VBox getComponent() {
        return layout;
    }

    public Button getActionButton() {
        return actionButton;
    }

    public void setActionButton(Button actionButton) {
        this.actionButton = actionButton;
    }

    public VBox getLayout() {
        return layout;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }
}
