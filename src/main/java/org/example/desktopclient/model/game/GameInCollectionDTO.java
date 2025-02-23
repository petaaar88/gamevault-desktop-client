package org.example.desktopclient.model.game;

public class GameInCollectionDTO {
    private Integer id;
    private String title;
    private String icon;


    public GameInCollectionDTO() {
    }

    public GameInCollectionDTO(Integer id, String title, String icon) {
        this.id = id;
        this.title = title;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
