package org.example.desktopclient.controller;

import org.example.desktopclient.component.RatingButtonComponent;
import org.example.desktopclient.component.RatingComponent;

public class RatingButtonController {
    private RatingButtonComponent component;

    public RatingButtonController(RatingButtonComponent component){
        this.component = component;
    }

    public RatingButtonComponent getComponent() {
        return component;
    }

    public void setComponent(RatingButtonComponent component) {
        this.component = component;
    }
}
