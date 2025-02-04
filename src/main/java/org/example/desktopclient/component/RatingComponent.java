package org.example.desktopclient.component;

import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.List;

public class RatingComponent {

    private List<RatingButtonComponent> buttons;
    private HBox layout;

    public RatingComponent() {
        buttons = new ArrayList<>();
        layout = new HBox();
        layout.setSpacing(1);

        addRatingButton("Mostly Negative");
        addRatingButton("Negative");
        addRatingButton("Mixed");
        addRatingButton("Positive");
        addRatingButton("Mostly Positive");

    }

    public HBox getComponent() {
        buttons.forEach(button -> button.setOtherButtons(buttons.stream().filter(b -> b != button).toList()));
        return layout;
    }

    public void addRatingButton(String ratingName) {
        RatingButtonComponent ratingButtonComponent = new RatingButtonComponent(ratingName);
        layout.getChildren().add(ratingButtonComponent.getComponent());
        buttons.add(ratingButtonComponent);
    }
}
