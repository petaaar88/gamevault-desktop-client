package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.UserGameInCollectionDetailsComponent;
import org.example.desktopclient.model.game.GameInLibraryButtonType;
import org.example.desktopclient.model.game.GameInstallationData;
import org.example.desktopclient.service.ApplicationContextService;
import org.example.desktopclient.service.game.GameService;

import java.util.Objects;

public class UserGameInCollectionDetailsController {

    private UserGameInCollectionDetailsComponent component;
    private GameService gameService;
    private Integer runningGameId;
    private Integer userId;
    private GameInLibraryActionButtonController gameInLibraryActionButtonController;
    private GameInstallationData gameInstallationData;
    private ApplicationContextService applicationContextService;

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

    public void initialize() {


        gameService.fetchUserGameCollection(userId, games -> {
            Platform.runLater(() -> {
                gameInLibraryActionButtonController.setGameId(games.getFirst().getId());
                this.changeGame(games.getFirst().getId());
                if(runningGameId == games.getFirst().getId()) {
                    gameInLibraryActionButtonController.setType(GameInLibraryButtonType.PLAYING);
                }

            });
        });
    }


    public void changeGame(Integer newGameId) {

        //TODO: ovde se menja stanje dugmeta
        gameService.fetchGameInUserCollection(userId, newGameId, game -> {
            Platform.runLater(() -> {
                if (!Objects.isNull(gameInstallationData)) {
                    if (gameInstallationData.getGame_id() == newGameId) {
                        if (applicationContextService.getRunningGameId() != newGameId) {
                            gameInLibraryActionButtonController.setType(GameInLibraryButtonType.PLAY);
                            gameInLibraryActionButtonController.handlePlayButton(gameInstallationData.getGame_executable(), this);
                        }
                        else if(applicationContextService.getRunningGameId() == newGameId)
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
