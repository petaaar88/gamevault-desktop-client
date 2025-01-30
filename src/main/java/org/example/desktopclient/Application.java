package org.example.desktopclient;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.scene.GameCatalogScene;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private double xOffset = 0;
    private double yOffset = 0;
    private final double borderThickness = 5; // Debljina ivica za resize


    @Override
    public void start(Stage primaryStage) throws IOException {

            // Uklanjanje podrazumevanog okvira prozora
            primaryStage.initStyle(StageStyle.UNDECORATED);

            // 🔹 Naslovna traka (Custom Title Bar)
            HBox titleBar = new HBox();
            titleBar.setStyle("-fx-background-color: #0E0F1A; -fx-padding: 2 10; -fx-border-color: black; -fx-border-width: 1;");
            titleBar.setAlignment(Pos.CENTER_LEFT);
            titleBar.setSpacing(10);
            titleBar.setPrefHeight(30);

            // 🔹 Naslov aplikacije
            Label title = new Label("Game Catalog");
            title.setFont(new Font(14));
            title.setTextFill(Color.WHITE);

        // 🔹 Dugme za maksimizaciju/proširivanje prozora
        Button maximizeButton = new Button("\u2610"); // "□"
        maximizeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 14;");
        maximizeButton.setOnAction(e -> {
            if (primaryStage.isMaximized()) {
                primaryStage.setMaximized(false);
                maximizeButton.setText("\u2610"); // "□"
            } else {
                primaryStage.setMaximized(true);
                maximizeButton.setText("\u2751"); // "❐"
            }
        });

// 🔹 Dugme za minimizaciju
        Button minimizeButton = new Button("\u2500"); // "—"
        minimizeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 14;");
        minimizeButton.setOnAction(e -> primaryStage.setIconified(true));

            Button closeButton = new Button("\u2715"); // "✕"
            closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 14;");
            closeButton.setOnAction(e -> primaryStage.close());

            HBox buttons = new HBox(minimizeButton,maximizeButton, closeButton);
            buttons.setSpacing(10);
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

            // 🔹 Inicijalizacija `GameCatalogScene`
            GameCatalogScene gameCatalogScene = new GameCatalogScene();
            VBox layout = gameCatalogScene.createScene(primaryStage);

            // 🔹 Glavni `VBox` koji kombinuje naslovnu traku i sadržaj prozora
            VBox root = new VBox(titleBar, layout);
            root.setStyle("-fx-border: none;-fx-background-color: #191B2E");

            // 🔹 Omogućavanje resizovanja
            enableResize(primaryStage, root);

            // 🔹 Kreiranje scene sa učitanim stilovima
            Scene scene = new Scene(root, 1200, 768);
            String css = getClass().getResource("/org/example/desktopclient/styles/universalStyles.css").toExternalForm();
            scene.getStylesheets().add(css);

            // 🔹 Postavljanje minimalne veličine i prikazivanje prozora
            primaryStage.setMinWidth(1048);
            primaryStage.setMinHeight(550);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        /**
         * Omogućava resizovanje prozora prevlačenjem ivica
         */
        private void enableResize (Stage stage, Region root){
            root.setOnMouseMoved(event -> {
                double mouseX = event.getX();
                double mouseY = event.getY();
                double width = root.getWidth();
                double height = root.getHeight();

                // Promena kursora u zavisnosti od pozicije miša
                if (mouseX < borderThickness && mouseY < borderThickness) {
                    root.setCursor(javafx.scene.Cursor.NW_RESIZE);
                } else if (mouseX > width - borderThickness && mouseY < borderThickness) {
                    root.setCursor(javafx.scene.Cursor.NE_RESIZE);
                } else if (mouseX < borderThickness && mouseY > height - borderThickness) {
                    root.setCursor(javafx.scene.Cursor.SW_RESIZE);
                } else if (mouseX > width - borderThickness && mouseY > height - borderThickness) {
                    root.setCursor(javafx.scene.Cursor.SE_RESIZE);
                } else if (mouseX < borderThickness) {
                    root.setCursor(javafx.scene.Cursor.W_RESIZE);
                } else if (mouseX > width - borderThickness) {
                    root.setCursor(javafx.scene.Cursor.E_RESIZE);
                } else if (mouseY < borderThickness) {
                    root.setCursor(javafx.scene.Cursor.N_RESIZE);
                } else if (mouseY > height - borderThickness) {
                    root.setCursor(javafx.scene.Cursor.S_RESIZE);
                } else {
                    root.setCursor(javafx.scene.Cursor.DEFAULT);
                }
            });

            root.setOnMouseDragged(event -> {
                double mouseX = event.getX();
                double mouseY = event.getY();
                double width = root.getWidth();
                double height = root.getHeight();

                // Pomeranje granica prozora
                if (root.getCursor() == javafx.scene.Cursor.E_RESIZE && mouseX > 1048) {
                    stage.setWidth(mouseX);
                } else if (root.getCursor() == javafx.scene.Cursor.W_RESIZE && stage.getWidth() - mouseX > 1048) {
                    stage.setX(stage.getX() + mouseX);
                    stage.setWidth(stage.getWidth() - mouseX);
                } else if (root.getCursor() == javafx.scene.Cursor.S_RESIZE && mouseY > 550) {
                    stage.setHeight(mouseY);
                } else if (root.getCursor() == javafx.scene.Cursor.N_RESIZE && stage.getHeight() - mouseY > 550) {
                    stage.setY(stage.getY() + mouseY);
                    stage.setHeight(stage.getHeight() - mouseY);
                }
            });
        }

        public static void main (String[]args){
            launch();
        }
    }