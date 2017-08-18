package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import entities.EventCard;
import restappss.neehad.projectfriends.R;
import restappss.neehad.projectfriends.activities.BaseActivity;
import services.EventCardService;
import views.AboutViews.AboutUsAdapter;

public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener {

    private ArrayList<EventCard> eventsCards;
    private ArrayList<EventCard> newsCards;

    private RecyclerView recyclerView;
    private AboutUsAdapter aboutUsAdapter;

    public static AboutUsFragment newInstance(){
        return new AboutUsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us,container,false);
        aboutUsAdapter = new AboutUsAdapter((BaseActivity) getActivity(),this);
        eventsCards = aboutUsAdapter.getEventsCards();
        newsCards = aboutUsAdapter.getNewsCards();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_about_us_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setUpAdapter();
        bus.post(new EventCardService.SearchEventsRequest("Hello"));
        bus.post(new EventCardService.SearchNewsRequest("Hello"));
        return rootView;
    }

    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(aboutUsAdapter);
        }
    }

    @Override
    public void OnEventCardClicked(EventCard eventCard) {
        if(!eventCard.isVideo()){
            Log.i(AboutUsFragment.class.getSimpleName(),eventCard.getEventName() + " is a slide show");
        }else{
            Log.i(AboutUsFragment.class.getSimpleName(),eventCard.getEventName() + "is a video");
        }
    }

    @Subscribe
    public  void getEvents(EventCardService.SearchEEventsResponse response){
        eventsCards.clear();
        eventsCards.addAll(response.eventServiceCards);
    }

    @Subscribe
    public  void getNewss(EventCardService.SearchNewsResponse response){
        newsCards.clear();
        newsCards.addAll(response.newsServiceCards);
    }

}

