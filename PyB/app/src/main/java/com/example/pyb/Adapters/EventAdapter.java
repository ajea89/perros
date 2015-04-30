package com.example.pyb.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajea on 30/04/2015.
 */
public class EventAdapter extends FragmentPageAdapter {

    List<Fragment> fragments = new ArrayList<>();

    public EventAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
    }
}
