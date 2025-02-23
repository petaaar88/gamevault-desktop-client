package org.example.desktopclient.model.user;

import java.io.File;

public class UpdateUserDTO {
    private String username;
    private String description;
    private File icon;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String username, String description, File icon) {
        this.username = username;
        this.description = description;
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getIcon() {
        return icon;
    }

    public void setIcon(File icon) {
        this.icon = icon;
    }


}
