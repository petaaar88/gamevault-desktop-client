package org.example.desktopclient;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class UploadingOfImage extends Application {
    private String serverUrl = "http://localhost:8080/upload";

    private File selectedImageFile = null;

    @Override
    public void start(Stage stage) throws Exception {
        Button chooseImageButton = new Button("Choose Image");
        Button uploadButton = new Button("Upload Image");
        Button removeButton = new Button("Remove Image");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);


        chooseImageButton.setOnMouseClicked(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose New Profile Image");

            // Postavljanje početnog direktorijuma (možeš promeniti na željeni folder)
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));

            // Dodavanje filtera za slike (možeš promeniti na druge ekstenzije)
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png")
            );

            // Otvaranje dijaloga za odabir fajla
            selectedImageFile = fileChooser.showOpenDialog(stage);

            if (selectedImageFile != null) {
                System.out.println("Selected file: " + selectedImageFile.getAbsolutePath());

                // Ako želiš da prikažeš sliku u ImageView
                Image image = new Image(selectedImageFile.toURI().toString());
                imageView.setImage(image);



            } else {
                System.out.println("No file selected");
            }


        });

        uploadButton.setOnMouseClicked(e -> {
            if(selectedImageFile != null) {
                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                    HttpPost uploadFile = new HttpPost(serverUrl);
                    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                    builder.setMode(HttpMultipartMode.STRICT);
                    builder.addPart("profileImage", new FileBody(selectedImageFile));
                    builder.addPart("username", new StringBody("username",  ContentType.create("text/plain", StandardCharsets.UTF_8)));
                    builder.addPart("description", new StringBody("Ovo je nova deskripcija",  ContentType.create("text/plain", StandardCharsets.UTF_8)));
                    uploadFile.setEntity(builder.build());

                    try (CloseableHttpResponse response = httpClient.execute(uploadFile)) {
                        System.out.println("Response: " + response.getCode());
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        removeButton.setOnMouseClicked(e -> {
            imageView.setImage(null);
            selectedImageFile = null;
        });

        VBox root = new VBox(chooseImageButton, imageView, uploadButton,removeButton);


        Scene scene = new Scene(root, 300, 300);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
