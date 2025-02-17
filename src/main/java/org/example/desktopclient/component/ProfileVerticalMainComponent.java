package org.example.desktopclient.component;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Collection;

public class ProfileVerticalMainComponent extends VerticalMainComponent {

    private ProfileDescriptionComponent profileDescriptionComponent;

    public ProfileVerticalMainComponent() {
        this.setup();

        profileDescriptionComponent = new ProfileDescriptionComponent();
        VBox mainContentVbox = new VBox(profileDescriptionComponent.getComponent());
        mainContentVbox.setSpacing(30);
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
}
