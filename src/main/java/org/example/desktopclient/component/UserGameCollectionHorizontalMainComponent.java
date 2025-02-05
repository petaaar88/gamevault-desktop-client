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
    @Override
    public HBox getComponent() {
        this.setup();

        layout.setSpacing(17);
        layout.setPadding(new Insets(20,0,20,0));

        UserGameInCollectionDetailsComponent userGameInCollectionDetailsComponent = new UserGameInCollectionDetailsComponent();
        UserGameInCollectionDetailsController userGameInCollectionDetailsController = new UserGameInCollectionDetailsController(userGameInCollectionDetailsComponent);

        UsersGamesCollectionComponent usersGamesCollectionComponent = new UsersGamesCollectionComponent();
        UsersGamesCollectionController usersGamesCollectionController = new UsersGamesCollectionController(usersGamesCollectionComponent, userGameInCollectionDetailsController);

        Collection<Node> elements = Arrays.asList(usersGamesCollectionComponent.getComponent(), userGameInCollectionDetailsComponent.getComponent());
        this.addElements(elements);

        return layout;
    }
}
