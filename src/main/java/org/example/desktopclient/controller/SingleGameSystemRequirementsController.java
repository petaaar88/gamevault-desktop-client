package org.example.desktopclient.controller;

import org.example.desktopclient.component.SingleGameSystemRequirements;

public class SingleGameSystemRequirementsController {
    private SingleGameSystemRequirements comonent;

    public SingleGameSystemRequirementsController(SingleGameSystemRequirements comonent) {
        this.comonent = comonent;
    }

    public SingleGameSystemRequirements getComonent() {
        return comonent;
    }

    public void setComonent(SingleGameSystemRequirements comonent) {
        this.comonent = comonent;
    }
}
