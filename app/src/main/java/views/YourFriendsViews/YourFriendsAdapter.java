package views.YourFriendsViews;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import entities.Friend;
import fragments.YourFriendsFragment;
import restappss.neehad.projectfriends.R;


public class YourFriendsAdapter  extends RecyclerView.Adapter<YourFriendsViewHolder> implements View.OnClickListener {

    private LayoutInflater layoutInflater;
    private AppCompatActivity activity;
    private OnFriendClickedListener listener;
    private ArrayList<Friend> friendsList;

    public YourFriendsAdapter(YourFriendsFragment listener, AppCompatActivity activity) {
        this.listener = listener;
        this.activity = activity;
        layoutInflater = activity.getLayoutInflater();
        friendsList = new ArrayList<>();
    }

    public ArrayList<Friend> getFriendsList() {
        return friendsList;
    }

    @Override
    public YourFriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View listView  = layoutInflater.inflate(R.layout.list_your_friends, parent, false);
        listView.setOnClickListener(this);
        return new YourFriendsViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(YourFriendsViewHolder holder, int position) {
        holder.populate(activity,friendsList.get(position));

    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof  Friend){
            Friend friend = (Friend) view.getTag();
            listener.OnFriendClicked(friend);
        }
    }

    public interface OnFriendClickedListener{

         void OnFriendClicked(Friend friend);
    }
}
