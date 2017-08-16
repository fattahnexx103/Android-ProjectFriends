package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import restappss.neehad.projectfriends.R;

public class DetailsFragment extends BaseFragment {

    //return the fragment
    public static DetailsFragment newInstance(){

        return new DetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details,container,false);
        return rootView;
    }
}
