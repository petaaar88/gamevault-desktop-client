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

        images = Arrays.asList(
                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2933620/ss_bf4e9aa33ea2cf6846e26ffdec5f1cdecbc39e61.600x338.jpg?t=1738088305"),
                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_66b553f4c209476d3e4ce25fa4714002cc914c4f.600x338.jpg?t=1720558643"),
                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_bac60bacbf5da8945103648c08d27d5e202444ca.600x338.jpg?t=1720558643"),
                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_668dafe477743f8b50b818d5bbfcec669e9ba93e.600x338.jpg?t=1720558643"),
                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_d1a8f5a69155c3186c65d1da90491fcfd43663d9.600x338.jpg?t=1720558643"),
                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1295660/ss_8c1226a5c58447773b03b6c967e9d561d3315fd7.600x338.jpg?t=1738279420"));


        layout = new VBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/imageSliderComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        allImagesForSlider = new ArrayList<>();


        currentImageView = new ImageView(images.get(0));
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
//        List<Image> images = Arrays.asList(
//                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2933620/ss_bf4e9aa33ea2cf6846e26ffdec5f1cdecbc39e61.600x338.jpg?t=1738088305"),
//                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_66b553f4c209476d3e4ce25fa4714002cc914c4f.600x338.jpg?t=1720558643"),
//                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_bac60bacbf5da8945103648c08d27d5e202444ca.600x338.jpg?t=1720558643"),
//                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_668dafe477743f8b50b818d5bbfcec669e9ba93e.600x338.jpg?t=1720558643"),
//                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/ss_d1a8f5a69155c3186c65d1da90491fcfd43663d9.600x338.jpg?t=1720558643"),
//                new Image("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1295660/ss_8c1226a5c58447773b03b6c967e9d561d3315fd7.600x338.jpg?t=1738279420"));
////
//        Integer maxNumberOfImagesInSlider = (MAX_IMAGES_IN_SLIDER > images.size())? images.size() : MAX_IMAGES_IN_SLIDER;
//
//        int[] currentImageIndex = {0}; // početna vrednost
//        int[] previousImageIndex = {currentImageIndex[0]}; // koristiš niz da bi bila efektivno finalna
//
//        int[] minIndexInSlider = {MIN_IMAGES_IN_SLIDER}; // početna vrednost
//        int[] maxIndexInSlider = {maxNumberOfImagesInSlider - 1}; // koristiš niz da bi bila efektivno finalna
//
//        int[] currentImageIndexInSlider = {0}; // početna vrednost
//        int[] previousImageIndexInSlider = {currentImageIndexInSlider[0]}; // koristiš niz da bi bila efektivno finalna
//


//        allImagesForSlider = new ArrayList<>();
//
//
//
//        currentImageView = new ImageView(images.get(0));
//        currentImageView.setFitHeight(354);
//        currentImageView.setFitWidth(630);
//
//        HBox sliderHbox = new HBox();
//        sliderHbox.setPadding(new Insets(20, 0, 0, 0));
//        sliderHbox.setSpacing(13);
//
//        leftArrow = new Button("<");
//        leftArrow.getStyleClass().add("image-slider-button");
//        rightArrow = new Button(">");
//        rightArrow.getStyleClass().add("image-slider-button");
//
//        imagesInSliderHbox = new HBox();
//        imagesInSliderHbox.setSpacing(10);
//        imagesInSliderHbox.setStyle("-fx-background-color: #0E0F1A");
//
//
//        for (int i = 0; i < images.size(); i++) {
//            ImageView imageView = new ImageView(images.get(i));
//            imageView.setFitWidth(122);
//            imageView.setFitHeight(68);
//            Button button = new Button("", imageView);
//
//
//            button.getStyleClass().add("image-in-slider");
//
//            allImagesForSlider.add(button);
//
//        }
//
//        for (int i = 0; i < maxNumberOfImagesInSlider; i++) {
//
//            ImageView imageView = new ImageView(images.get(i));
//            imageView.setFitWidth(122);
//            imageView.setFitHeight(68);
//            Button button = new Button("", imageView);
//
//            if (i == 0){
//                button.getStyleClass().removeLast();
//                button.getStyleClass().add("current-image");
//            }
//            else
//                button.getStyleClass().add("image-in-slider");
//
//            imagesInSliderHbox.getChildren().add(button);
//        }
//
//
//        rightArrow.setOnMouseClicked(e -> {
//
//
//            if (images.size() != 1) {
//
//                previousImageIndex[0] = currentImageIndex[0]; // sada koristiš element niza
//                previousImageIndexInSlider[0] = currentImageIndexInSlider[0];
//
//
//                currentImageIndexInSlider[0]++;
//
//
//                if (currentImageIndex[0] == (images.size() - 1)) {
//                    currentImageIndex[0] = 0;
//                    minIndexInSlider[0] = 0;
//                    maxIndexInSlider[0] = maxNumberOfImagesInSlider -1 ;
//                    currentImageIndexInSlider[0] = 0;
//                    previousImageIndexInSlider[0] = maxNumberOfImagesInSlider - 1;
//
//                    imagesInSliderHbox.getChildren().getLast().getStyleClass().removeLast();
//                    imagesInSliderHbox.getChildren().getLast().getStyleClass().add("image-in-slider");
//
//                    while (!imagesInSliderHbox.getChildren().isEmpty())
//                        imagesInSliderHbox.getChildren().removeLast();
//
//
//                    for (int i = 0; i < maxNumberOfImagesInSlider; i++) {
//
//                        Button button = allImagesForSlider.get(i);
//
//                        if (i == 0) {
//                            button.getStyleClass().removeLast();
//                            button.getStyleClass().add("current-image");
//                        }
//
//                        imagesInSliderHbox.getChildren().add(button);
//                    }
//
//                } else {
//                    currentImageIndex[0]++;
//
//                }
//
//                if (currentImageIndex[0] > maxIndexInSlider[0]) {
//                    imagesInSliderHbox.getChildren().removeFirst();
//                    imagesInSliderHbox.getChildren().add(allImagesForSlider.get(currentImageIndex[0]));
//                    maxIndexInSlider[0]++;
//                    minIndexInSlider[0]++;
//                    currentImageIndexInSlider[0] = maxNumberOfImagesInSlider - 1;
//                    previousImageIndexInSlider[0] = currentImageIndexInSlider[0] - 1;
//
//                }
//
//                currentImageView.setImage(images.get(currentImageIndex[0]));
//
//                imagesInSliderHbox.getChildren().get(previousImageIndexInSlider[0]).getStyleClass().removeLast();
//                imagesInSliderHbox.getChildren().get(previousImageIndexInSlider[0]).getStyleClass().add("image-in-slider");
//
//                imagesInSliderHbox.getChildren().get(currentImageIndexInSlider[0]).getStyleClass().removeLast();
//
//                imagesInSliderHbox.getChildren().get(currentImageIndexInSlider[0]).getStyleClass().add("current-image");
//
//
//            }
//        });
//
//        leftArrow.setOnMouseClicked(e -> {
//
//            if (images.size() != 1) {
//
//                previousImageIndex[0] = currentImageIndex[0];
//                previousImageIndexInSlider[0] = currentImageIndexInSlider[0];
//
//                currentImageIndexInSlider[0]--;
//
//                if (currentImageIndex[0] == 0) {
//                    currentImageIndex[0] = images.size() - 1;
//                    minIndexInSlider[0] = images.size() - maxNumberOfImagesInSlider;
//                    maxIndexInSlider[0] = images.size() - 1;
//                    currentImageIndexInSlider[0] = maxNumberOfImagesInSlider - 1;
//                    previousImageIndexInSlider[0] = 0;
//
//                    imagesInSliderHbox.getChildren().getFirst().getStyleClass().removeLast();
//                    imagesInSliderHbox.getChildren().getFirst().getStyleClass().add("image-in-slider");
//
//                    while (!imagesInSliderHbox.getChildren().isEmpty())
//                        imagesInSliderHbox.getChildren().removeLast();
//
//                    for (int i = minIndexInSlider[0]; i <= maxIndexInSlider[0]; i++) {
//                        Button button = allImagesForSlider.get(i);
//
//                        if (i == currentImageIndex[0]) {
//                            button.getStyleClass().removeLast();
//                            button.getStyleClass().add("current-image");
//                        }
//
//                        imagesInSliderHbox.getChildren().add(button);
//                    }
//
//                } else {
//                    currentImageIndex[0]--;
//                }
//
//                if (currentImageIndex[0] < minIndexInSlider[0]) {
//                    imagesInSliderHbox.getChildren().removeLast();
//                    imagesInSliderHbox.getChildren().add(0, allImagesForSlider.get(currentImageIndex[0]));
//                    minIndexInSlider[0]--;
//                    maxIndexInSlider[0]--;
//                    currentImageIndexInSlider[0] = 0;
//                    previousImageIndexInSlider[0] = 1;
//                }
//
//                currentImageView.setImage(images.get(currentImageIndex[0]));
//
//                imagesInSliderHbox.getChildren().get(previousImageIndexInSlider[0]).getStyleClass().removeLast();
//                imagesInSliderHbox.getChildren().get(previousImageIndexInSlider[0]).getStyleClass().add("image-in-slider");
//
//                imagesInSliderHbox.getChildren().get(currentImageIndexInSlider[0]).getStyleClass().removeLast();
//                imagesInSliderHbox.getChildren().get(currentImageIndexInSlider[0]).getStyleClass().add("current-image");
//            }
//        });
//

//        sliderHbox.getChildren().addAll(leftArrow, imagesInSliderHbox, rightArrow);
//        sliderHbox.setAlignment(Pos.CENTER);
//
//        layout.getChildren().addAll(currentImageView, sliderHbox);

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
