package org.example.desktopclient.controller;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import org.example.desktopclient.component.PasswordComponent;

public class PasswordController {
    private String password;
    private PasswordComponent component;

    public PasswordController(PasswordComponent component) {
        this.component = component;
        this.handleShowPasswordClick();
        password = "";
        this.handlePasswordChange();
    }

    public void handleShowPasswordClick() {
        component.getShowPasswordButton().setOnMouseClicked(e -> {
            if (component.getLayout().getChildren().getFirst() instanceof PasswordField) {
                component.getLayout().getChildren().removeFirst();
                component.getLayout().getChildren().addFirst(component.getShownPasswordTextField());
                component.getButtonIcon().setImage(new Image(getClass().getResource("/org/example/desktopclient/icons/showIcon.png").toExternalForm()));
                component.getShownPasswordTextField().setText(password);
            } else {
                component.getLayout().getChildren().removeFirst();
                component.getLayout().getChildren().addFirst(component.getHiddenPasswordTextField());
                component.getButtonIcon().setImage(new Image(getClass().getResource("/org/example/desktopclient/icons/hideIcon.png").toExternalForm()));
                component.getHiddenPasswordTextField().setText(password);
            }
        });
    }

    public void handlePasswordChange() {
        // Prati promene u prvom (vidljivom) polju
        component.getShownPasswordTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            // Kada se menja tekst u vidljivom polju, ažuriraj lozinku
            if (!newValue.equals(password)) {
                password = newValue;
            }
        });

        // Prati promene u drugom (skrivenom) polju
        component.getHiddenPasswordTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            // Kada se menja tekst u skrivenom polju, ažuriraj lozinku
            if (!newValue.equals(password)) {
                password = newValue;
            }
        });
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
