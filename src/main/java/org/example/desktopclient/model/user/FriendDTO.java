package org.example.desktopclient.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendDTO {
    Integer id;
    String username;
    String icon;
    Double hoursPlayed;
    String inGame;

    public FriendDTO() {
    }

    public FriendDTO(Integer id, String username, String icon, Double hoursPlayed, String inGame) {
        this.id = id;
        this.username = username;
        this.icon = icon;
        this.hoursPlayed = hoursPlayed;
        this.inGame = inGame;
    }

    public FriendDTO(Integer id, String username, String icon, Double hoursPlayed) {
        this.id = id;
        this.username = username;
        this.icon = icon;
        this.hoursPlayed = hoursPlayed;
    }

    public FriendDTO(Integer id, String username, String icon, String inGame) {
        this.id = id;
        this.username = username;
        this.icon = icon;
        this.inGame = inGame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(Double hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public String getInGame() {
        return inGame;
    }

    public void setInGame(String inGame) {
        this.inGame = inGame;
    }
}

