package org.example.desktopclient.component;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TitleBarComponent {

    private double xOffset;
    private double yOffset;
    private Button closeButton;

    public HBox getComponent(Stage primaryStage, double xOffset1, double yOffset1) {

        xOffset = xOffset1;
        yOffset = yOffset1;

        // 🔹 Naslovna traka (Custom Title Bar)
        HBox titleBar = new HBox();

        String css = getClass().getResource("/org/example/desktopclient/styles/titleBarComponentStyles.css").toExternalForm();

        titleBar.getStylesheets().add(css);
        titleBar.getStyleClass().add("title-bar");

        titleBar.setAlignment(Pos.CENTER_LEFT);
        titleBar.setSpacing(10);
        titleBar.setPrefHeight(30);

        // 🔹 Naslov aplikacije
        Label title = new Label("GameVault");
        title.setFont(new Font(13));
        title.getStyleClass().add("title-bar-text");

        // 🔹 Dugme za maksimizaciju/proširivanje prozora
        Button maximizeButton = new Button("\u2610"); // "□"
        maximizeButton.getStyleClass().add("title-bar-maximize-icon");
        maximizeButton.setOnAction(e -> {
            if (primaryStage.isMaximized()) {
                primaryStage.setMaximized(false);
                maximizeButton.setText("\u2610"); // "□"
                primaryStage.setResizable(true);
            } else {
                primaryStage.setMaximized(true);
                maximizeButton.setText("\u2751"); // "❐"
                primaryStage.setResizable(false);
            }
        });

        // 🔹 Dugme za minimizaciju
        Button minimizeButton = new Button("\u2500"); // "—"
        minimizeButton.getStyleClass().add("title-bar-minimize-icon");
        minimizeButton.setOnAction(e -> primaryStage.setIconified(true));

        closeButton = new Button("\u2715"); // "✕"
        closeButton.getStyleClass().add("title-bar-close-icon");
        //closeButton.setOnAction(e -> primaryStage.close());

        HBox buttons = new HBox(minimizeButton, maximizeButton, closeButton);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(buttons, Priority.ALWAYS);

        titleBar.getChildren().addAll(title, buttons);

        // 🔹 Omogućavanje prevlačenja prozora mišem
        titleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        titleBar.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        return titleBar;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Button closeButton) {
        this.closeButton = closeButton;
    }
}
