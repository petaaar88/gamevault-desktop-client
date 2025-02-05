package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class UserGameInCollectionDetailsComponent {
    private ImageView coverImage;
    private Button actionButton;
    private VBox layout;


    public UserGameInCollectionDetailsComponent() {
        coverImage = new ImageView();
        actionButton = new Button();
        layout = new VBox();
        String css = getClass().getResource("/org/example/desktopclient/styles/actionButtonStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        actionButton.getStyleClass().add("large-action-button");
    }

    public VBox getComponent() {

        coverImage.setFitWidth(760);
        coverImage.setFitHeight(240);
        layout.setSpacing(15);


        HBox actionAndStatsHbox = new HBox();
        actionAndStatsHbox.setPadding(new Insets(13, 18, 13, 18));
        VBox imageAndActionVbox = new VBox(coverImage, actionAndStatsHbox);
        actionAndStatsHbox.setStyle("-fx-background-color: #333352");
        actionButton.setText("Download");
        Text lastPlayedTitle = new Text("Last Played");
        lastPlayedTitle.setStyle("-fx-fill: white;-fx-font-size: 15px;-fx-font-weight: 700;");
        Text lastPlayedText = new Text("12.3.2025.");
        lastPlayedText.setStyle("-fx-fill: white;-fx-font-size: 14px;-fx-font-weight: 600");
        VBox lastPlayedVBox = new VBox(lastPlayedTitle, lastPlayedText);

        Text playtimeTitle = new Text("Playtime");
        playtimeTitle.setStyle("-fx-fill: white;-fx-font-size: 15px;-fx-font-weight: 700;");
        Text playtimeText = new Text("12h");
        playtimeText.setStyle("-fx-fill: white;-fx-font-size: 14px;-fx-font-weight: 600");
        VBox playtimeVBox = new VBox(playtimeTitle, playtimeText);

        ImageView deleteImageView = new ImageView(new Image(getClass().getResource("/org/example/desktopclient/icons/settingsIcon.png").toExternalForm()));
        deleteImageView.setFitHeight(33);
        deleteImageView.setFitWidth(33);
        Button deleteButton = new Button("", deleteImageView);
        deleteButton.setStyle("-fx-background-color:transparent; -fx-cursor: hand");

        HBox hbox = new HBox(actionButton, lastPlayedVBox, playtimeVBox);
        HBox.setHgrow(hbox, Priority.ALWAYS);
        hbox.setSpacing(22);
        actionAndStatsHbox.getChildren().addAll(hbox, deleteButton);

        Text descriptionText = new Text("Description");
        descriptionText.setStyle("-fx-fill: #8079CB; -fx-font-size: 20px; -fx-font-weight: 700;");
        Label descriptionLabel = new Label("\"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?\"\n" +
                "\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.\"");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setMaxWidth(350); // Postavi na širinu pri kojoj treba da se wrapuje
        descriptionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white");
        descriptionLabel.setMinHeight(Region.USE_PREF_SIZE);
        descriptionLabel.setPadding(new Insets(8, 0, 0, 0));

        VBox descriptionVbox = new VBox(descriptionText, descriptionLabel);
        descriptionVbox.setStyle("-fx-background-color: #333352");
        descriptionVbox.setPadding(new Insets(10));

        FriendsThatPlayGameComponent friendsThatPlayGameComponent = new FriendsThatPlayGameComponent();
        HBox descriptionAndFriendsHBox = new HBox(descriptionVbox, friendsThatPlayGameComponent.getComponent());
        HBox.setHgrow(descriptionVbox, Priority.ALWAYS);
        descriptionAndFriendsHBox.setSpacing(15);

        ScrollComponent scrollComponent = new ScrollComponent();

        VBox vBox = new VBox(imageAndActionVbox, descriptionAndFriendsHBox);
        vBox.setSpacing(15);

        layout.getChildren().addAll(scrollComponent.getComponent(vBox));
        scrollComponent.setPaddingX(0);

        return layout;
    }


    //TODO: dodaj jos ovde
    public void setNewContent(String imageUrl) {
        coverImage.setImage(new Image(imageUrl));
    }
}
