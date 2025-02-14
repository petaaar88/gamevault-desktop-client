package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.desktopclient.controller.FriendsThatPlayGameController;
import org.example.desktopclient.controller.GameDescriptionController;
import org.example.desktopclient.controller.GameSystemRequirementsController;
import org.example.desktopclient.controller.GetGameController;

import java.util.Arrays;
import java.util.Collection;

public class GameProductPageVerticalMainComponent extends VerticalMainComponent {

    private GameDescriptionController gameDescriptionController;
    private GameDescriptionComponent gameDescriptionComponent;
    private GameSystemRequirementsComponent gameSystemRequirementsComponent;
    private GameSystemRequirementsController gameSystemRequirementsController;
    private VBox requirementsGettingAndReviewVbox;
    private FriendsThatPlayGameComponent friendsThatPlayGameComponent;
    private FriendsThatPlayGameController friendsThatPlayGameController;

    public GameProductPageVerticalMainComponent() {
        gameDescriptionComponent = new GameDescriptionComponent();
        gameDescriptionController = new GameDescriptionController(gameDescriptionComponent);


        gameSystemRequirementsComponent = new GameSystemRequirementsComponent();
        gameSystemRequirementsController = new GameSystemRequirementsController(gameSystemRequirementsComponent);

        friendsThatPlayGameComponent = new FriendsThatPlayGameComponent();
        friendsThatPlayGameComponent.getComponent().setVisible(false);
        friendsThatPlayGameController = new FriendsThatPlayGameController(friendsThatPlayGameComponent);

    }

    @Override
    public VBox getComponent() {

        this.setup();


        HBox systemRequirementAndFriendsHBox = new HBox();
        systemRequirementAndFriendsHBox.setSpacing(24);
        systemRequirementAndFriendsHBox.setPadding(new Insets(20, 0, 0, 0));
        systemRequirementAndFriendsHBox.setMinWidth(1000);
        systemRequirementAndFriendsHBox.setMaxWidth(1000);


        requirementsGettingAndReviewVbox = new VBox(gameSystemRequirementsComponent.getComponent());
        requirementsGettingAndReviewVbox.setSpacing(20);
        requirementsGettingAndReviewVbox.setPadding(new Insets(0, 0, 20, 0));

        systemRequirementAndFriendsHBox.getChildren().add(requirementsGettingAndReviewVbox);

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


    public GameSystemRequirementsController getGameSystemRequirementsController() {
        return gameSystemRequirementsController;
    }

    public void setGameSystemRequirementsController(GameSystemRequirementsController gameSystemRequirementsController) {
        this.gameSystemRequirementsController = gameSystemRequirementsController;
    }

    public GameSystemRequirementsComponent getGameSystemRequirementsComponent() {
        return gameSystemRequirementsComponent;
    }

    public void setGameSystemRequirementsComponent(GameSystemRequirementsComponent gameSystemRequirementsComponent) {
        this.gameSystemRequirementsComponent = gameSystemRequirementsComponent;
    }

    public VBox getRequirementsGettingAndReviewVbox() {
        return requirementsGettingAndReviewVbox;
    }

    public void setRequirementsGettingAndReviewVbox(VBox requirementsGettingAndReviewVbox) {
        this.requirementsGettingAndReviewVbox = requirementsGettingAndReviewVbox;
    }

    public FriendsThatPlayGameComponent getFriendsThatPlayGameComponent() {
        return friendsThatPlayGameComponent;
    }

    public void setFriendsThatPlayGameComponent(FriendsThatPlayGameComponent friendsThatPlayGameComponent) {
        this.friendsThatPlayGameComponent = friendsThatPlayGameComponent;
    }

    public GameDescriptionComponent getGameDescriptionComponent() {
        return gameDescriptionComponent;
    }

    public void setGameDescriptionComponent(GameDescriptionComponent gameDescriptionComponent) {
        this.gameDescriptionComponent = gameDescriptionComponent;
    }

    public FriendsThatPlayGameController getFriendsThatPlayGameController() {
        return friendsThatPlayGameController;
    }

    public void setFriendsThatPlayGameController(FriendsThatPlayGameController friendsThatPlayGameController) {
        this.friendsThatPlayGameController = friendsThatPlayGameController;
    }
}
