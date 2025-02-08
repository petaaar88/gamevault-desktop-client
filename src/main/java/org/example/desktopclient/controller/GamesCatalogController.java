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

public class GamesCatalogController {

    private GamesCatalogVerticalMainComponent component;
    private GameService gameService;
    private final Integer LIMIT = 6;
    private final Integer COLUMNS_PER_ROW = 3;

    public GamesCatalogController(GamesCatalogVerticalMainComponent component) {
        this.component = component;
        gameService = new GameService();

    }

    public void setContent() {
        Text loadingText = new Text("Loading...");
        loadingText.setStyle("-fx-fill: #575C96;-fx-font-size: 24px;-fx-font-weight: 700;-fx-padding: 350;");



        ImageView imageView = new ImageView(new Image(getClass().getResource("/org/example/desktopclient/icons/loadingSpinner.gif").toExternalForm()));
        // Timer za osvežavanje prikaza

        component.getGridPane().add(loadingText, 1, 0);
        component.getPaginationComponent().getCompoenent().setVisible(false);



        gameService.fetchGames(1, LIMIT, pages -> {
            Platform.runLater(() -> {
                        if (pages != null) {
                            List<GameOverview> games = pages.getResoult();
                            int col = 0;
                            int row = 0;
                            component.getGridPane().getChildren().clear();
                            component.getPaginationComponent().getCompoenent().setVisible(true);

                            for (int i = 1; i <= games.size(); i++) {
                                CatalogGameComponent catalogGameComponent = new CatalogGameComponent();
                                CatalogGameController catalogGameController = new CatalogGameController(catalogGameComponent);

                                catalogGameComponent.setContent(games.get(i-1));
                                catalogGameController.setGameId(games.get(i-1).getId());

                                component.getGridPane().add(catalogGameController.getComponent().getComponent(), col, row);

                                col++; // Pomeramo kolonu
                                if (col == COLUMNS_PER_ROW) { // Ako smo dodali 3 elementa, pređemo u novi red
                                    col = 0;
                                    row++;
                                }

                            }
                        } else {
                            //TODO: dodaj text
                            System.out.println("No games provided");
                        }

                    }
            );
        });


    }
}
