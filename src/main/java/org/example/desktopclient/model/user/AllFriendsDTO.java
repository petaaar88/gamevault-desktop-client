package org.example.desktopclient.model.user;

import java.util.List;
import java.util.Map;

public class AllFriendsDTO {

    private Map<String, List<FriendDTO>> friends;

    public AllFriendsDTO() {
    }

    public AllFriendsDTO(Map<String, List<FriendDTO>> friends) {
        this.friends = friends;
    }

    public Map<String, List<FriendDTO>> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, List<FriendDTO>> friends) {
        this.friends = friends;
    }
}
