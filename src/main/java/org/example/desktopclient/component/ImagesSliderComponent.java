package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImagesSliderComponent {

    //TODO: izbrisi ovo
    private final Integer MAX_IMAGES_IN_SLIDER = 4;
    private final Integer MIN_IMAGES_IN_SLIDER = 0;

    private VBox layout;
    private ImageView currentImageView;
    private Button leftArrow;
    private Button rightArrow;
    private HBox imagesInSliderHbox;
    private List<Button> allImagesForSlider;
    private List<Image> images;

    public ImagesSliderComponent() {

        images =new ArrayList<>();

        layout = new VBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/imageSliderComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        allImagesForSlider = new ArrayList<>();


        currentImageView = new ImageView();
        currentImageView.setFitHeight(354);
        currentImageView.setFitWidth(630);

        HBox sliderHbox = new HBox();
        sliderHbox.setPadding(new Insets(20, 0, 0, 0));
        sliderHbox.setSpacing(13);

        leftArrow = new Button("<");
        leftArrow.getStyleClass().add("image-slider-button");
        rightArrow = new Button(">");
        rightArrow.getStyleClass().add("image-slider-button");

        imagesInSliderHbox = new HBox();
        imagesInSliderHbox.setSpacing(10);
        imagesInSliderHbox.setStyle("-fx-background-color: #0E0F1A");


        sliderHbox.getChildren().addAll(leftArrow, imagesInSliderHbox, rightArrow);
        sliderHbox.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(currentImageView, sliderHbox);
    }

    public VBox getComponent() {
        return layout;
    }


    public Integer getMAX_IMAGES_IN_SLIDER() {
        return MAX_IMAGES_IN_SLIDER;
    }

    public Integer getMIN_IMAGES_IN_SLIDER() {
        return MIN_IMAGES_IN_SLIDER;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public ImageView getCurrentImageView() {
        return currentImageView;
    }

    public void setCurrentImageView(ImageView currentImageView) {
        this.currentImageView = currentImageView;
    }

    public Button getLeftArrow() {
        return leftArrow;
    }

    public void setLeftArrow(Button leftArrow) {
        this.leftArrow = leftArrow;
    }

    public Button getRightArrow() {
        return rightArrow;
    }

    public void setRightArrow(Button rightArrow) {
        this.rightArrow = rightArrow;
    }

    public HBox getImagesInSliderHbox() {
        return imagesInSliderHbox;
    }

    public void setImagesInSliderHbox(HBox imagesInSliderHbox) {
        this.imagesInSliderHbox = imagesInSliderHbox;
    }

    public List<Button> getAllImagesForSlider() {
        return allImagesForSlider;
    }

    public void setAllImagesForSlider(List<Button> allImagesForSlider) {
        this.allImagesForSlider = allImagesForSlider;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
