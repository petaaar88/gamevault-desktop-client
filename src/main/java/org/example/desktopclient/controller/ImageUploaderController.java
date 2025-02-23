package org.example.desktopclient.controller;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.desktopclient.component.ImageUploaderComponent;

import java.io.File;
import java.util.Objects;

public class ImageUploaderController {
    private ImageUploaderComponent component;
    private File selectedImageFile;
    private Stage stage;

    public ImageUploaderController(ImageUploaderComponent component) {
        this.component = component;
        selectedImageFile = null;
    }

    public void handleUploadClick(){
        component.getUploadButton().setOnMouseClicked(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Add New Profile Image");

            // Postavljanje početnog direktorijuma (možeš promeniti na željeni folder)
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));

            // Dodavanje filtera za slike (možeš promeniti na druge ekstenzije)
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png")
            );

            // Otvaranje dijaloga za odabir fajla
            selectedImageFile = fileChooser.showOpenDialog(stage);

            if (!Objects.isNull(selectedImageFile)) {
                System.out.println("Selected file: " + selectedImageFile.getAbsolutePath());

                // Ako želiš da prikažeš sliku u ImageView
                Image image = new Image(selectedImageFile.toURI().toString());
                component.getNewImageView().setImage(image);

                component.getComponent().getChildren().clear();
                component.getComponent().getChildren().add(component.getNewImageView());
                component.getComponent().getChildren().add(component.getRemoveButton());
                component.getComponent().setSpacing(8);
                component.getComponent().setAlignment(Pos.CENTER);

            } else {
                System.out.println("No file selected");
            }


        });
        component.getRemoveButton().setOnMouseClicked(e->{
           selectedImageFile = null;
           component.getNewImageView().setImage(null);
           component.getComponent().getChildren().clear();
           component.getComponent().getChildren().add(component.getUploadButton());
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ImageUploaderComponent getComponent() {
        return component;
    }

    public void setComponent(ImageUploaderComponent component) {
        this.component = component;
    }

    public File getSelectedImageFile() {
        return selectedImageFile;
    }

    public void setSelectedImageFile(File selectedImageFile) {
        this.selectedImageFile = selectedImageFile;
    }

    public Stage getStage() {
        return stage;
    }
}
