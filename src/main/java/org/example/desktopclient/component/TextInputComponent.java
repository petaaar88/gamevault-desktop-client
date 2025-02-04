package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TextInputComponent {

    public VBox getWithRatingComponent() {
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #333352;");
        layout.setPadding(new Insets(19));
        layout.setMaxHeight(Region.USE_PREF_SIZE);
        layout.setSpacing(10);
        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        Label titleLabel = new Label("Write A Review for Red Dead Redemption");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px");


        TextArea textArea = new TextArea();
        textArea.setMaxHeight(190);
        textArea.setMinHeight(190);
        textArea.setWrapText(true);
        textArea.setTextFormatter(new TextFormatter<>(change -> {
            return change.getControlNewText().length() <= 600 ? change : null;
        }));
        textArea.setPadding(new Insets(6));
        textArea.setStyle("-fx-font-size: 15px;-fx-background-color:#0E0F1A;-fx-control-inner-background:#0E0F1A;-fx-text-fill: #939CFF;\n" +
                "    -fx-fill: #575C96;-fx-prompt-text-fill: #575C96;");
        textArea.setPromptText("Enter review...");


        RatingComponent ratingComponent = new RatingComponent();

        Button submitButton = new Button("Submit");
        submitButton.getStyleClass().add("normal-action-button");

        HBox hBox = new HBox(ratingComponent.getComponent(), submitButton);
        hBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(ratingComponent.getComponent(), Priority.ALWAYS);

        layout.getChildren().addAll(titleLabel, textArea, hBox);

        return layout;
    }


}
