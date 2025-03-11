package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RegisterMainComponent {
    private VBox layout;
    private Button closeButton;
    private Button backButton;
    private TextField usernameTextField;
    private PasswordComponent passwordComponent;
    private ImageUploaderComponent imageUploaderComponent;
    private Button registerButton;

    public RegisterMainComponent() {
        this.layout = new VBox();
        layout.setPadding(new Insets(40));
        layout.setSpacing(20);
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm());
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/searchComponent.css").toExternalForm());

        closeButton = new Button("X");
        closeButton.getStyleClass().add("small-red-action-button");
        closeButton.setPrefWidth(10);

        backButton = new Button("Back");
        backButton.getStyleClass().add("small-action-button");

        HBox buttonsHbox = new HBox(backButton, closeButton);
        buttonsHbox.setSpacing(10);

        Text createAccountText = new Text("Create Account");
        createAccountText.setStyle("-fx-fill: white; -fx-font-size: 25; -fx-font-weight: 700;");
        HBox createAccountHbox = new HBox(createAccountText);

        HBox titleHBox = new HBox(createAccountHbox, buttonsHbox);
        HBox.setHgrow(createAccountHbox, Priority.ALWAYS);

        layout.getChildren().add(titleHBox);

        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14;");
        usernameTextField = new TextField();
        usernameTextField.setMinWidth(360);
        usernameTextField.setMaxWidth(360);
        usernameTextField.getStyleClass().add("search-text");
        usernameTextField.setStyle("-fx-border-color: transparent;-fx-border-radius: 0px;");
        VBox usernameVbox = new VBox(usernameLabel, usernameTextField);
        usernameVbox.setSpacing(5);
        layout.getChildren().add(usernameVbox);

        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14;");
        layout.getChildren().add(passwordLabel);
        passwordComponent = new PasswordComponent();

        VBox passwordVbox = new VBox(passwordLabel, passwordComponent.getComponent());
        passwordVbox.setSpacing(5);
        passwordVbox.setPadding(new Insets(0,0,10,0));
        layout.getChildren().add(passwordVbox);

        Label profileImageLabel = new Label("Profile Image");
        profileImageLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14;");
        imageUploaderComponent = new ImageUploaderComponent();
        HBox imageUploaderHbox = new HBox(imageUploaderComponent.getComponent());
        imageUploaderHbox.setAlignment(Pos.CENTER_LEFT);
        VBox profileImageVbox = new VBox(profileImageLabel, imageUploaderHbox);
        profileImageVbox.setSpacing(5);
        layout.getChildren().add(profileImageVbox);

        registerButton = new Button("Register");
        registerButton.getStyleClass().add("normal-action-button");
        layout.getChildren().add(registerButton);

    }

    public VBox getComponent() {
        return this.layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Button closeButton) {
        this.closeButton = closeButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(TextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public PasswordComponent getPasswordComponent() {
        return passwordComponent;
    }

    public void setPasswordComponent(PasswordComponent passwordComponent) {
        this.passwordComponent = passwordComponent;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }

    public ImageUploaderComponent getImageUploaderComponent() {
        return imageUploaderComponent;
    }

    public void setImageUploaderComponent(ImageUploaderComponent imageUploaderComponent) {
        this.imageUploaderComponent = imageUploaderComponent;
    }
}
