package com.example.pyb.Fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.Adapters.GalleryPagerAdapter;
import com.example.pyb.Adapters.HackyViewPager;
import com.example.pyb.R;

/**
 * Created by alan on 13/04/15.
 */
public class GalleryFragment extends BaseFragment {

    public static GalleryFragment newInstance(){
        GalleryFragment galleryFragment = new GalleryFragment();
        return galleryFragment;
    }

    private static final String ISLOCKED_ARG = "isLocked";

    private ViewPager mViewPager;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.gallery_fragment_layout, container, false);
        mViewPager = (HackyViewPager) view.findViewById(R.id.view_pager);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewPager.setAdapter(new GalleryPagerAdapter());

        if (savedInstanceState != null) {
            boolean isLocked = savedInstanceState.getBoolean(ISLOCKED_ARG, false);
            ((HackyViewPager) mViewPager).setLocked(isLocked);
        }
    }



    private boolean isViewPagerActive() {
        return (mViewPager != null && mViewPager instanceof HackyViewPager);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (isViewPagerActive()) {
            outState.putBoolean(ISLOCKED_ARG, ((HackyViewPager) mViewPager).isLocked());
        }
        super.onSaveInstanceState(outState);
    }
}
