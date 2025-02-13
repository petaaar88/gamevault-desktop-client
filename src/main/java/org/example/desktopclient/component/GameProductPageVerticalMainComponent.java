package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.desktopclient.controller.GameDescriptionController;
import org.example.desktopclient.controller.GetGameController;

import java.util.Arrays;
import java.util.Collection;

public class GameProductPageVerticalMainComponent extends VerticalMainComponent {

    private GameDescriptionController gameDescriptionController;
    private GameDescriptionComponent gameDescriptionComponent;
    private GetGameComponent getGameComponent;
    private GetGameController getGameController;

    public GameProductPageVerticalMainComponent() {
        gameDescriptionComponent = new GameDescriptionComponent();
        gameDescriptionController = new GameDescriptionController(gameDescriptionComponent);
        getGameComponent = new GetGameComponent();
        getGameController = new GetGameController(getGameComponent);

    }

    @Override
    public VBox getComponent() {

        this.setup();


        HBox systemRequirementAndFriendsHBox = new HBox();
        systemRequirementAndFriendsHBox.setSpacing(24);
        systemRequirementAndFriendsHBox.setPadding(new Insets(20, 0, 0, 0));
        systemRequirementAndFriendsHBox.setMinWidth(1000);
        systemRequirementAndFriendsHBox.setMaxWidth(1000);


        GameSystemRequirements gameSystemRequirements = new GameSystemRequirements();
        TextInputComponent textInputComponent = new TextInputComponent();

        VBox vBox = new VBox(getGameComponent.getComponent("Red Dead Redemption 2", "Http://nlse.com"), gameSystemRequirements.getComponent(), textInputComponent.getWithRatingComponent());
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(0, 0, 20, 0));


        systemRequirementAndFriendsHBox.getChildren().add(vBox);

        FriendsThatPlayGameComponent friendsThatPlayGameComponent = new FriendsThatPlayGameComponent();
        systemRequirementAndFriendsHBox.getChildren().add(friendsThatPlayGameComponent.getComponent());

        CustomerReviewsComponent customerReviewsComponent = new CustomerReviewsComponent();
        HBox paddingHbox = new HBox(customerReviewsComponent.getComponent());
        paddingHbox.setMinWidth(1000);
        paddingHbox.setMaxWidth(1000);
        paddingHbox.setPadding(new Insets(0, 0, 20, 0));

        Collection<Node> elements = Arrays.asList(gameDescriptionComponent.getComponent(), systemRequirementAndFriendsHBox, paddingHbox);
        this.addElements(elements);

        return layout;
    }

    public GameDescriptionController getGameDescriptionController() {
        return gameDescriptionController;
    }

    public void setGameDescriptionController(GameDescriptionController gameDescriptionController) {
        this.gameDescriptionController = gameDescriptionController;
    }

    public GetGameComponent getGetGameComponent() {
        return getGameComponent;
    }

    public void setGetGameComponent(GetGameComponent getGameComponent) {
        this.getGameComponent = getGameComponent;
    }

    public GetGameController getGetGameController() {
        return getGameController;
    }

    public void setGetGameController(GetGameController getGameController) {
        this.getGameController = getGameController;
    }
}
