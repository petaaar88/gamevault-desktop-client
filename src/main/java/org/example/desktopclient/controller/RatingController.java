package org.example.desktopclient.controller;

import org.example.desktopclient.component.RatingButtonComponent;
import org.example.desktopclient.component.RatingComponent;

public class RatingController {
    private RatingComponent component;

    public RatingController(RatingComponent component) {
        this.component = component;
        this.initialize();
    }

    public RatingComponent getComponent() {
        return component;
    }

    public void initialize(){
        addRatingButton("Mostly Negative");
        addRatingButton("Negative");
        addRatingButton("Mixed");
        addRatingButton("Positive");
        addRatingButton("Mostly Positive");

        component.getButtons().forEach(button -> button.setOtherButtons(component.getButtons().stream().filter(b -> b != button).toList()));

    }

    public void addRatingButton(String ratingName) {
        RatingButtonComponent ratingButtonComponent = new RatingButtonComponent(ratingName);
        component.getLayout().getChildren().add(ratingButtonComponent.getComponent());
        component.getButtons().add(ratingButtonComponent);
    }

    public void setComponent(RatingComponent component) {
        this.component = component;
    }
}
