package restapps.neehad.projectfriends.inmemory;


import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import entities.EventCard;
import infrastructure.Appl;
import services.EventCardService;

public class InMemoryCardsService extends BaseInMemory {
    public InMemoryCardsService(Appl application) {
        super(application);
    }


    @Subscribe
    public void searchEventCards(EventCardService.SearchEventsRequest request) {
        EventCardService.SearchEEventsResponse response = new EventCardService.SearchEEventsResponse();
        response.eventServiceCards = new ArrayList<>();

        response.eventServiceCards.add(new EventCard(
                1,
                "Event 1",
                "Event 1 Description",
                "http://www.gravatar.com/avatar/" + 1 + "?d=identicon",
                false,
                "null"

        ));

        response.eventServiceCards.add(new EventCard(
                2,
                "Event 2",
                "Event 2 Description",
                "http://www.gravatar.com/avatar/" + 2 + "?d=identicon",
                true,
                "null"
        ));

        bus.post(response);
    }


    @Subscribe
    public void searchNewsCards(EventCardService.SearchNewsRequest request) {
        EventCardService.SearchNewsResponse response = new EventCardService.SearchNewsResponse();
        response.newsServiceCards = new ArrayList<>();

        response.newsServiceCards.add(new EventCard(
                3,
                "News 1",
                "News 1 Description",
                "http://www.gravatar.com/avatar/" + 3 + "?d=identicon",
                false,
                "null"

        ));

        response.newsServiceCards.add(new EventCard(
                4,
                "News 2",
                "News 2 Description",
                "http://www.gravatar.com/avatar/" + 4 + "?d=identicon",
                true,
                "null"
        ));

        bus.post(response);
    }

}
