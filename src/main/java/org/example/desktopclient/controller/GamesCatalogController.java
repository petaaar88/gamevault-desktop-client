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

public class GamesCatalogController implements ISearchable, IPaginable {

    private GamesCatalogVerticalMainComponent component;
    private SearchController searchController;
    private GameService gameService;
    private final Integer LIMIT = 6;
    private final Integer COLUMNS_PER_ROW = 3;
    private String gameTitle;
    private Integer currentPage = 1;

    public GamesCatalogController(GamesCatalogVerticalMainComponent component, SearchController searchController) {
        this.component = component;
        this.searchController = searchController;
        gameService = new GameService();

    }

    public void setContent(String title) {
        Text loadingText = new Text("Loading...");
        loadingText.setStyle("-fx-fill: #575C96;-fx-font-size: 24px;-fx-font-weight: 700;-fx-padding: 350;");

        gameTitle = title;

        component.getGridPane().getChildren().clear();
        component.getGridPane().add(loadingText, 1, 0);
        component.getPaginationComponent().getCompoenent().setVisible(false);

        gameService.fetchGames(currentPage, LIMIT, title, pages -> {
            Platform.runLater(() -> {
                        if (pages != null) {
                            List<GameOverview> games = pages.getResoult();
                            component.getGridPane().getChildren().clear();

                            if (games.size() != 0) {
                                int col = 0;
                                int row = 0;

                                /////////////////////////////////////////////////////////////////////

                                this.setupPagination(pages);

                                ////////////////////////////////////////////////////////////////////


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
                            } else {
                                Text noGameFound = new Text("Game Not Found");
                                noGameFound.setStyle("-fx-fill: #575C96;-fx-font-size: 24px;-fx-font-weight: 700;-fx-padding: 350;");

                                component.getGridPane().add(noGameFound, 1, 0);
                            }
                        } else {
                            //TODO: dodaj text
                            System.out.println("No games provided");
                        }

                    }
            );
        });


    }

    private void setupPagination(Pages<GameOverview> pages){
        component.getPaginationComponent().getPagesHbox().getChildren().clear();

        if (pages.getPreviousPages().isEmpty() && pages.getNextPages().isEmpty()) {
            component.getPaginationComponent().getCompoenent().setVisible(false);
        } else
            component.getPaginationComponent().getCompoenent().setVisible(true);


        if (pages.getPreviousPages().isEmpty())
            component.getPaginationComponent().getLeftArrow().setVisible(false);
        else
            component.getPaginationComponent().getLeftArrow().setVisible(true);

        if (pages.getNextPages().isEmpty())
            component.getPaginationComponent().getRightArrow().setVisible(false);
        else
            component.getPaginationComponent().getRightArrow().setVisible(true);

        if (pages.getPreviousPages().isEmpty()) {
            component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
            if(!pages.getNextPages().isEmpty()){
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(pages.getNextPages().get(0).getPage().toString()));

                if (pages.getNextPages().size() >= 2) {
                    Integer rightPageNumber = pages.getNextPages().get(1).getPage();
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(rightPageNumber.toString()));

                }

            }
        }
        else{
            if(!pages.getPreviousPages().isEmpty() && !pages.getNextPages().isEmpty()){
                Integer previousPageNumber = pages.getPreviousPages().getLast().getPage();
                Integer nextPageNumber = pages.getNextPages().getFirst().getPage();
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(previousPageNumber.toString()));
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(nextPageNumber.toString()));
            }
            else if(pages.getNextPages().isEmpty()){
                if(pages.getPreviousPages().size() >=2){
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getLeftPageNumberButton(pages.getPreviousPages().getFirst().getPage().toString()));
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(pages.getPreviousPages().getLast().getPage().toString()));
                }
                else
                    component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getRightPageNumberButton(pages.getPreviousPages().getLast().getPage().toString()));


                component.getPaginationComponent().getPagesHbox().getChildren().add(component.getPaginationComponent().getCurrentPageNumberButton(currentPage.toString()));
            }
        }
    }

    @Override
    public void search(String text) {
        currentPage = 1;
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

    @Override
    public void nextPage() {
        currentPage++;
        setContent(gameTitle);
    }

    @Override
    public void previousPage() {
        currentPage--;
        setContent(gameTitle);
    }

    @Override
    public void page(int page) {
        currentPage = page;
        setContent(gameTitle);
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
