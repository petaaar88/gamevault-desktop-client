package org.example.desktopclient.model.game;

import java.util.List;

public class GameDescriptionDTO {
    String title;
    String description;
    List<String> genres;
    String developer;
    String release;

    public GameDescriptionDTO() {
    }

    public GameDescriptionDTO(String title, String description, List<String> genres, String developer, String release) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.developer = developer;
        this.release = release;
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
}
