package restapps.neehad.projectfriends.inmemory;


import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import entities.EventPicture;
import infrastructure.Appl;
import services.EventPicService;

public class InMemoryPicture extends  BaseInMemory {
    public InMemoryPicture(Appl application) {
        super(application);
    }

    @Subscribe
    public void getEventPhoto(EventPicService.SearchEventPhotoRequest request){
        EventPicService.SearchEventPhotoResponse response = new EventPicService.SearchEventPhotoResponse();
        response.eventPhotos = new ArrayList<>();

        response.eventPhotos.add(new EventPicture(
                "http://www.gravatar.com/avatar/" + 7 + "?d=identicon"
        ));

        response.eventPhotos.add(new EventPicture(
                "http://www.gravatar.com/avatar/" + 8 + "?d=identicon"
        ));

        response.eventPhotos.add(new EventPicture(
                "http://www.gravatar.com/avatar/" + 9 + "?d=identicon"
        ));

        bus.post(response);
    }

    @Subscribe
    public void getNewsPhoto(EventPicService.SearchNewsPhotoRequest request){
        EventPicService.SearchNewsPhotoResponse response = new EventPicService.SearchNewsPhotoResponse();
        response.newsPhotos = new ArrayList<>();

        response.newsPhotos.add(new EventPicture(
                "http://www.gravatar.com/avatar/" + 17 + "?d=identicon"
        ));

        response.newsPhotos.add(new EventPicture(
                "http://www.gravatar.com/avatar/" + 18 + "?d=identicon"
        ));

        response.newsPhotos.add(new EventPicture(
                "http://www.gravatar.com/avatar/" + 19 + "?d=identicon"
        ));

        bus.post(response);
    }
}
