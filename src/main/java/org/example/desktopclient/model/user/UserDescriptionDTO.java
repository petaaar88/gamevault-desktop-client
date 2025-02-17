package org.example.desktopclient.model.user;

public class UserDescriptionDTO {
    private Integer id;
    private String username;
    private String icon;
    private String description;
    private String createdAt;

    public UserDescriptionDTO() {
    }

    public UserDescriptionDTO(Integer id, String username, String icon, String description, String createdAt) {
        this.id = id;
        this.username = username;
        this.icon = icon;
        this.description = description;
        this.createdAt = createdAt;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
