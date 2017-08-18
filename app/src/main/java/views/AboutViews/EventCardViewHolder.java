package views.AboutViews;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import entities.EventCard;
import restappss.neehad.projectfriends.R;

public class EventCardViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_card_eventName)
    TextView eventName;

    @BindView(R.id.list_card_eventDesc)
    TextView eventDesc;

    @BindView(R.id.list_card_progrssBar)
    ProgressBar eventProgressBar;

    @BindView(R.id.list_card_imageView)
    ImageView eventImageView;

    @BindView(R.id.event_card_icon)
    ImageView eventIcon;

    public EventCardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, EventCard eventCard){
        itemView.setTag(eventCard);

    //set the icons
        if(!eventCard.isVideo()){
            eventIcon.setImageResource(R.mipmap.camera);
        }
        else{
            eventIcon.setImageResource(R.mipmap.video);
        }

        eventDesc.setText(eventCard.getEventDescription());
        eventName.setText(eventCard.getEventName());

        Picasso.with(context).load(eventCard.getEventImage())
                .fit()
                .centerCrop()
                .into(eventImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
