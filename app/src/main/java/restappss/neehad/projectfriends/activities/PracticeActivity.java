package restappss.neehad.projectfriends.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import entities.Friend;
import fragments.FriendDetailFragment;
import restappss.neehad.projectfriends.R;

public class PracticeActivity extends BaseActivity {

    public static final String FRIEND_EXTRA_INFO = "FRIEND_EXTRA_INFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_practice);

        if(fragment == null){
            fragment = null;

            fragmentManager.beginTransaction()
                    .add(R.id.activity_practice, fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context context, Friend friend){

        Intent intent = new Intent(context, PracticeActivity.class);
        intent.putExtra(FRIEND_EXTRA_INFO, friend);
        return intent;
    }
}
