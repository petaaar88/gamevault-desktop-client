package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.desktopclient.component.ImagesSliderComponent;
import org.example.desktopclient.service.game.GameService;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderController {

    private final Integer MAX_IMAGES_IN_SLIDER = 4;
    private final Integer MIN_IMAGES_IN_SLIDER = 0;
    private Integer maxNumberOfImagesInSlider;
    private int[] currentImageIndex = new int[1]; // početna vrednost
    private int[] previousImageIndex = new int[1]; // koristiš niz da bi bila efektivno finalna

    private int[] minIndexInSlider = new int[1]; // početna vrednost
    private int[] maxIndexInSlider = new int[1]; // koristiš niz da bi bila efektivno finalna

    private int[] currentImageIndexInSlider = new int[1]; // početna vrednost
    private int[] previousImageIndexInSlider = new int[1];

    private ImagesSliderComponent component;
    private List<Image> images;


    public ImageSliderController(ImagesSliderComponent component) {

        maxNumberOfImagesInSlider = 1;

        currentImageIndex[0] = 0; // početna vrednost
        previousImageIndex[0] = currentImageIndex[0]; // koristiš niz da bi bila efektivno finalna

        minIndexInSlider[0] = MIN_IMAGES_IN_SLIDER; // početna vrednost
        maxIndexInSlider[0] = maxNumberOfImagesInSlider - 1; // koristiš niz da bi bila efektivno finalna

        currentImageIndexInSlider[0] = 0; // početna vrednost
        previousImageIndexInSlider[0] = currentImageIndexInSlider[0];


        this.component = component;
        images = component.getImages();

    }



    public void setImages(Integer gameId) {
        GameService gameService = new GameService();

        //while (!images.isEmpty())
        //   images.removeFirst();

        gameService.fetchGameProductPageImages(gameId, gameProductPageImages -> {
            Platform.runLater(()->{

            gameProductPageImages.getImages().forEach(image -> {
                component.getImages().add(new Image(image.getImage()));
            });
            images = component.getImages();
            this.setContent();
            this.handleClicks();
            });
        });
    }

    public void setContent() {

        component.getImagesInSliderHbox().getChildren().clear();
        component.getCurrentImageView().setImage(images.get(0));
        component.getAllImagesForSlider().removeAll(component.getAllImagesForSlider());

        maxNumberOfImagesInSlider = (MAX_IMAGES_IN_SLIDER > images.size()) ? images.size() : MAX_IMAGES_IN_SLIDER;

        currentImageIndex[0] = 0; // početna vrednost
        previousImageIndex[0] = currentImageIndex[0]; // koristiš niz da bi bila efektivno finalna

        minIndexInSlider[0] = MIN_IMAGES_IN_SLIDER; // početna vrednost
        maxIndexInSlider[0] = maxNumberOfImagesInSlider - 1; // koristiš niz da bi bila efektivno finalna

        currentImageIndexInSlider[0] = 0; // početna vrednost
        previousImageIndexInSlider[0] = currentImageIndexInSlider[0]; // koristiš niz da bi bila efektivno finalna


        ////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < images.size(); i++) {
            ImageView imageView = new ImageView(images.get(i));
            imageView.setFitWidth(122);
            imageView.setFitHeight(68);
            Button button = new Button("", imageView);


            button.getStyleClass().add("image-in-slider");

            component.getAllImagesForSlider().add(button);

        }

        for (int i = 0; i < maxNumberOfImagesInSlider; i++) {

            ImageView imageView = new ImageView(images.get(i));
            imageView.setFitWidth(122);
            imageView.setFitHeight(68);
            Button button = new Button("", imageView);

            if (i == 0) {
                button.getStyleClass().removeLast();
                button.getStyleClass().add("current-image");
            } else
                button.getStyleClass().add("image-in-slider");

            component.getImagesInSliderHbox().getChildren().add(button);
        }


    }

    public void handleClicks() {
        component.getLeftArrow().setOnMouseClicked(e -> {


            if (images.size() != 1) {

                previousImageIndex[0] = currentImageIndex[0];
                previousImageIndexInSlider[0] = currentImageIndexInSlider[0];

                currentImageIndexInSlider[0]--;

                if (currentImageIndex[0] == 0) {
                    currentImageIndex[0] = images.size() - 1;
                    minIndexInSlider[0] = images.size() - maxNumberOfImagesInSlider;
                    maxIndexInSlider[0] = images.size() - 1;
                    currentImageIndexInSlider[0] = maxNumberOfImagesInSlider - 1;
                    previousImageIndexInSlider[0] = 0;

                    component.getImagesInSliderHbox().getChildren().getFirst().getStyleClass().removeLast();
                    component.getImagesInSliderHbox().getChildren().getFirst().getStyleClass().add("image-in-slider");

                    while (!component.getImagesInSliderHbox().getChildren().isEmpty())
                        component.getImagesInSliderHbox().getChildren().removeLast();

                    for (int i = minIndexInSlider[0]; i <= maxIndexInSlider[0]; i++) {
                        Button button = component.getAllImagesForSlider().get(i);

                        if (i == currentImageIndex[0]) {
                            button.getStyleClass().removeLast();
                            button.getStyleClass().add("current-image");
                        }

                        component.getImagesInSliderHbox().getChildren().add(button);
                    }

                } else {
                    currentImageIndex[0]--;
                }

                if (currentImageIndex[0] < minIndexInSlider[0]) {
                    component.getImagesInSliderHbox().getChildren().removeLast();
                    component.getImagesInSliderHbox().getChildren().add(0, component.getAllImagesForSlider().get(currentImageIndex[0]));
                    minIndexInSlider[0]--;
                    maxIndexInSlider[0]--;
                    currentImageIndexInSlider[0] = 0;
                    previousImageIndexInSlider[0] = 1;
                }

                component.getCurrentImageView().setImage(images.get(currentImageIndex[0]));

                component.getImagesInSliderHbox().getChildren().get(previousImageIndexInSlider[0]).getStyleClass().removeLast();
                component.getImagesInSliderHbox().getChildren().get(previousImageIndexInSlider[0]).getStyleClass().add("image-in-slider");

                component.getImagesInSliderHbox().getChildren().get(currentImageIndexInSlider[0]).getStyleClass().removeLast();
                component.getImagesInSliderHbox().getChildren().get(currentImageIndexInSlider[0]).getStyleClass().add("current-image");
            }


        });

        component.getRightArrow().setOnMouseClicked(e -> {

            if (images.size() != 1) {

                previousImageIndex[0] = currentImageIndex[0]; // sada koristiš element niza
                previousImageIndexInSlider[0] = currentImageIndexInSlider[0];


                currentImageIndexInSlider[0]++;


                if (currentImageIndex[0] == (images.size() - 1)) {
                    currentImageIndex[0] = 0;
                    minIndexInSlider[0] = 0;
                    maxIndexInSlider[0] = maxNumberOfImagesInSlider - 1;
                    currentImageIndexInSlider[0] = 0;
                    previousImageIndexInSlider[0] = maxNumberOfImagesInSlider - 1;

                    component.getImagesInSliderHbox().getChildren().getLast().getStyleClass().removeLast();
                    component.getImagesInSliderHbox().getChildren().getLast().getStyleClass().add("image-in-slider");

                    while (!component.getImagesInSliderHbox().getChildren().isEmpty())
                        component.getImagesInSliderHbox().getChildren().removeLast();


                    for (int i = 0; i < maxNumberOfImagesInSlider; i++) {

                        Button button = component.getAllImagesForSlider().get(i);

                        if (i == 0) {
                            button.getStyleClass().removeLast();
                            button.getStyleClass().add("current-image");
                        }

                        component.getImagesInSliderHbox().getChildren().add(button);
                    }

                } else {
                    currentImageIndex[0]++;

                }

                if (currentImageIndex[0] > maxIndexInSlider[0]) {
                    component.getImagesInSliderHbox().getChildren().removeFirst();
                    component.getImagesInSliderHbox().getChildren().add(component.getAllImagesForSlider().get(currentImageIndex[0]));
                    maxIndexInSlider[0]++;
                    minIndexInSlider[0]++;
                    currentImageIndexInSlider[0] = maxNumberOfImagesInSlider - 1;
                    previousImageIndexInSlider[0] = currentImageIndexInSlider[0] - 1;

                }

                component.getCurrentImageView().setImage(images.get(currentImageIndex[0]));

                component.getImagesInSliderHbox().getChildren().get(previousImageIndexInSlider[0]).getStyleClass().removeLast();
                component.getImagesInSliderHbox().getChildren().get(previousImageIndexInSlider[0]).getStyleClass().add("image-in-slider");

                component.getImagesInSliderHbox().getChildren().get(currentImageIndexInSlider[0]).getStyleClass().removeLast();

                component.getImagesInSliderHbox().getChildren().get(currentImageIndexInSlider[0]).getStyleClass().add("current-image");


            }

        });
    }

    public ImagesSliderComponent getComponent() {
        return component;
    }

    public void setComponent(ImagesSliderComponent component) {
        this.component = component;
    }
}
