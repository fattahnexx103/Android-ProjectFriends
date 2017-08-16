package services;


import java.util.List;

import entities.Friend;

public class FriendService {

    public FriendService(){

    }

    public static class SearchFriendRequest{
        public String firebaseUsl;

        public SearchFriendRequest(String firebaseUsl){
            this.firebaseUsl = firebaseUsl;
        }

    }

    public static class SearchFriendResponse{
        public List<Friend> friendList;
    }
}
