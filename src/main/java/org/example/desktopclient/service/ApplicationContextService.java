package org.example.desktopclient.service;

//ova klasa sluzi da bude kontekst aplikacije, trebnutno sadrzi samo usera, ali moze da se nadogradi da sadrzi jezik i temu
//treba da sadrzi podatak o tokenima ili sesiji
//bez ovog konteksta nemogu da imam pristup aplikaciji

import org.example.desktopclient.model.User;

public class ApplicationContextService {
    private User user;

    public ApplicationContextService() {

    }
    public ApplicationContextService(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
