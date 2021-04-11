package com.example.spring_the_string;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdaptarTab extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public AdaptarTab(@NonNull FragmentManager fm,Context c,int totalTabs) {
        super(fm);
        Context context;
        this.totalTabs=totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1:
                MapsFragment mapsFragment = new MapsFragment();
                return mapsFragment;


            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
