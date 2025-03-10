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

public class LoginMainComponent {

    private VBox layout;
    private Button closeButton;
    private TextField usernameTextField;
    private PasswordComponent passwordComponent;
    private Button loginButton;
    private Label createAccountButton;


    public LoginMainComponent() {
        layout = new VBox();
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm());
        layout.getStylesheets().add(getClass().getResource("/org/example/desktopclient/styles/searchComponent.css").toExternalForm());

        Text gameVaultText = new Text("GameVault");
        gameVaultText.setStyle("-fx-fill: white; -fx-font-size: 40; -fx-font-weight: 700;");

        closeButton = new Button("X");
        closeButton.getStyleClass().add("small-red-action-button");
        closeButton.setPrefWidth(10);
        HBox titleHbox2 = new HBox(gameVaultText);
        HBox titleHbox = new HBox(titleHbox2, closeButton);
        titleHbox.setAlignment(Pos.CENTER);
        titleHbox.setPadding(new Insets(0,0,10,0));
        HBox.setHgrow(titleHbox2, Priority.ALWAYS);

        layout.getChildren().add(titleHbox);

        layout.setPadding(new Insets(40));

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

        loginButton = new Button("Sign In");
        loginButton.getStyleClass().add("normal-action-button");
        layout.getChildren().add(loginButton);

        HBox createAccountHbox = new HBox();
        createAccountHbox.setAlignment(Pos.CENTER);
        Label createAccountLabel = new Label("Don't have an account? ");
        createAccountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 13;");
        createAccountButton = new Label("Create Account");
        createAccountButton.setStyle("-fx-cursor: hand; -fx-text-fill: #B6B4B4; -fx-font-size: 13px;");
        createAccountButton.setOnMouseEntered(event -> createAccountButton.setStyle("-fx-cursor: hand;-fx-text-fill: #565656;-fx-font-size: 13px;-fx-underline: true;"));
        createAccountButton.setOnMouseExited(event -> createAccountButton.setStyle("-fx-text-fill: #B6B4B4;-fx-font-size: 13px;"));
        createAccountHbox.getChildren().addAll(createAccountLabel, createAccountButton);
        createAccountHbox.setPadding(new Insets(5,0,0,0));
        layout.getChildren().add(createAccountHbox);

        layout.setSpacing(15);

    }


    public VBox getComponent() {
        return layout;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Button closeButton) {
        this.closeButton = closeButton;
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

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }
}
