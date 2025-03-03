package org.example.desktopclient.component;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GameInLibraryActionButtonComponent {
    private Button actionButton;
    private VBox layout;

    public GameInLibraryActionButtonComponent() {
        layout = new VBox();
        actionButton = new Button();

        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

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
}
