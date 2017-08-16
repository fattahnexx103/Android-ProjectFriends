package restapps.neehad.projectfriends.inmemory;


import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import entities.Friend;
import infrastructure.Appl;
import services.FriendService;

public class InMemoryFriendService extends BaseInMemory {
    public InMemoryFriendService(Appl application) {
        super(application);
    }

    @Subscribe
    public void getFriends(FriendService.SearchFriendRequest request){
        FriendService.SearchFriendResponse response = new FriendService.SearchFriendResponse();
        response.friendList = new ArrayList<>();

        for(int i = 0; i < 32; i++){
           response.friendList.add(new Friend(
                    i,
                    "Friend  " + i,
                    "has this sample description",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Squad!"

            ));
        }
        bus.post(response);
    }

}
