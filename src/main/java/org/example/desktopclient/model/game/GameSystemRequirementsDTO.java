package org.example.desktopclient.model.game;

public class GameSystemRequirementsDTO {
    SingleGameSystemRequirementsDTO minimum;
    SingleGameSystemRequirementsDTO recommended;

    public GameSystemRequirementsDTO() {
    }

    public GameSystemRequirementsDTO(SingleGameSystemRequirementsDTO recommended, SingleGameSystemRequirementsDTO minimum) {
        this.recommended = recommended;
        this.minimum = minimum;
    }

    public SingleGameSystemRequirementsDTO getMinimum() {
        return minimum;
    }

    public void setMinimum(SingleGameSystemRequirementsDTO minimum) {
        this.minimum = minimum;
    }

    public SingleGameSystemRequirementsDTO getRecommended() {
        return recommended;
    }

    public void setRecommended(SingleGameSystemRequirementsDTO recommended) {
        this.recommended = recommended;
    }
}
