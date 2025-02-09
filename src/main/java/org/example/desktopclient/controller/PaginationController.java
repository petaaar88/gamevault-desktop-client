package org.example.desktopclient.controller;

import org.example.desktopclient.component.PaginationComponent;

public class PaginationController {
    private PaginationComponent component;
    private IPaginable paginableController;

    public PaginationController(PaginationComponent component) {
        this.component = component;
        this.handleClick();
    }

    public PaginationComponent getComponent() {
        return component;
    }
    public void setComponent(PaginationComponent component) {
        this.component = component;
    }

    public void handleClick(){
        component.getLeftArrow().setOnMouseClicked(e->{
            paginableController.previousPage();
        });

        component.getRightArrow().setOnMouseClicked(e->{
            paginableController.nextPage();
        });
    }

    public IPaginable getPaginableController() {
        return paginableController;
    }

    public void setPaginableController(IPaginable paginableController) {
        this.paginableController = paginableController;
    }
}
