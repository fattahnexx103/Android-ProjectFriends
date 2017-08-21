package restappss.neehad.projectfriends.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import entities.EventCard;
import entities.EventPicture;
import fragments.EventPicFragment;
import restappss.neehad.projectfriends.R;
import services.EventPicService;

public class PhotoPagerActivity extends BaseActivity {

    private ArrayList<EventPicture> mEventPhotos;

    @BindView(R.id.activity_photo_viewPager)
    ViewPager viewPager;

    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_photo_viewpager);
        ButterKnife.bind(this);
        mEventPhotos = new ArrayList<>();
        int CardIndex = getIntent().getIntExtra(EXTRA_CARD_INFO, 0);

        switch (CardIndex){
            case 1:
                bus.post(new EventPicService.SearchEventPhotoRequest("Hello"));
                break;

            case 3:
                bus.post(new EventPicService.SearchNewsPhotoRequest("Hello"));
                break;

        }

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPicture eventPicture = mEventPhotos.get(position);
                return EventPicFragment.newInstance(eventPicture);
            }

            @Override
            public int getCount() {
                return mEventPhotos.size();
            }
        });


    }

    public static Intent  newIntent(Context context, EventCard eventCard){
        Intent intent = new Intent(context,PhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO, eventCard.getEventId());
        return  intent;
    }

    @Subscribe
    public void getEventPhotos(EventPicService.SearchEventPhotoResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.eventPhotos);
    }

    @Subscribe
    public void getNewsPhotos(EventPicService.SearchNewsPhotoResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.newsPhotos);
    }
}
