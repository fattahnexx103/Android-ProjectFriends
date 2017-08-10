package views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.AboutUsFragment;
import fragments.DetailsFragment;
import fragments.YourFriendsFragment;

public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {
    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment returnFragment;
        switch(position) {
            case 0:
                returnFragment = AboutUsFragment.newInstance();
                break;
            case 1:
                returnFragment = DetailsFragment.newInstance();
                break;
            case 2:
                returnFragment = YourFriendsFragment.newInstance();
                break;
            default:
                return null;
        }
        return returnFragment;
    }

    //number of fragments
    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch(position){
            case 0:
                title = "About Us";
                break;
            case 1:
                title = "Details";
                break;
            case 2:
                title = "Friends";
                break;
            default:
                return null;
        }
        return title;
    }
}
