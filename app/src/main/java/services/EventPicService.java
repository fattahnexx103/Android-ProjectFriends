package services;


import java.util.List;

import entities.EventPicture;

public class EventPicService {

    private EventPicService(){

    }

    public static class SearchEventPhotoRequest{
        public String fireBaseUrl;

        public SearchEventPhotoRequest(String fireBaseUrl){
            this.fireBaseUrl = fireBaseUrl;
        }

    }

    public static class SearchEventPhotoResponse{
        public List<EventPicture> eventPhotos;
    }


    public static class SearchNewsPhotoRequest{
        public String fireBaseUrl;

        public SearchNewsPhotoRequest(String fireBaseUrl){
            this.fireBaseUrl = fireBaseUrl;
        }

    }

    public static class SearchNewsPhotoResponse{
        public List<EventPicture> newsPhotos;
    }


}
