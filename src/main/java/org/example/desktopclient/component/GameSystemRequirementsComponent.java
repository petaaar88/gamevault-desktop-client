package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.example.desktopclient.controller.SingleGameSystemRequirementsController;

public class GameSystemRequirementsComponent {

    private VBox layout;
    private VBox mimimumSingleGameSystemRequirementsVbox;
    private VBox recommendedSingleGameSystemRequirementsVbox;
    private SingleGameSystemRequirements minimumSingleGameSystemRequirements;
    private SingleGameSystemRequirements recommendedSingleGameSystemRequirements;
    private SingleGameSystemRequirementsController minimumSingleGameSystemRequirementsController;
    private SingleGameSystemRequirementsController recommendedSingleGameSystemRequirementsController;


    public GameSystemRequirementsComponent() {
        layout = new VBox();
        layout.setStyle("-fx-background-color: #333352;");
        layout.setPadding(new Insets(19));
        layout.setMaxHeight(Region.USE_PREF_SIZE);


        Label title = new Label("System Requirements");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 20px");
        title.setPadding(new Insets(0, 0, 8, 0));

        Line line = new Line(50, 70, 640, 70);
        line.setStroke(Color.web("#0084FF"));
        line.setStrokeWidth(3);

        HBox hBox = new HBox();
        hBox.setSpacing(15);

        minimumSingleGameSystemRequirements = new SingleGameSystemRequirements();
        minimumSingleGameSystemRequirementsController = new SingleGameSystemRequirementsController(minimumSingleGameSystemRequirements);
        recommendedSingleGameSystemRequirements = new SingleGameSystemRequirements();
        recommendedSingleGameSystemRequirementsController = new SingleGameSystemRequirementsController(recommendedSingleGameSystemRequirements);

        mimimumSingleGameSystemRequirementsVbox = minimumSingleGameSystemRequirements.getComponent();
        recommendedSingleGameSystemRequirementsVbox = recommendedSingleGameSystemRequirements.getComponent();

        HBox.setHgrow(mimimumSingleGameSystemRequirementsVbox, Priority.ALWAYS);
        HBox.setHgrow(recommendedSingleGameSystemRequirementsVbox, Priority.ALWAYS);

        hBox.getChildren().addAll(mimimumSingleGameSystemRequirementsVbox, recommendedSingleGameSystemRequirementsVbox);

        layout.getChildren().addAll(title, line, hBox);
    }

    public VBox getComponent() {
        return layout;
    }

    public VBox getLayout() {
        return layout;
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public SingleGameSystemRequirementsController getMinimumSingleGameSystemRequirementsController() {
        return minimumSingleGameSystemRequirementsController;
    }

    public void setMinimumSingleGameSystemRequirementsController(SingleGameSystemRequirementsController minimumSingleGameSystemRequirementsController) {
        this.minimumSingleGameSystemRequirementsController = minimumSingleGameSystemRequirementsController;
    }

    public SingleGameSystemRequirementsController getRecommendedSingleGameSystemRequirementsController() {
        return recommendedSingleGameSystemRequirementsController;
    }

    public void setRecommendedSingleGameSystemRequirementsController(SingleGameSystemRequirementsController recommendedSingleGameSystemRequirementsController) {
        this.recommendedSingleGameSystemRequirementsController = recommendedSingleGameSystemRequirementsController;
    }
}
