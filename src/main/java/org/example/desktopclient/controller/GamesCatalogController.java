package org.example.desktopclient.controller;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.example.desktopclient.component.CatalogGameComponent;
import org.example.desktopclient.component.GamesCatalogVerticalMainComponent;
import org.example.desktopclient.model.game.GameOverview;
import org.example.desktopclient.model.page.Pages;
import org.example.desktopclient.service.game.GameService;

import java.util.List;

public class GamesCatalogController implements ISearchable {

    private GamesCatalogVerticalMainComponent component;
    private SearchController searchController;
    private GameService gameService;
    private final Integer LIMIT = 6;
    private final Integer COLUMNS_PER_ROW = 3;

    public GamesCatalogController(GamesCatalogVerticalMainComponent component, SearchController searchController) {
        this.component = component;
        this.searchController = searchController;
        gameService = new GameService();

    }

    public void setContent(String title) {
        Text loadingText = new Text("Loading...");
        loadingText.setStyle("-fx-fill: #575C96;-fx-font-size: 24px;-fx-font-weight: 700;-fx-padding: 350;");

        component.getGridPane().getChildren().clear();
        component.getGridPane().add(loadingText, 1, 0);
        component.getPaginationComponent().getCompoenent().setVisible(false);

        gameService.fetchGames(1, LIMIT,title, pages -> {
            Platform.runLater(() -> {
                        if (pages != null) {
                            List<GameOverview> games = pages.getResoult();
                            component.getGridPane().getChildren().clear();

                            if(games.size() != 0) {
                                int col = 0;
                                int row = 0;
                                component.getPaginationComponent().getCompoenent().setVisible(true);

                                for (int i = 1; i <= games.size(); i++) {
                                    CatalogGameComponent catalogGameComponent = new CatalogGameComponent();
                                    CatalogGameController catalogGameController = new CatalogGameController(catalogGameComponent);

                                    catalogGameComponent.setContent(games.get(i - 1));
                                    catalogGameController.setGameId(games.get(i - 1).getId());

                                    component.getGridPane().add(catalogGameController.getComponent().getComponent(), col, row);

                                    col++; // Pomeramo kolonu
                                    if (col == COLUMNS_PER_ROW) { // Ako smo dodali 3 elementa, pređemo u novi red
                                        col = 0;
                                        row++;
                                    }

                                }
                            }
                            else{
                                Text noGameFound = new Text("Game Not Found");
                                noGameFound.setStyle("-fx-fill: #575C96;-fx-font-size: 24px;-fx-font-weight: 700;-fx-padding: 350;");

                                component.getGridPane().add(noGameFound,1,0);
                            }
                        } else {
                            //TODO: dodaj text
                            System.out.println("No games provided");
                        }

                    }
            );
        });


    }
    @Override
    public void search(String text) {
        this.setContent(text);
    }

    public SearchController getSearchController() {
        return searchController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public GamesCatalogVerticalMainComponent getComponent() {
        return component;
    }

    public void setComponent(GamesCatalogVerticalMainComponent component) {
        this.component = component;
    }
}
