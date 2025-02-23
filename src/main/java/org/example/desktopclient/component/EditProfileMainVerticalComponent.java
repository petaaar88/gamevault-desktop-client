package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collection;

public class EditProfileMainVerticalComponent extends VerticalMainComponent {

    private ImageView currentImageView;
    private Button saveChangesButton;
    private TextField usernameTextField;
    private TextArea descriptionTextArea;
    private ImageUploaderComponent imageUploaderComponent;

    public EditProfileMainVerticalComponent() {
        this.setup();

        VBox layout2 = new VBox();
        layout2.setPadding(new Insets(24));
        layout2.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm());
        layout2.setMaxWidth(1000);
        layout2.setMinWidth(1000);
        layout2.setSpacing(21);
        layout2.setStyle("-fx-background-color: #333352");

        Text titleText = new Text("Edit Profile");
        titleText.setStyle("-fx-fill: white; -fx-font-size: 28px; -fx-font-weight: bold;");


        currentImageView = new ImageView(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKC1J56nwUx_ffTCBXca_f3oUJbml5PUosvQ&s"));
        currentImageView.setFitWidth(200);
        currentImageView.setFitHeight(200);

        Label currentImageLabel = new Label("Current Image");
        currentImageLabel.setStyle("-fx-background-color: #333352; -fx-text-fill: white;-fx-font-size: 15px;");
        VBox currentImageBox = new VBox(currentImageLabel, currentImageView);
        currentImageBox.setSpacing(4);

        imageUploaderComponent = new ImageUploaderComponent();

        Label imageUploaderLabel = new Label("New Image");
        imageUploaderLabel.setStyle("-fx-background-color: #333352; -fx-text-fill: white;-fx-font-size: 15px;");
        VBox imageUploaderBox = new VBox(imageUploaderLabel, imageUploaderComponent.getLayout());
        imageUploaderBox.setSpacing(4);

        HBox imageBox = new HBox(currentImageBox,imageUploaderBox);
        imageBox.setSpacing(45);


        saveChangesButton = new Button("Save Changes");
        saveChangesButton.getStyleClass().add("normal-action-button");

        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-background-color: #333352; -fx-text-fill: white;-fx-font-size: 15px;");
        usernameTextField = new TextField();
        usernameTextField.setMinWidth(300);
        usernameTextField.setMaxWidth(300);
        usernameTextField.setPromptText("Enter new username");
        usernameTextField.setStyle(" -fx-background-color: #0E0F1A;\n" +
                "    -fx-text-fill: #939CFF;\n" +
                "    -fx-fill: #575C96;\n" +
                "    -fx-border-radius: 10px;\n" +
                "    -fx-font-size:14px;\n" +
                "    -fx-background-radius: 10px;\n" +
                "    -fx-padding: 5px 40px 5px 15px;\n" +
                "    -fx-border-color: #575C96;\n" +
                "    -fx-prompt-text-fill: #575C96;\n" +
                "    -fx-font-weight: 600;");
        VBox usernameBox = new VBox(usernameLabel, usernameTextField);
        usernameBox.setSpacing(4);


        Label descriptionLabel = new Label("Description");
        descriptionLabel.setStyle("-fx-background-color: #333352; -fx-text-fill: white;-fx-font-size: 15px;");
        descriptionTextArea = new TextArea();
        descriptionTextArea.setMinHeight(200);
        descriptionTextArea.setMaxHeight(200);
        descriptionTextArea.setStyle(
                "-fx-background-color: #0E0F1A; " +
                        "-fx-control-inner-background: #0E0F1A; " +
                        "-fx-text-fill: #939CFF;\n" +
        "    -fx-fill: #575C96;\n" +
                "    -fx-border-radius: 10px;\n" +
                "    -fx-font-size:14px;\n" +
                "    -fx-background-radius: 10px;\n" +
                "    -fx-padding: 5px 40px 5px 15px;\n" +
                "    -fx-border-color: #575C96;\n" +
                "    -fx-prompt-text-fill: #575C96;\n" +
                "    -fx-font-weight: 600"
        );
        descriptionTextArea.setPromptText("Enter new description");

        VBox descriptionBox = new VBox(descriptionLabel, descriptionTextArea);
        descriptionBox.setSpacing(4);


        layout2.getChildren().addAll(titleText,imageBox,usernameBox, descriptionBox, saveChangesButton);

        Collection<Node> elements = Arrays.asList(layout2);
        this.addElements(elements);
    }


    @Override
    public VBox getComponent() {
        return layout;
    }

    public ImageUploaderComponent getImageUploaderComponent() {
        return imageUploaderComponent;
    }

    public void setImageUploaderComponent(ImageUploaderComponent imageUploaderComponent) {
        this.imageUploaderComponent = imageUploaderComponent;
    }

    public ImageView getCurrentImageView() {
        return currentImageView;
    }

    public void setCurrentImageView(ImageView currentImageView) {
        this.currentImageView = currentImageView;
    }

    public Button getSaveChangesButton() {
        return saveChangesButton;
    }

    public void setSaveChangesButton(Button saveChangesButton) {
        this.saveChangesButton = saveChangesButton;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(TextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public TextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(TextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }
}
