package org.example.desktopclient.controller;

import org.example.desktopclient.component.SearchComponent;

public class SearchController {
    private SearchComponent searchComponent;
    private ISearchable searchableController;

    public SearchController(SearchComponent searchComponent) {
        this.searchComponent = searchComponent;
        this.handleClick();
    }

    public void handleClick() {
        searchComponent.getButton().setOnMouseClicked(e -> {
            String searchText = searchComponent.getTextField().getText().trim();
            searchComponent.getTextField().setText("");
            searchableController.search(searchText);
        });

        searchComponent.getTextField().setOnAction(event -> {
            String searchText = searchComponent.getTextField().getText().trim();
            searchComponent.getTextField().setText("");

            searchableController.search(searchText);
        });
    }

    public void setSearchableController(ISearchable searchableController) {
        this.searchableController = searchableController;
    }

    public ISearchable getSearchableController() {
        return searchableController;
    }
}
