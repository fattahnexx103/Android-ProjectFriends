package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import entities.Friend;
import restappss.neehad.projectfriends.R;
import views.YourFriendsViews.YourFriendsAdapter;

public class YourFriendsFragment extends Fragment implements  YourFriendsAdapter.OnFriendClickedListener {

    //for logging purposes
    private final String LOG_TAG = YourFriendsFragment.class.getSimpleName();

    private YourFriendsAdapter friendsAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Friend> friendsList;

    public static YourFriendsFragment newInstance(){
        return new YourFriendsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_your_friends,container,false);

        friendsAdapter = new YourFriendsAdapter(this,(AppCompatActivity) getActivity());
        friendsList = friendsAdapter.getFriendsList();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_yout_friends_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        setUpAdapter();
        getFriendsList(friendsList);
        return rootView;
    }

    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(friendsAdapter);
        }
    }

    @Override
    public void OnFriendClicked(Friend friend) {
        Log.i(LOG_TAG, friend.getFriendName() + "was clicked");
    }

    private ArrayList<Friend> getFriendsList(ArrayList<Friend> friendsList){
        for(int i = 0; i < 32; i++){
            friendsList.add(new Friend(
                    i,
                    "Friend  " + i,
                    "has this sample description",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Squad!"

            ));
        }
        return friendsList;
    }
}
