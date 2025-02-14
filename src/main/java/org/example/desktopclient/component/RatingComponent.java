package org.example.desktopclient.component;

import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.List;

public class RatingComponent {

    private List<RatingButtonComponent> buttons;
    private HBox layout;

    public RatingComponent() {
        buttons = new ArrayList<>();
        layout = new HBox();
        layout.setSpacing(1);

    }

    public HBox getComponent() {
        return layout;
    }


    public List<RatingButtonComponent> getButtons() {
        return buttons;
    }

    public void setButtons(List<RatingButtonComponent> buttons) {
        this.buttons = buttons;
    }

    public HBox getLayout() {
        return layout;
    }

    public void setLayout(HBox layout) {
        this.layout = layout;
    }
}
