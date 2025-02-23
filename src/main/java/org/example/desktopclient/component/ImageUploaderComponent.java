package org.example.desktopclient.component;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ImageUploaderComponent {
    private Button uploadButton;
    private Button removeButton;
    private VBox layout;
    private ImageView newImageView;
    private VBox uploadVbox;

    public ImageUploaderComponent() {
        layout = new VBox();
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/imageUploaderStyles.css").toExternalForm());
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm());

        newImageView = new ImageView();
        newImageView.setFitHeight(200);
        newImageView.setFitWidth(200);

        ImageView plusImageView = new ImageView(new Image(getClass().getResource("/org/example/desktopclient/icons/plusIcon.png").toExternalForm()));
        plusImageView.setFitHeight(50);
        plusImageView.setFitWidth(50);

        Text addImageText = new Text();
        addImageText.setText("Add Image");
        addImageText.setStyle("-fx-fill: #575C96; -fx-font-size: 21px; -fx-font-weight: 700;");

        uploadVbox = new VBox(plusImageView,addImageText);
        uploadVbox.setAlignment(Pos.CENTER);
        uploadVbox.setSpacing(5);

        uploadButton = new Button("",uploadVbox);
        uploadButton.getStyleClass().add("upload-button");
        uploadButton.setPrefSize(200, 200);

        removeButton = new Button("Remove Image");
        removeButton.getStyleClass().add("small-red-action-button");

        layout.getChildren().add(uploadButton);
    }

    public VBox getComponent() {
        return layout;
    }

    public Button getUploadButton() {
        return uploadButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public void setUploadButton(Button uploadButton) {
        this.uploadButton = uploadButton;
    }

    public ImageView getNewImageView() {
        return newImageView;
    }

    public void setNewImageView(ImageView newImageView) {
        this.newImageView = newImageView;
    }

    public void setRemoveButton(Button removeButton) {
        this.removeButton = removeButton;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public VBox getUploadVbox() {
        return uploadVbox;
    }

    public void setUploadVbox(VBox uploadVbox) {
        this.uploadVbox = uploadVbox;
    }
}
