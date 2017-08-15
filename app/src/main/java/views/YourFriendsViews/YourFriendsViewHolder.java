package views.YourFriendsViews;


import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

import butterknife.ButterKnife;
import entities.Friend;
import restappss.neehad.projectfriends.R;

public class YourFriendsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_your_friends_imageView)
    ImageView friendPic;

    @BindView(R.id.list_your_friends_progressBar)
    ProgressBar friendProgressBar;


    public YourFriendsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, Friend friend){

        itemView.setTag(friend);
        Picasso.with(context).load(friend.getFriendPicture())
                .fit()
                .centerCrop()
                .into(friendPic, new Callback() {
                    @Override
                    public void onSuccess() {
                        friendProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
