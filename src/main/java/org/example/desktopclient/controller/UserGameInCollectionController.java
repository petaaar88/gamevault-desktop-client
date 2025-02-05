package org.example.desktopclient.controller;

import org.example.desktopclient.component.UserGameInCollectionComponent;

public class UserGameInCollectionController {
    private Integer gameId;
    private boolean isSelected;
    private UserGameInCollectionComponent component;
    private UsersGamesCollectionController usersGamesCollectionController;

    public UserGameInCollectionController(Integer gameId, UserGameInCollectionComponent component, UsersGamesCollectionController usersGamesCollectionController) {
        this.component = component;
        this.gameId = gameId;
        this.usersGamesCollectionController = usersGamesCollectionController;
        isSelected = false;

        this.handleButtonClick();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        if(selected)
            component.setButtonSelected();
        else
            component.setButtonDeselected();
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public void handleButtonClick(){
        component.getSelectionButton().setOnMouseClicked(e->{
            usersGamesCollectionController.changeGame(this);
        });
    }

}
