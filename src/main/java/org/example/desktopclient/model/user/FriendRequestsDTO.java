package org.example.desktopclient.model.user;

import java.util.List;

public class FriendRequestsDTO {
    private List<SingleFriendRequestDTO> received;
    private List<SingleFriendRequestDTO> sent;

    public FriendRequestsDTO() {
    }

    public FriendRequestsDTO(List<SingleFriendRequestDTO> received, List<SingleFriendRequestDTO> sent) {
        this.received = received;
        this.sent = sent;
    }

    public List<SingleFriendRequestDTO> getReceived() {
        return received;
    }

    public void setReceived(List<SingleFriendRequestDTO> received) {
        this.received = received;
    }

    public List<SingleFriendRequestDTO> getSent() {
        return sent;
    }

    public void setSent(List<SingleFriendRequestDTO> sent) {
        this.sent = sent;
    }
}
