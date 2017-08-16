package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Friend;
import restappss.neehad.projectfriends.R;

public class FriendDetailFragment extends  BaseFragment{

    @BindView(R.id.fragment_friend_detail_desc)
    TextView friendDesc;

    @BindView(R.id.fragment_friend_detail_name)
    TextView friendName;

    @BindView(R.id.fragment_friend_detail_progressBar)
    ProgressBar friendProgressbar;

    @BindView(R.id.fragment_friend_detail_group)
    TextView friendGroup;

    @BindView(R.id.fragment_friend_detail_friendPicture)
    ImageView friendPicture;

    private Friend friend; //the friend who is selected
    public static final String FRIEND_EXTRA_INFO = "FRIEND_EXTRA_INFO";

    public static FriendDetailFragment newInstance(Friend friend){
        Bundle arguements = new Bundle();
        arguements.putParcelable(FRIEND_EXTRA_INFO,friend);
        FriendDetailFragment friendDetailFragment = new FriendDetailFragment();
        friendDetailFragment.setArguments(arguements);
        return friendDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        friend = getArguments().getParcelable(FRIEND_EXTRA_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_friend_details,container,false);
        ButterKnife.bind(this,rootView);
        friendName.setText(friend.getFriendName());
        friendDesc.setText(friend.getFriendDesc());
        friendGroup.setText(friend.getFriendGroup());

        Picasso.with(getActivity()).load(friend.getFriendPicture())
                .fit()
                .centerCrop()
                .into(friendPicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        friendProgressbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        return rootView;
    }
}
