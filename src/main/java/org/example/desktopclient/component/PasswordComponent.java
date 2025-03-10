package org.example.desktopclient.component;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PasswordComponent {
    private TextField shownPasswordTextField;
    private PasswordField hiddenPasswordTextField;
    private HBox layout;
    private Button showPasswordButton;
    private ImageView buttonIcon;

    public PasswordComponent(){
        layout = new HBox();
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/searchComponent.css").toExternalForm());

        shownPasswordTextField = new TextField();
        shownPasswordTextField.setMinWidth(360);
        shownPasswordTextField.setMaxWidth(360);
        shownPasswordTextField.getStyleClass().add("search-text");
        shownPasswordTextField.setStyle("-fx-border-color: transparent;-fx-border-radius: 0px;");

        hiddenPasswordTextField = new PasswordField();
        hiddenPasswordTextField.setMinWidth(360);
        hiddenPasswordTextField.setMaxWidth(360);
        hiddenPasswordTextField.getStyleClass().add("search-text");
        hiddenPasswordTextField.setStyle("-fx-border-color: transparent;-fx-border-radius: 0px;");

        buttonIcon = new ImageView(new Image(getClass().getResource("/org/example/desktopclient/icons/hideIcon.png").toExternalForm()));

        showPasswordButton = new Button("",buttonIcon);
        buttonIcon.setFitWidth(24);
        buttonIcon.setFitHeight(24);
        showPasswordButton.setStyle("-fx-background-color: transparent;-fx-cursor: hand");

        layout.getChildren().addAll(hiddenPasswordTextField, showPasswordButton);
        layout.setSpacing(-45);
    }


    public HBox getComponent() {
        return layout;
    }

    public TextField getShownPasswordTextField() {
        return shownPasswordTextField;
    }

    public void setShownPasswordTextField(TextField shownPasswordTextField) {
        this.shownPasswordTextField = shownPasswordTextField;
    }

    public PasswordField getHiddenPasswordTextField() {
        return hiddenPasswordTextField;
    }

    public void setHiddenPasswordTextField(PasswordField hiddenPasswordTextField) {
        this.hiddenPasswordTextField = hiddenPasswordTextField;
    }

    public HBox getLayout() {
        return layout;
    }

    public Button getShowPasswordButton() {
        return showPasswordButton;
    }

    public void setShowPasswordButton(Button showPasswordButton) {
        this.showPasswordButton = showPasswordButton;
    }

    public ImageView getButtonIcon() {
        return buttonIcon;
    }

    public void setButtonIcon(ImageView buttonIcon) {
        this.buttonIcon = buttonIcon;
    }
}
