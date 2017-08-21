package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import entities.EventPicture;
import restappss.neehad.projectfriends.R;

public class EventPicFragment extends  BaseFragment {

    @BindView(R.id.fragment_events_picture_imageView)
    ImageView eventpicture;

    @BindView(R.id.fragment_events_picture_ProgressBar)
    ProgressBar eventprogressBar;

    public static final String EVENT_PIC_URL = "EVENT_PIC_URL";
    private String picUrl;

    public static EventPicFragment newInstance(EventPicture eventPicture){
        Bundle arguements = new Bundle();
        arguements.putString(EVENT_PIC_URL, eventPicture.getPictureUrl());
        EventPicFragment eventPicFragment = new EventPicFragment();
        eventPicFragment.setArguments(arguements);
        return eventPicFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        picUrl = getArguments().getString(EVENT_PIC_URL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_picture,container,false);
        ButterKnife.bind(this,rootView);

        Picasso.with(getActivity()).load(picUrl)
                .fit()
                .centerCrop()
                .into(eventpicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventprogressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        return  rootView;
    }
}
