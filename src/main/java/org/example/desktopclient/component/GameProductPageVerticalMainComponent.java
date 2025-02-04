package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

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


        systemRequirementAndFriendsHBox.getChildren().add(vBox);

        FriendsThatPlayGameComponent friendsThatPlayGameComponent = new FriendsThatPlayGameComponent();
        systemRequirementAndFriendsHBox.getChildren().add(friendsThatPlayGameComponent.getComponent());



        Collection<Node> elements = Arrays.asList(gameDescriptionComponent.getComponent(), systemRequirementAndFriendsHBox);
        this.addElements(elements);

        return layout;
    }
}
