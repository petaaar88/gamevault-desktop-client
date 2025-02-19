package org.example.desktopclient.model.user;

import java.time.LocalDate;

public class FriendCommentDTO {
    private Integer id;
    private FriendDTO user;
    private String content;
    private String addedAt;

    public FriendCommentDTO() {}

    public FriendCommentDTO(Integer id, FriendDTO user, String content, String addedAt) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.addedAt = addedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FriendDTO getUser() {
        return user;
    }

    public void setUser(FriendDTO user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "FriendCommentDTO{" +
                "id=" + id +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", addedAt=" + addedAt +
                '}';
    }
}
