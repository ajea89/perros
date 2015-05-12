package com.example.pyb.Fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pyb.Adapters.EventAdapter;
import com.example.pyb.R;
import com.example.pyb.Utils.Constans;
import com.viewpagerindicator.CirclePageIndicator;


/**
 * Created by alan on 13/04/15.
 */
public class EventFragment extends BaseFragment {

    private static String ARG1 = "type";

    public static EventFragment newInstance(int fragmetType){
        EventFragment eventFragment = new EventFragment();
        Bundle args = new Bundle();
        args.putInt(ARG1,fragmetType);
        eventFragment.setArguments(args);
        return eventFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView welcome = (TextView) findViewById(R.id.tv_welcome);
        ViewPager pager = (ViewPager) findViewById(R.id.image_pager);
        EventAdapter adapter = new EventAdapter(getChildFragmentManager());
        int[] images;

        if (getArguments().getInt(ARG1) == Constans.EVENT_FRAGMENT){
            welcome.setVisibility(View.GONE);
            images = new int[4];
            images[0] = R.drawable.evento1;
            images[1] = R.drawable.evento2;
            images[2] = R.drawable.evento3;
            images[3] = R.drawable.evento4;

        }else if(getArguments().getInt(ARG1) == Constans.HOME_FRAGMENT){
            welcome.setVisibility(View.VISIBLE);
            images = new int[2];
            images[0] = R.drawable.home1;
            images[1] = R.drawable.home2;

        }else {
            images = new int[1];
            images[0] = R.drawable.postres;
        }

        for (int i:images){
            adapter.addFragment(ImageEventFragment.newInstance(i),null);
        }

        pager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.circle_pager);
        indicator.setViewPager(pager);
    }
}
