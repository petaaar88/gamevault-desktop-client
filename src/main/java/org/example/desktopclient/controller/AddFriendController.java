package org.example.desktopclient.controller;

import org.example.desktopclient.component.AddFriendComponent;
import org.example.desktopclient.service.game.GameService;

public class AddFriendController implements ISearchable {
    private AddFriendComponent component;
    private Integer userId;
    private SearchController searchController;


    public AddFriendController(AddFriendComponent component) {
        this.component = component;
        searchController = new SearchController(this.component.getSearchComponent());
        searchController.setSearchableController(this);


    }

    @Override
    public void search(String text) {
        System.out.println(text);
    }

    public AddFriendComponent getComponent() {
        return component;
    }

    public void setComponent(AddFriendComponent component) {
        this.component = component;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
