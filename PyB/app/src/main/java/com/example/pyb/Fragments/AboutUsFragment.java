package com.example.pyb.Fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.Adapters.FragmentPageAdapter;
import com.example.pyb.R;
import com.viewpagerindicator.TabPageIndicator;

/**
 * Created by alan on 13/04/15.
 */
public class AboutUsFragment extends BaseFragment {

    public static AboutUsFragment newInstance(){
        AboutUsFragment aboutUsFragment = new AboutUsFragment();
        return aboutUsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.about_us_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentPageAdapter adapter = new FragmentPageAdapter(getChildFragmentManager());

        ViewPager vpContent = (ViewPager) findViewById(R.id.vp_content);
        final TabPageIndicator tabs = (TabPageIndicator) findViewById(R.id.tabs);

        adapter.addFragment(CatalogNewFragment.newIntance(), "MISIÓN");
        adapter.addFragment(CatalogAllFragment.newIntance(), "VISIÓN");
        adapter.addFragment(CatalogPopularFragment.newIntance(), "VALORES");

        vpContent.setAdapter(adapter);
        tabs.setViewPager(vpContent);
    }
}
