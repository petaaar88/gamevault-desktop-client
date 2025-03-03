package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.example.desktopclient.controller.UserGameInCollectionDetailsController;
import org.example.desktopclient.controller.UsersGamesCollectionController;

import java.util.Arrays;
import java.util.Collection;

public class UserGameCollectionHorizontalMainComponent extends HorizontalMainComponent{

    private UserGameInCollectionDetailsComponent userGameInCollectionDetailsComponent;
    private UsersGamesCollectionComponent usersGamesCollectionComponent;

    public UserGameCollectionHorizontalMainComponent() {
        this.setup();

        layout.setSpacing(17);
        layout.setPadding(new Insets(20,0,0,0));

        userGameInCollectionDetailsComponent = new UserGameInCollectionDetailsComponent();

        usersGamesCollectionComponent = new UsersGamesCollectionComponent();

        Collection<Node> elements = Arrays.asList(usersGamesCollectionComponent.getComponent(), userGameInCollectionDetailsComponent.getComponent());
        this.addElements(elements);

    }

    @Override
    public HBox getComponent() {
        return layout;
    }

    public UserGameInCollectionDetailsComponent getUserGameInCollectionDetailsComponent() {
        return userGameInCollectionDetailsComponent;
    }

    public void setUserGameInCollectionDetailsComponent(UserGameInCollectionDetailsComponent userGameInCollectionDetailsComponent) {
        this.userGameInCollectionDetailsComponent = userGameInCollectionDetailsComponent;
    }

    public UsersGamesCollectionComponent getUsersGamesCollectionComponent() {
        return usersGamesCollectionComponent;
    }

    public void setUsersGamesCollectionComponent(UsersGamesCollectionComponent usersGamesCollectionComponent) {
        this.usersGamesCollectionComponent = usersGamesCollectionComponent;
    }
}
