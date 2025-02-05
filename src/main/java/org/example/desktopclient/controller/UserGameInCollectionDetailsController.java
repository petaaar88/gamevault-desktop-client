package org.example.desktopclient.controller;

import org.example.desktopclient.component.UserGameInCollectionDetailsComponent;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserGameInCollectionDetailsController {

    private UserGameInCollectionDetailsComponent component;
    //TODO: obrisi ovo
    List<Map<String,String>> gamesDeatils;

    public UserGameInCollectionDetailsController(UserGameInCollectionDetailsComponent component) {


        Map<String,String> rainbowMap = Map.of("id","2","icon","https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_tom_clancys_rainbow_six_siege_06_2560x1080.jpg&height=506&sharpen","played","123","date","12.2.2023", "description","Ovo je rainbow");
        Map<String,String> gtaMap = Map.of("id","1","icon","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcOKpBPIT0ss4Go7mc1jgX9RT52AW1E61yHA&s","played","56","date","1.7.2025", "description","Ovo je gtaV");

        gamesDeatils = Arrays.asList(gtaMap,rainbowMap);
        this.component = component;
        this.changeGame(Integer.parseInt(gamesDeatils.get(0).get("id")));

    }

    public void changeGame(Integer newGameId){

        Map<String, String> game = gamesDeatils.stream().filter(gamesDeatils -> gamesDeatils.get("id").equalsIgnoreCase(newGameId.toString())).findFirst().get();

        component.setNewContent(game.get("icon"));

    }
}
