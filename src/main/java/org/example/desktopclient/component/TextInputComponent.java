package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TextInputComponent {

    private VBox layout;
    private Label titleLabel;
    private TextArea textArea;
    private Button submitButton;
    private HBox ratingAndButtonHbox;
    private RatingComponent ratingComponent;

    public TextInputComponent(){
        layout = new VBox();
        layout.setStyle("-fx-background-color: #333352;");
        layout.setPadding(new Insets(19));
        layout.setMaxHeight(Region.USE_PREF_SIZE);
        layout.setSpacing(10);
        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        titleLabel = new Label("");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px");


        textArea = new TextArea();
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


        ratingComponent = new RatingComponent();

        submitButton = new Button("Submit");
        submitButton.getStyleClass().add("normal-action-button");

        ratingAndButtonHbox = new HBox(submitButton);
        ratingAndButtonHbox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(ratingComponent.getComponent(), Priority.ALWAYS);

        layout.getChildren().addAll(titleLabel, textArea, ratingAndButtonHbox);
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

    public Label getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(Label titleLabel) {
        this.titleLabel = titleLabel;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public HBox getRatingAndButtonHbox() {
        return ratingAndButtonHbox;
    }

    public void setRatingAndButtonHbox(HBox ratingAndButtonHbox) {
        this.ratingAndButtonHbox = ratingAndButtonHbox;
    }

    public RatingComponent getRatingComponent() {
        return ratingComponent;
    }

    public void setRatingComponent(RatingComponent ratingComponent) {
        this.ratingComponent = ratingComponent;
    }
}
