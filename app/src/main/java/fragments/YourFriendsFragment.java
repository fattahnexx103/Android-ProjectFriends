package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import restappss.neehad.projectfriends.R;

public class YourFriendsFragment extends Fragment {

    public static YourFriendsFragment newInstance(){
        return new YourFriendsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_your_friends,container,false);
        return rootView;
    }
}
