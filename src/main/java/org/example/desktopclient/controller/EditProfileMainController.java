package org.example.desktopclient.controller;

import org.example.desktopclient.component.EditProfileMainVerticalComponent;

public class EditProfileMainController {
    private EditProfileMainVerticalComponent component;
    private Integer userId;

    public EditProfileMainController(EditProfileMainVerticalComponent component, Integer userId) {
        this.component = component;
        this.userId = userId;
    }

    public EditProfileMainVerticalComponent getComponent() {
        return component;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
