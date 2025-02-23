package org.example.desktopclient.model.game;

import org.example.desktopclient.model.user.FriendDTO;

import java.time.LocalDateTime;
import java.util.List;

public class GameInUserCollectionDetails {
    private Integer id;
    private Double playTime;
    private String lastPlayed;
    private String title;
    private String description;
    private String image;
    private List<FriendDTO> friends;

    public GameInUserCollectionDetails() {}

    public GameInUserCollectionDetails(Integer id, Double playTime, String lastPlayed, String title, String description, String image, List<FriendDTO> friends) {
        this.id = id;
        this.playTime = playTime;
        this.lastPlayed = lastPlayed;
        this.title = title;
        this.description = description;
        this.image = image;
        this.friends = friends;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Double playTime) {
        this.playTime = playTime;
    }

    public String getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(String lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FriendDTO> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendDTO> friends) {
        this.friends = friends;
    }

}
