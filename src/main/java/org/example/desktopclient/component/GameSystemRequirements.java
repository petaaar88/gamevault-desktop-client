package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GameSystemRequirements {

    public VBox getComponent(){
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #333352;");
        layout.setPadding(new Insets(19));
        layout.setMaxHeight(Region.USE_PREF_SIZE);


        Label title = new Label("System Requirements");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 20px");
        title.setPadding(new Insets(0,0,8,0));

        Line line = new Line(50, 70, 640, 70);
        line.setStroke(Color.web("#0084FF"));
        line.setStrokeWidth(3);

        HBox hBox = new HBox();
        hBox.setSpacing(15);

        VBox mimimumSingleGameSystemRequirements = new SingleGameSystemRequirements().getComponent("Minimum");
        VBox recommendedSingleGameSystemRequirements = new SingleGameSystemRequirements().getComponent("Recommended");

        HBox.setHgrow(mimimumSingleGameSystemRequirements, Priority.ALWAYS);
        HBox.setHgrow(recommendedSingleGameSystemRequirements, Priority.ALWAYS);

        hBox.getChildren().addAll(mimimumSingleGameSystemRequirements,recommendedSingleGameSystemRequirements);

        layout.getChildren().addAll(title, line,hBox);

        return layout;
    }
}
