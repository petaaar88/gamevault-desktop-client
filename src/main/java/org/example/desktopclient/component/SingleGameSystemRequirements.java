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

    public VBox getComponent(String type){
        VBox layout = new VBox();
        layout.setPadding(new Insets(10,0,0,0));

        Map<String, String> minimumRequirements = new HashMap<>();
        minimumRequirements.put("type","Minimum");
        minimumRequirements.put("os","Windows 11");
        minimumRequirements.put("cpu","Ryzen 5");
        minimumRequirements.put("gpu","RTX 3080");
        minimumRequirements.put("ram","8GB");
        minimumRequirements.put("storage","120GB");
        minimumRequirements.put("ex_storage","150GB");

        Text title = new Text((type == "Recommended")? "Recommended":"Minimum");
        title.setStyle("-fx-fill: white; -fx-font-size: 18;");

        HBox osHbox = new HBox();
        osHbox.setPadding(new Insets(10,0,0,0));
        osHbox.setSpacing(7);
        Text osText = new Text("OS:");
        osText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        Label osLabel = new Label(minimumRequirements.get("os"));
        osLabel.setStyle("-fx-font-size: 15");
        osHbox.getChildren().addAll(osText,osLabel);

        HBox cpuHbox = new HBox();
        cpuHbox.setSpacing(7);
        Text cpuText = new Text("Processor:");
        cpuText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        Label cpuLabel = new Label(minimumRequirements.get("cpu"));
        cpuLabel.setStyle("-fx-font-size: 15");
        cpuHbox.getChildren().addAll(cpuText,cpuLabel);

        HBox gpuHbox = new HBox();
        gpuHbox.setSpacing(7);
        Text gpuText = new Text("Graphics:");
        gpuText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        Label gpuLabel = new Label(minimumRequirements.get("gpu"));
        gpuLabel.setStyle("-fx-font-size: 15");
        gpuHbox.getChildren().addAll(gpuText,gpuLabel);

        HBox ramHbox = new HBox();
        ramHbox.setSpacing(7);
        Text ramText = new Text("Memory:");
        ramText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        Label ramLabel = new Label(minimumRequirements.get("ram"));
        ramLabel.setStyle("-fx-font-size: 15");
        ramHbox.getChildren().addAll(ramText,ramLabel);

        HBox storageHbox = new HBox();
        storageHbox.setSpacing(7);
        Text storageText = new Text("Storage:");
        storageText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        Label storageLabel = new Label(minimumRequirements.get("storage"));
        storageLabel.setStyle("-fx-font-size: 15");
        storageHbox.getChildren().addAll(storageText,storageLabel);

        HBox exprectedStorageHbox = new HBox();
        exprectedStorageHbox.setSpacing(7);
        Text exprectedStorageText = new Text("Expected Storage:");
        exprectedStorageText.setStyle("-fx-fill: #8079CB; -fx-font-size: 15;-fx-font-weight: 700;");
        Label exprectedStorageLabel = new Label(minimumRequirements.get("ex_storage"));
        exprectedStorageLabel.setStyle("-fx-font-size: 15");
        exprectedStorageHbox.getChildren().addAll(exprectedStorageText,exprectedStorageLabel);

        layout.getChildren().addAll(title, osHbox,cpuHbox,gpuHbox,ramHbox,storageHbox,exprectedStorageHbox);

        return layout;

    }
}
