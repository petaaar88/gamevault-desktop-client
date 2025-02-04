package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Collection;

public class GameProductPageVerticalMainComponent extends VerticalMainComponent{

    public GameProductPageVerticalMainComponent() {
    }

    @Override
    public VBox getComponent() {

        this.setup();

        GameDescriptionComponent gameDescriptionComponent = new GameDescriptionComponent();

        HBox systemRequirementAndFriendsHBox = new HBox();
        systemRequirementAndFriendsHBox.setSpacing(24);
        systemRequirementAndFriendsHBox.setPadding(new Insets(20,0,0,0));
        systemRequirementAndFriendsHBox.setMinWidth(1000);
        systemRequirementAndFriendsHBox.setMaxWidth(1000);

        DownloadGameComponent downloadGameComponent = new DownloadGameComponent();
        GameSystemRequirements gameSystemRequirements = new GameSystemRequirements();
        TextInputComponent textInputComponent = new TextInputComponent();

        VBox vBox = new VBox(downloadGameComponent.getComponent("Red Dead Redemption 2","Http://nlse.com"),gameSystemRequirements.getComponent(),textInputComponent.getWithRatingComponent());
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(0,0,20,0));


        systemRequirementAndFriendsHBox.getChildren().add(vBox);

        FriendsThatPlayGameComponent friendsThatPlayGameComponent = new FriendsThatPlayGameComponent();
        systemRequirementAndFriendsHBox.getChildren().add(friendsThatPlayGameComponent.getComponent());

        CustomerReviewsComponent customerReviewsComponent = new CustomerReviewsComponent();
        HBox paddingHbox = new HBox(customerReviewsComponent.getComponent());
        paddingHbox.setMinWidth(1000);
        paddingHbox.setMaxWidth(1000);
        paddingHbox.setPadding(new Insets(0,0,20,0));

        Collection<Node> elements = Arrays.asList(gameDescriptionComponent.getComponent(), systemRequirementAndFriendsHBox,paddingHbox);
        this.addElements(elements);

        return layout;
    }
}
