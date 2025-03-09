package org.example.desktopclient.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.desktopclient.component.GameInLibraryActionButtonComponent;
import org.example.desktopclient.model.game.GameInLibraryButtonType;
import org.example.desktopclient.service.ApplicationContextService;
import org.example.desktopclient.service.game.GameService;
import org.example.desktopclient.util.DownloadTask;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class GameInLibraryActionButtonController {

    private GameInLibraryActionButtonComponent component;
    private GameInLibraryButtonType type;
    private Integer gameId;
    private Integer userId;
    private GameService gameService;
    private ApplicationContextService applicationContextService;

    public GameInLibraryActionButtonController(GameInLibraryActionButtonComponent component) {
        this.component = component;
        gameService = new GameService();
    }

    public void handlePlayButton(String executablePath, UserGameInCollectionDetailsController userGameInCollectionDetailsController) {
        component.getActionButton().setOnMouseClicked(e -> {

            Task<Void> task = new Task<>() {
                @Override
                protected Void call() {

                    gameService.enterGame(userId, gameId, message -> {

                        if (message.isBlank()) {
                            try {
                                Process process = new ProcessBuilder(executablePath).start();
                                Platform.runLater(() -> setType(GameInLibraryButtonType.PLAYING));
                                System.out.println(gameId);
                                userGameInCollectionDetailsController.setRunningGameId(gameId);
                                applicationContextService.setRunningGameId(gameId);
                                System.out.println("Application started: " + executablePath);

                                long startTime = System.currentTimeMillis(); // Početak merenja


                                int exitCode = 0; // Čeka da se igra zatvori
                                try {

                                    exitCode = process.waitFor();
                                    gameService.exitGame(userId, c -> {
                                        Platform.runLater(() -> {

                                            // Vraćanje dugmeta u PLAY stanje na JavaFX niti
                                            userGameInCollectionDetailsController.setRunningGameId(null);
                                            applicationContextService.setRunningGameId(null);
                                            setType(GameInLibraryButtonType.PLAY);
                                            long elapsedTime = System.currentTimeMillis() - startTime; // Izračunaj proteklo vreme
                                            System.out.println(elapsedTime);
                                            if (elapsedTime > 1000)
                                                gameService.updateGamePlaytime(userId, gameId, elapsedTime, LocalDateTime.now(), c2 -> {
                                                });


                                        });
                                    });

                                } catch (InterruptedException ex) {
                                    gameService.exitGame(userId, c -> {

                                        Platform.runLater(() -> {
                                            setType(GameInLibraryButtonType.PLAY);
                                            long elapsedTime = System.currentTimeMillis() - startTime; // Izračunaj proteklo vreme
                                            if (elapsedTime > 1000)
                                                gameService.updateGamePlaytime(userId, gameId, elapsedTime, LocalDateTime.now(), c2 -> {
                                                });


                                        });
                                    });
                                }
                            } catch (IOException ex) {
                                System.err.println("Failed to start application: " + ex.getMessage());
                                gameService.exitGame(userId, c -> {
                                    Platform.runLater(() -> setType(GameInLibraryButtonType.PLAY));

                                });
                            }

                        } else {
                            Platform.runLater(() -> showAlert(message));

                        }
                    });

                    return null;
                }
            };

            new Thread(task).start(); // Pokreće task u pozadinskoj niti
        });
    }


    public void handleDownloadButton() {
        component.getActionButton().setOnMouseClicked(e -> {

            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Choose installation directory");

            // Opciono: postavljanje početnog direktorijuma
            directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

            File selectedDirectory = directoryChooser.showDialog(applicationContextService.getPrimaryStage());

            if (selectedDirectory != null) {
                gameService.fetchGameDownloadURL(gameId, downloadUrl -> {
                    Platform.runLater(() -> {
                        this.setType(GameInLibraryButtonType.DOWNLOADING);
                    });

                    String folderPath = selectedDirectory.getAbsolutePath();
                    DownloadTask downloadTask = new DownloadTask(downloadUrl, folderPath);

                    component.getProgressBar().progressProperty().bind(downloadTask.progressProperty());

                    downloadTask.setOnSucceeded(event -> {
                        Platform.runLater(() -> {
                            this.setType(GameInLibraryButtonType.INSTALLING);
                        });
                    });

                    Thread thread = new Thread(downloadTask);
                    thread.setDaemon(true);
                    thread.start();
                });
                // Ovde možeš sačuvati putanju i koristiti je za instalaciju igre
            }

        });
    }

    public void showAlert(String message) {
        Stage alertStage = new Stage();
        alertStage.initStyle(StageStyle.UNDECORATED); // Uklanja naslovnu traku
        alertStage.initModality(Modality.APPLICATION_MODAL); // Blokira interakciju sa glavnim prozorom dok je alert otvoren

        // Tekst poruke
        Label alertText = new Label(message);
        alertText.setStyle("-fx-font-size: 25px;-fx-text-fill: white");

        // Dugme za zatvaranje
        Button closeButton = new Button("OK");
        closeButton.setStyle("-fx-background-color: #0084FF;-fx-text-fill: white;-fx-cursor:hand;-fx-font-size:14px;-fx-padding: 5 14 5 14;-fx-font-weight:700");
        closeButton.setOnAction(ec -> alertStage.close());

        // Pravljenje layout-a
        VBox alertLayout = new VBox(10, alertText, closeButton);
        alertLayout.setAlignment(Pos.CENTER);
        alertLayout.setStyle("-fx-background-color: #191B2E;-fx-border-color:#333352;-fx-border-width: 2px; -fx-padding: 25px 50px 25px 50px;");

        Scene alertScene = new Scene(alertLayout);
        alertScene.setFill(Color.TRANSPARENT); // Ako želiš prozirnu pozadinu

        alertStage.setScene(alertScene);
        alertStage.showAndWait();
    }


    public GameInLibraryActionButtonComponent getComponent() {
        return component;
    }

    public void setComponent(GameInLibraryActionButtonComponent component) {
        this.component = component;
    }

    public GameInLibraryButtonType getType() {
        return type;
    }

    public void setType(GameInLibraryButtonType type) {
        this.type = type;

        switch (type) {
            case PLAY:
                component.getActionButton().setText("Play");
                component.getActionButton().setDisable(false);
                if(component.getComponent().getChildren().size() == 2)
                    component.getComponent().getChildren().remove(component.getProgressBar());

                break;
            case PLAYING:
                component.getActionButton().setText("Playing");
                component.getActionButton().setDisable(true);
                if(component.getComponent().getChildren().size() == 2)
                    component.getComponent().getChildren().remove(component.getProgressBar());

                break;
            case DOWNLOAD:
                component.getActionButton().setText("Download");
                component.getActionButton().setDisable(false);
                if(component.getComponent().getChildren().size() == 2)
                    component.getComponent().getChildren().remove(component.getProgressBar());

                break;
            case DOWNLOADING:
                component.getActionButton().setText("Downloading");
                component.getActionButton().setDisable(true);
                component.getComponent().getChildren().add(component.getProgressBar());
                break;
            case INSTALLING:
                component.getActionButton().setText("Installing");
                component.getActionButton().setDisable(true);
                if(component.getComponent().getChildren().size() == 2)
                    component.getComponent().getChildren().remove(component.getProgressBar());

                break;
            default:
                break;
        }

    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setApplicationContextService(ApplicationContextService applicationContextService) {
        this.applicationContextService = applicationContextService;
    }

}

