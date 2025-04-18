package org.example.desktopclient.util;

import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class WindowResizer {

    public static void resizingWindow(Stage stage, Region root, double borderThickness){
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

            if (stage.isResizable()) {

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
            }
        });


    }
}
