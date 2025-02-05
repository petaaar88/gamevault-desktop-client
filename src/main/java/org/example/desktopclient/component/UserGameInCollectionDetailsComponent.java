package org.example.desktopclient.component;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class UserGameInCollectionDetailsComponent {
    private ImageView coverImage;



    public UserGameInCollectionDetailsComponent() {
        coverImage = new ImageView();
    }

    public VBox getComponent(){
        VBox layout = new VBox();

        coverImage.setFitWidth(400);
        coverImage.setFitHeight(200);

        layout.getChildren().add(coverImage);

        return layout;
    }


    //TODO: dodaj jos ovde
    public void setNewContent(String imageUrl){
        coverImage.setImage(new Image(imageUrl));
    }
}
