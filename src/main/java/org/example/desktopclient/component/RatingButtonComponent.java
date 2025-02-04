package org.example.desktopclient.component;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.desktopclient.exception.InvalidRatingName;

import java.util.ArrayList;
import java.util.List;

public class RatingButtonComponent {

    private final boolean[] isSelected;
    private Button button;
    private ImageView imageView;
    private Image hoverImage;
    private Image normalImage;
    private String name;
    private String nameForJson;
    private List<RatingButtonComponent> otherButtons;

    public RatingButtonComponent(String ratingName){
        nameForJson =  ratingName.trim().replace(' ','_').toLowerCase();
        try {
            this.verifyRatingName();
        } catch (InvalidRatingName e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        name = ratingName.trim();

        isSelected = new boolean[1];

        this.addImageToButton();

        otherButtons = new ArrayList<>();

    }

    public Button getComponent() {

        imageView = new ImageView(normalImage);
        imageView.setFitWidth(31);
        imageView.setFitHeight(31);

        button = new Button("", imageView);
        button.setStyle("-fx-cursor: hand; -fx-background-color: transparent");

        Tooltip tooltip = new Tooltip(name);
        Tooltip.install(button, tooltip);

        button.setOnMouseEntered(e -> imageView.setImage(hoverImage));
        button.setOnMouseExited(e -> {
            if (!isSelected[0])
                imageView.setImage(normalImage);
        });
        button.setOnMouseClicked(e -> {
            isSelected[0] = true;
            imageView.setImage(hoverImage);
            otherButtons.forEach(RatingButtonComponent::deselect);
        });

        return button;
    }

    public boolean getIsSelected() {
        return isSelected[0];
    }

    public String getNameForJson(){
        return nameForJson;
    }

    public void deselect() {
        isSelected[0] = false;
        imageView.setImage(normalImage);

    }

    private void verifyRatingName()throws InvalidRatingName{
        if(!nameForJson.equalsIgnoreCase("positive") &&  !nameForJson.equalsIgnoreCase("mostly_positive") && !nameForJson.equalsIgnoreCase("mixed") && !nameForJson.equalsIgnoreCase("negative") && !nameForJson.equalsIgnoreCase("mostly_negative"))
            throw new InvalidRatingName("Invalid rating name - "+nameForJson);
    }

    private void addImageToButton(){
        String[] words = nameForJson.split("_"); // Razdvajamo po donjoj crti
        StringBuilder camelCaseString = new StringBuilder(words[0]); // Prvi deo ostaje mali

        for (int i = 1; i < words.length; i++) {
            camelCaseString.append(Character.toUpperCase(words[i].charAt(0))) // Prvo slovo veliko
                    .append(words[i].substring(1)); // Ostatak ostaje isti
        }

        String iconUrl = getClass().getResource("/org/example/desktopclient/icons/emoji/"+camelCaseString.toString()+"EmojiDark.png").toExternalForm();
        String hoverIconUrl = getClass().getResource("/org/example/desktopclient/icons/emoji/"+camelCaseString.toString()+"EmojiLight.png").toExternalForm();

        hoverImage = new Image(hoverIconUrl);
        normalImage = new Image(iconUrl);
    }

    public List<RatingButtonComponent> getOtherButtons() {
        return otherButtons;
    }

    public void setOtherButtons(List<RatingButtonComponent> otherButtons) {
        this.otherButtons = otherButtons;
    }
}
