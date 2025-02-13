package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleGameSystemRequirements {

    private VBox layout;
    private Text title;
    private Label osLabel;
    private Label cpuLabel;
    private Label gpuLabel;
    private Label ramLabel;
    private Label storageLabel;
    private Label exprectedStorageLabel;

    public SingleGameSystemRequirements() {
        layout = new VBox();
        layout.setPadding(new Insets(10, 0, 0, 0));

        title = new Text("Recommended");
        title.setStyle("-fx-fill: white; -fx-font-size: 18;");

        HBox osHbox = new HBox();
        osHbox.setPadding(new Insets(10, 0, 0, 0));
        osHbox.setSpacing(7);
        Text osText = new Text("OS:");
        osText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        osLabel = new Label("");
        osLabel.setStyle("-fx-font-size: 15");
        osHbox.getChildren().addAll(osText, osLabel);

        HBox cpuHbox = new HBox();
        cpuHbox.setSpacing(7);
        Text cpuText = new Text("Processor:");
        cpuText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        cpuLabel = new Label("");
        cpuLabel.setStyle("-fx-font-size: 15");
        cpuHbox.getChildren().addAll(cpuText, cpuLabel);

        HBox gpuHbox = new HBox();
        gpuHbox.setSpacing(7);
        Text gpuText = new Text("Graphics:");
        gpuText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        gpuLabel = new Label("");
        gpuLabel.setStyle("-fx-font-size: 15");
        gpuHbox.getChildren().addAll(gpuText, gpuLabel);

        HBox ramHbox = new HBox();
        ramHbox.setSpacing(7);
        Text ramText = new Text("Memory:");
        ramText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        ramLabel = new Label("");
        ramLabel.setStyle("-fx-font-size: 15");
        ramHbox.getChildren().addAll(ramText, ramLabel);

        HBox storageHbox = new HBox();
        storageHbox.setSpacing(7);
        Text storageText = new Text("Storage:");
        storageText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        storageLabel = new Label("");
        storageLabel.setStyle("-fx-font-size: 15");
        storageHbox.getChildren().addAll(storageText, storageLabel);

        HBox exprectedStorageHbox = new HBox();
        exprectedStorageHbox.setSpacing(7);
        Text exprectedStorageText = new Text("Expected Storage:");
        exprectedStorageText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        exprectedStorageLabel = new Label("");
        exprectedStorageLabel.setStyle("-fx-font-size: 15");
        exprectedStorageHbox.getChildren().addAll(exprectedStorageText, exprectedStorageLabel);

        layout.getChildren().addAll(title, osHbox, cpuHbox, gpuHbox, ramHbox, storageHbox, exprectedStorageHbox);

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

    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public Label getOsLabel() {
        return osLabel;
    }

    public void setOsLabel(Label osLabel) {
        this.osLabel = osLabel;
    }

    public Label getCpuLabel() {
        return cpuLabel;
    }

    public void setCpuLabel(Label cpuLabel) {
        this.cpuLabel = cpuLabel;
    }

    public Label getGpuLabel() {
        return gpuLabel;
    }

    public void setGpuLabel(Label gpuLabel) {
        this.gpuLabel = gpuLabel;
    }

    public Label getRamLabel() {
        return ramLabel;
    }

    public void setRamLabel(Label ramLabel) {
        this.ramLabel = ramLabel;
    }

    public Label getStorageLabel() {
        return storageLabel;
    }

    public void setStorageLabel(Label storageLabel) {
        this.storageLabel = storageLabel;
    }

    public Label getExprectedStorageLabel() {
        return exprectedStorageLabel;
    }

    public void setExprectedStorageLabel(Label exprectedStorageLabel) {
        this.exprectedStorageLabel = exprectedStorageLabel;
    }
}
