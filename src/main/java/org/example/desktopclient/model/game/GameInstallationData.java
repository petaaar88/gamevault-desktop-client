package org.example.desktopclient.model.game;

public class GameInstallationData {
    private Integer game_id;
    private String game_folder;
    private String game_executable;

    public GameInstallationData() {}

    public GameInstallationData(Integer gameId, String gameFolder, String gameExecutable) {
        this.game_id = gameId;
        this.game_folder = gameFolder;
        this.game_executable = gameExecutable;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getGame_folder() {
        return game_folder;
    }

    public void setGame_folder(String game_folder) {
        this.game_folder = game_folder;
    }

    public String getGame_executable() {
        return game_executable;
    }

    public void setGame_executable(String game_executable) {
        this.game_executable = game_executable;
    }
}
