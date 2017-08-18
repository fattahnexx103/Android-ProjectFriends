package services;


import java.util.List;

import entities.EventCard;

public class EventCardService {

    public static class SearchEventsRequest{
        public  String fireBaseUrl;

        public SearchEventsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchEEventsResponse{
        public List<EventCard> eventServiceCards;
    }





    public static class SearchNewsRequest{
        public String fireBaseUrl;

        public SearchNewsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchNewsResponse{
        public List<EventCard> newsServiceCards;
    }
}
