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
import entities.Friend;
import fragments.FriendDetailFragment;
import restappss.neehad.projectfriends.R;
import services.FriendService;

public class FriendPagerActivity  extends  BaseActivity{

    public static final String FRIEND_EXTRA_INFO = "FRIEND_EXTRA_INFO";
    private ArrayList<Friend> friendsList;

    @BindView(R.id.activity_friend_viewPager)
    ViewPager friendViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_pager);
        ButterKnife.bind(this);
        friendsList = new ArrayList<>();
        bus.post(new FriendService.SearchFriendRequest("Hello"));
        friendViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Friend friend = friendsList.get(position);
                return FriendDetailFragment.newInstance(friend);
            }

            @Override
            public int getCount() {
                return friendsList.size();
            }
        });

        Friend friend = getIntent().getParcelableExtra(FRIEND_EXTRA_INFO);
        int friendId = friend.getFriendId();

        for(int i =0;i<friendsList.size(); i++){
            if(friendsList.get(i).getFriendId() == friendId){
                friendViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Subscribe
    public void getFriends(FriendService.SearchFriendResponse response){
        friendsList.clear();
        friendsList.addAll(response.friendList);
    }

    public static Intent newIntent(Context context, Friend friend){
        Intent intent = new Intent(context,FriendPagerActivity.class);
        intent.putExtra(FRIEND_EXTRA_INFO,friend);
        return intent;
    }

}
