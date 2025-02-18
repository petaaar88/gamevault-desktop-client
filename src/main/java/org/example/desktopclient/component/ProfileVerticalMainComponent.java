package org.example.desktopclient.component;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Collection;

public class ProfileVerticalMainComponent extends VerticalMainComponent {

    private ProfileDescriptionComponent profileDescriptionComponent;
    private RecentActivityComponent recentActivityComponent;

    public ProfileVerticalMainComponent() {
        this.setup();

        profileDescriptionComponent = new ProfileDescriptionComponent();
        recentActivityComponent = new RecentActivityComponent();

        HBox hBox = new HBox(recentActivityComponent.getComponent());

        HBox.setHgrow(recentActivityComponent.getComponent(), Priority.ALWAYS);

        VBox mainContentVbox = new VBox(profileDescriptionComponent.getComponent(),hBox);
        mainContentVbox.setSpacing(20);
        mainContentVbox.setMinWidth(1000);
        mainContentVbox.setMaxWidth(1000);


        Collection<Node> elements = Arrays.asList(mainContentVbox);

        this.addElements(elements);
    }

    @Override
    public VBox getComponent() {
        return layout;
    }

    public ProfileDescriptionComponent getProfileDescriptionComponent() {
        return profileDescriptionComponent;
    }

    public void setProfileDescriptionComponent(ProfileDescriptionComponent profileDescriptionComponent) {
        this.profileDescriptionComponent = profileDescriptionComponent;
    }

    public RecentActivityComponent getRecentActivityComponent() {
        return recentActivityComponent;
    }

    public void setRecentActivityComponent(RecentActivityComponent recentActivityComponent) {
        this.recentActivityComponent = recentActivityComponent;
    }
}
