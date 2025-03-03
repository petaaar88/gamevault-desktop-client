package org.example.desktopclient.service;

//ova klasa sluzi da bude kontekst aplikacije, trebnutno sadrzi samo usera, ali moze da se nadogradi da sadrzi jezik i temu
//treba da sadrzi podatak o tokenima ili sesiji
//bez ovog konteksta nemogu da imam pristup aplikaciji

import org.example.desktopclient.model.user.User;
import org.example.desktopclient.util.JsonFileManager;

import java.io.IOException;

public class ApplicationContextService {
    private User user;
    private JsonFileManager jsonFileManager;

    public ApplicationContextService() {
        jsonFileManager = new JsonFileManager();

    }
    public ApplicationContextService(User user) {
        this.user = user;
        jsonFileManager = new JsonFileManager();
    }

    public void initialize(){
        try {
            jsonFileManager.ensureFileExists("GameVault","installed_games.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
