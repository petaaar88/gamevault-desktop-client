package org.example.desktopclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.UserGameInCollectionDetailsComponent;
import org.example.desktopclient.model.game.GameInLibraryButtonType;
import org.example.desktopclient.model.game.GameInstallationData;
import org.example.desktopclient.scene.UserGameCollectionScene;
import org.example.desktopclient.service.ApplicationContextService;
import org.example.desktopclient.service.game.GameService;
import org.example.desktopclient.util.ChangeSceneUtil;
import org.example.desktopclient.util.FolderDeleter;
import org.example.desktopclient.util.JsonFileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserGameInCollectionDetailsController {

    private UserGameInCollectionDetailsComponent component;
    private GameService gameService;
    private Integer runningGameId;
    private Integer userId;
    private GameInLibraryActionButtonController gameInLibraryActionButtonController;
    private GameInstallationData gameInstallationData;
    private ApplicationContextService applicationContextService;
    private Integer gameId;

    public UserGameInCollectionDetailsController(UserGameInCollectionDetailsComponent component, Integer userId, ApplicationContextService applicationContextService) {

        this.component = component;
        this.userId = userId;
        this.runningGameId = applicationContextService.getRunningGameId();
        gameService = new GameService();
        this.applicationContextService = applicationContextService;

        gameInLibraryActionButtonController = new GameInLibraryActionButtonController(component.getGameInLibraryActionButtonComponent());
        gameInLibraryActionButtonController.setUserId(userId);
        gameInLibraryActionButtonController.setApplicationContextService(applicationContextService);
    }

    public void handleDeleteGameButton() {
        if (!Objects.isNull(gameInstallationData)) {
            component.getDeleteButton().setVisible(true);
        } else
            component.getDeleteButton().setVisible(false);

        component.getDeleteButton().setOnMouseClicked(e -> {
            if (!Objects.isNull(gameInstallationData)) {
                showAlert("Do you want to delete this game?", gameId);
            }

        });
    }

    public void initialize() {


        gameService.fetchUserGameCollection(userId, games -> {
            Platform.runLater(() -> {
                gameInLibraryActionButtonController.setGameId(games.getFirst().getId());
                this.changeGame(games.getFirst().getId());
                gameId = games.getFirst().getId();
                handleDeleteGameButton();
                if (runningGameId == games.getFirst().getId()) {
                    gameInLibraryActionButtonController.setType(GameInLibraryButtonType.PLAYING);
                }

            });
        });
    }

    public void changeGame(Integer newGameId) {

        //TODO: ovde se menja stanje dugmeta
        gameService.fetchGameInUserCollection(userId, newGameId, game -> {
            Platform.runLater(() -> {
                gameId = newGameId;
                handleDeleteGameButton();
                if (!Objects.isNull(gameInstallationData)) {
                    if (gameInstallationData.getGame_id() == newGameId) {
                        if (applicationContextService.getRunningGameId() != newGameId) {
                            gameInLibraryActionButtonController.setType(GameInLibraryButtonType.PLAY);
                            gameInLibraryActionButtonController.handlePlayButton(gameInstallationData.getGame_folder(),gameInstallationData.getGame_executable(), this);
                        } else if (applicationContextService.getRunningGameId() == newGameId)
                            gameInLibraryActionButtonController.setType(GameInLibraryButtonType.PLAYING);

                    }
                } else {
                    gameInLibraryActionButtonController.setType(GameInLibraryButtonType.DOWNLOAD);
                    gameInLibraryActionButtonController.handleDownloadButton();

                }
                component.setNewContent(game);
                gameInLibraryActionButtonController.setGameId(newGameId);
            });
        });

    }

    public void showAlert(String message, Integer gameId) {
        Stage alertStage = new Stage();
        alertStage.initStyle(StageStyle.UNDECORATED); // Uklanja naslovnu traku
        alertStage.initModality(Modality.APPLICATION_MODAL); // Blokira interakciju sa glavnim prozorom dok je alert otvoren

        // Tekst poruke
        Label alertText = new Label(message);
        alertText.setStyle("-fx-font-size: 25px;-fx-text-fill: white");

        // Dugme za zatvaranje
        Button closeButton = new Button("Exit");
        closeButton.setStyle("-fx-background-color: #0084FF;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:17px;-fx-padding: 5 14 5 14;-fx-font-weight:700");
        closeButton.setOnAction(ec -> alertStage.close());

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: red;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:17px;-fx-padding: 5 14 5 14;-fx-font-weight:700");
        deleteButton.setOnAction(ec -> {

            JsonFileManager jsonFileManager = new JsonFileManager();
            Path jsonFile = jsonFileManager.getConfigFilePath("GameVault", "installed_games.json");
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                List<GameInstallationData> games = new ArrayList<>();

                // Ako fajl postoji, učitaj postojeće igre
                if (Files.exists(jsonFile)) {
                    games = objectMapper.readValue(Files.readString(jsonFile), new TypeReference<List<GameInstallationData>>() {
                    });
                }

                GameInstallationData game2 = games.stream().filter(g -> g.getGame_id() == gameId).findFirst().orElse(null);

                games.removeIf(game -> game.getGame_id() == gameId);
                objectMapper.writeValue(Files.newBufferedWriter(jsonFile), games);
                FolderDeleter.deleteFolder(Paths.get(game2.getGame_folder()));

            } catch (IOException e) {
                e.printStackTrace();
            }


            alertStage.close();
            ChangeSceneUtil.changeScene(UserGameCollectionScene.getInstance().createScene());
        });

        HBox buttons = new HBox(deleteButton,closeButton);
        buttons.setSpacing(16);
        buttons.setAlignment(Pos.CENTER);
        // Pravljenje layout-a
        VBox alertLayout = new VBox(10, alertText, buttons);
        alertLayout.setAlignment(Pos.CENTER);
        alertLayout.setStyle("-fx-background-color: #191B2E;-fx-border-color:#333352;-fx-border-width: 2px; -fx-padding: 25px 50px 25px 50px;");

        Scene alertScene = new Scene(alertLayout);
        alertScene.setFill(Color.TRANSPARENT); // Ako želiš prozirnu pozadinu

        alertStage.setScene(alertScene);
        alertStage.showAndWait();
    }

    public void setGameInstallationData(GameInstallationData gameInstallationData) {
        this.gameInstallationData = gameInstallationData;
    }

    public Integer getRunningGameId() {
        return runningGameId;
    }

    public void setRunningGameId(Integer runningGameId) {
        this.runningGameId = runningGameId;
        applicationContextService.setRunningGameId(runningGameId);
    }
}
