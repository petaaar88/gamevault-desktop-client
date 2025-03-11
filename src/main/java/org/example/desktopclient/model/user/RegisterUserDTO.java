package org.example.desktopclient.model.user;

import java.io.File;

public class RegisterUserDTO {
    private String username;
    private String password;
    private File icon;

    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String username, String password, File icon) {
        this.username = username;
        this.password = password;
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public File getIcon() {
        return icon;
    }

    public void setIcon(File icon) {
        this.icon = icon;
    }
}
