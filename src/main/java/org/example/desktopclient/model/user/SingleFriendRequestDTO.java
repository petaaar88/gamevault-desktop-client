package org.example.desktopclient.model.user;

public class SingleFriendRequestDTO {
    private Integer requestId;
    private FriendDTO user;

    public SingleFriendRequestDTO() {
    }

    public SingleFriendRequestDTO(Integer requestId, FriendDTO user) {
        this.requestId = requestId;
        this.user = user;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public FriendDTO getUser() {
        return user;
    }

    public void setUser(FriendDTO user) {
        this.user = user;
    }
}
