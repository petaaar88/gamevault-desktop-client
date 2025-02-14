package org.example.desktopclient.controller;

import org.example.desktopclient.component.RatingButtonComponent;
import org.example.desktopclient.component.RatingComponent;

import java.util.ArrayList;
import java.util.List;

public class RatingController {
    private RatingComponent component;
    private List<RatingButtonController> ratingButtonControllers;

    public RatingController(RatingComponent component) {
        this.component = component;
        ratingButtonControllers = new ArrayList<>();
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
        ratingButtonControllers.add(new RatingButtonController(ratingButtonComponent));
        component.getLayout().getChildren().add(ratingButtonComponent.getComponent());
        component.getButtons().add(ratingButtonComponent);
    }

    public void setComponent(RatingComponent component) {
        this.component = component;
    }

    public List<RatingButtonController> getRatingButtonControllers() {
        return ratingButtonControllers;
    }

    public void setRatingButtonControllers(List<RatingButtonController> ratingButtonControllers) {
        this.ratingButtonControllers = ratingButtonControllers;
    }
}
