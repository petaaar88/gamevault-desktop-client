package org.example.desktopclient;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Notification {

    public static void showEnterGameNotification(String imageUrl, String username, String gameName) {
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT); // Uklanja podrazumevanu belu pozadinu
            stage.setAlwaysOnTop(true);

            Label usernameLabel = new Label(username);
            usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

            ImageView imageView =new ImageView(new Image(imageUrl));
            imageView.setFitHeight(63);
            imageView.setFitWidth(63);

            Label gameLabel = new Label(gameName);
            gameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
            Label isPlayingLabel = new Label("is playing");
            isPlayingLabel.setStyle("-fx-text-fill: #B5B5B5; -fx-font-size: 14px;");

            VBox vbox = new VBox(usernameLabel, isPlayingLabel, gameLabel);
            vbox.setSpacing(0);

            HBox root = new HBox(imageView, vbox);
            root.setPrefWidth(300);
            root.setStyle("-fx-background-color: #191B2E; -fx-padding: 15px;-fx-border-radius: 2px;-fx-border-color: #333352;");
            root.setSpacing(15);
            root.setAlignment(Pos.CENTER_LEFT);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT); // Osigurava da nema pozadine na nivou scene
            stage.setScene(scene);
            stage.show(); // Potrebno da bismo dobili ispravne dimenzije scene

            // Dobijanje veličine ekrana
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = screenBounds.getMaxX();
            double screenHeight = screenBounds.getMaxY();

            // Dobijanje dimenzija notifikacije
            double notificationWidth = scene.getWidth();
            double notificationHeight = scene.getHeight();

            // Postavljanje u donji desni ugao
            stage.setX(screenWidth - notificationWidth);
            stage.setY(screenHeight - notificationHeight);

            // Animacija ulaska
            FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();

            // Automatsko zatvaranje
            PauseTransition delay = new PauseTransition(Duration.seconds(12));
            delay.setOnFinished(event -> {
                // Animacija izlaska
                FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), root);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(e -> stage.close());
                fadeOut.play();
            });

            delay.play();
        });
    }

    public static void showOnlineNotification(String imageUrl, String username) {
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT); // Uklanja podrazumevanu belu pozadinu
            stage.setAlwaysOnTop(true);

            Label usernameLabel = new Label(username);
            usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

            ImageView imageView =new ImageView(new Image(imageUrl));
            imageView.setFitHeight(63);
            imageView.setFitWidth(63);

            Label isOnlineLabel = new Label("is now online");
            isOnlineLabel.setStyle("-fx-text-fill: #B5B5B5; -fx-font-size: 14px;");

            VBox vbox = new VBox(usernameLabel, isOnlineLabel);
            vbox.setSpacing(0);
            vbox.setAlignment(Pos.CENTER_LEFT);

            HBox root = new HBox(imageView, vbox);
            root.setPrefWidth(300);
            root.setStyle("-fx-background-color: #191B2E; -fx-padding: 15px;-fx-border-radius: 2px;-fx-border-color: #333352;");
            root.setSpacing(15);
            root.setAlignment(Pos.CENTER_LEFT);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT); // Osigurava da nema pozadine na nivou scene
            stage.setScene(scene);
            stage.show(); // Potrebno da bismo dobili ispravne dimenzije scene

            // Dobijanje veličine ekrana
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = screenBounds.getMaxX();
            double screenHeight = screenBounds.getMaxY();

            // Dobijanje dimenzija notifikacije
            double notificationWidth = scene.getWidth();
            double notificationHeight = scene.getHeight();

            // Postavljanje u donji desni ugao
            stage.setX(screenWidth - notificationWidth);
            stage.setY(screenHeight - notificationHeight);

            // Animacija ulaska
            FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();

            // Automatsko zatvaranje
            PauseTransition delay = new PauseTransition(Duration.seconds(12));
            delay.setOnFinished(event -> {
                // Animacija izlaska
                FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), root);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(e -> stage.close());
                fadeOut.play();
            });

            delay.play();
        });
    }

    public static void showFriendRequestNotification(String imageUrl, String username) {
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT); // Uklanja podrazumevanu belu pozadinu
            stage.setAlwaysOnTop(true);

            Label usernameLabel = new Label(username);
            usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

            ImageView imageView =new ImageView(new Image(imageUrl));
            imageView.setFitHeight(63);
            imageView.setFitWidth(63);

            Label isOnlineLabel = new Label("sent you friend request!");
            isOnlineLabel.setStyle("-fx-text-fill: #B5B5B5; -fx-font-size: 16px;");

            VBox vbox = new VBox(usernameLabel, isOnlineLabel);
            vbox.setSpacing(0);
            vbox.setAlignment(Pos.CENTER_LEFT);

            HBox root = new HBox(imageView, vbox);
            root.setPrefWidth(300);
            root.setStyle("-fx-background-color: #191B2E; -fx-padding: 15px;-fx-border-radius: 2px;-fx-border-color: #333352;");
            root.setSpacing(15);
            root.setAlignment(Pos.CENTER_LEFT);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT); // Osigurava da nema pozadine na nivou scene
            stage.setScene(scene);
            stage.show(); // Potrebno da bismo dobili ispravne dimenzije scene

            // Dobijanje veličine ekrana
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = screenBounds.getMaxX();
            double screenHeight = screenBounds.getMaxY();

            // Dobijanje dimenzija notifikacije
            double notificationWidth = scene.getWidth();
            double notificationHeight = scene.getHeight();

            // Postavljanje u donji desni ugao
            stage.setX(screenWidth - notificationWidth);
            stage.setY(screenHeight - notificationHeight);

            // Animacija ulaska
            FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();

            // Automatsko zatvaranje
            PauseTransition delay = new PauseTransition(Duration.seconds(12));
            delay.setOnFinished(event -> {
                // Animacija izlaska
                FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), root);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(e -> stage.close());
                fadeOut.play();
            });

            delay.play();
        });
    }
}
