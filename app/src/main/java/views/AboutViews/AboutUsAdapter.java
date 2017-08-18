package views.AboutViews;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import entities.EventCard;
import restappss.neehad.projectfriends.R;
import restappss.neehad.projectfriends.activities.BaseActivity;

public class AboutUsAdapter  extends RecyclerView.Adapter{

    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_EVENT_LIST = 2;
    private final int VIEW_TYPE_NEWS_LIST = 3;
    private final int VIEW_TYPE_LIST_HEADER = 4;

    private LayoutInflater inflater;
    private BaseActivity activity;
    private ArrayList<EventCard> eventsCards;
    private ArrayList<EventCard> newsCards;

    private AboutUsListener aboutUsListener;

    public AboutUsAdapter(BaseActivity activity, AboutUsListener aboutUsListener) {
        this.activity = activity;
        this.aboutUsListener = aboutUsListener;
        inflater = activity.getLayoutInflater();
        eventsCards = new ArrayList<>();
        newsCards = new ArrayList<>();
    }

    public ArrayList<EventCard> getEventsCards() {
        return eventsCards;
    }

    public ArrayList<EventCard> getNewsCards() {
        return newsCards;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return VIEW_TYPE_MAIN_HEADER;
        }
        position --;

        if(eventsCards.size() > 0){
            if(position == 0){
                return VIEW_TYPE_LIST_HEADER;
            }
            position --;

            if(position < eventsCards.size()){
                return VIEW_TYPE_EVENT_LIST;
            }

            position -= eventsCards.size();
        }

        if(newsCards.size()> 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;
        }
        if(position < newsCards.size()){
            return VIEW_TYPE_NEWS_LIST;
        }
        position -= newsCards.size();


        throw  new IllegalArgumentException(
                "we are being asked for an item type from position " + position + ", though we have no such item"
        );


    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventCardView = inflater.inflate(R.layout.list_news_card, parent, false);
        final View listHeader = inflater.inflate(R.layout.simple_header,parent,false);

        if(viewType == VIEW_TYPE_MAIN_HEADER){
            return new AboutMainHeaderViewHolder(inflater,parent);
        }
        else if(viewType == VIEW_TYPE_EVENT_LIST){
            final EventCardViewHolder eventCardViewHolder = new EventCardViewHolder(eventCardView);
            eventCardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) eventCardViewHolder.itemView.getTag();
                    aboutUsListener.OnEventCardClicked(eventCard);
                }
            });
            return eventCardViewHolder;
        }
        else if(viewType == VIEW_TYPE_NEWS_LIST){
            final NewsCardsViewHolder newsCardsViewHolder = new NewsCardsViewHolder(eventCardView);
            newsCardsViewHolder.itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) newsCardsViewHolder.itemView.getTag();
                    aboutUsListener.OnEventCardClicked(eventCard);
                }
            }));
            return newsCardsViewHolder;
        }

        else if(viewType == VIEW_TYPE_LIST_HEADER){
            return new AboutListHeaderViewHolder(listHeader);
        }

        throw new IllegalArgumentException(viewType + "is not supported in this adapter");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof  AboutMainHeaderViewHolder){
            AboutMainHeaderViewHolder holder1 = (AboutMainHeaderViewHolder) holder;
        }

        if(holder instanceof EventCardViewHolder){
            position --;
            if(eventsCards.size() > 0){
                position --;
            }
            EventCard eventCard = eventsCards.get(position);
            ((EventCardViewHolder) holder).populate(activity,eventCard);

        }

        if(holder instanceof  NewsCardsViewHolder){
            position --;
            if(eventsCards.size() > 0){
                position --;
                position -=eventsCards.size();
            }

            if(newsCards.size() > 0){
                position --;
            }
            EventCard eventCard = newsCards.get(position);
            ((NewsCardsViewHolder) holder).populate(activity,eventCard);
        }

        if(holder instanceof  AboutListHeaderViewHolder){
            AboutListHeaderViewHolder aboutListHeaderViewHolder = (AboutListHeaderViewHolder) holder;

            int eventposition = 1;
            int newsposition = eventposition + eventsCards.size() + 1;

            if(position == eventposition){
                aboutListHeaderViewHolder.populate("Events");
            }

            if(position == newsposition){
                aboutListHeaderViewHolder.populate(("News"));
            }

        }

    }

    @Override
    public int getItemCount() {
        int count = 1;

        if(eventsCards.size() > 0){
            count += 1 + eventsCards.size();
        }

        if(newsCards.size() > 0){
            count += 1 + newsCards.size();
        }

        return count;
    }

    public interface AboutUsListener{
        void OnEventCardClicked(EventCard eventCard);
    }
}
