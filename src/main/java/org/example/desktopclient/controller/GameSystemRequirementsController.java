package org.example.desktopclient.controller;

import javafx.application.Platform;
import org.example.desktopclient.component.GameSystemRequirementsComponent;
import org.example.desktopclient.model.game.SingleGameSystemRequirementsDTO;
import org.example.desktopclient.service.game.GameService;

public class GameSystemRequirementsController {
    private GameSystemRequirementsComponent component;
    private Integer gameId;
    private GameService gameService;

    public GameSystemRequirementsController(GameSystemRequirementsComponent component) {
        this.component = component;
        this.gameService = new GameService();
    }

    public void setContent(){
        gameService.fetchSystemRequirements(gameId, gameSystemRequirementsDTO -> {
            Platform.runLater(()->{
                component.getMinimumSingleGameSystemRequirementsController().getComonent().getTitle().setText("Minimum");
                component.getRecommendedSingleGameSystemRequirementsController().getComonent().getTitle().setText("Recommended");
                this.setContent(gameSystemRequirementsDTO.getMinimum(),component.getMinimumSingleGameSystemRequirementsController());
                this.setContent(gameSystemRequirementsDTO.getRecommended(),component.getRecommendedSingleGameSystemRequirementsController());
            });

        });

    }

    private void setContent(SingleGameSystemRequirementsDTO singleGameSystemRequirementsDTO, SingleGameSystemRequirementsController singleGameSystemRequirementsController){
        singleGameSystemRequirementsController.getComonent().getCpuLabel().setText(singleGameSystemRequirementsDTO.getCpu());
        singleGameSystemRequirementsController.getComonent().getGpuLabel().setText(singleGameSystemRequirementsDTO.getGpu());
        singleGameSystemRequirementsController.getComonent().getOsLabel().setText(singleGameSystemRequirementsDTO.getOperatingSystem());
        singleGameSystemRequirementsController.getComonent().getRamLabel().setText(singleGameSystemRequirementsDTO.getRam().toString() + " MB");
        singleGameSystemRequirementsController.getComonent().getStorageLabel().setText(singleGameSystemRequirementsDTO.getStorage().toString() +" MB");
        singleGameSystemRequirementsController.getComonent().getExprectedStorageLabel().setText(singleGameSystemRequirementsDTO.getExpectedStorage().toString() + " MB");
    }

    public GameSystemRequirementsComponent getComponent() {
        return component;
    }

    public void setComponent(GameSystemRequirementsComponent component) {
        this.component = component;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
