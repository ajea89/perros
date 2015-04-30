package com.example.pyb.Fragments;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.Adapters.EventAdapter;
import com.example.pyb.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alan on 13/04/15.
 */
public class EventFragment extends BaseFragment {

    private int[] images = {R.drawable.cerveza_sabor, R.drawable.cerveza, R.drawable.bebidas};

    public static EventFragment newInstance(){
        EventFragment eventFragment = new EventFragment();
        return eventFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ViewPager pager = (ViewPager) findViewById(R.id.image_pager);
        EventAdapter adapter = new EventAdapter(getChildFragmentManager());

        for (int i:images){
            adapter.addFragment(ImageEventFragment.newInstance(i),null);
        }

        pager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.circle_pager);
        indicator.setViewPager(pager);

    }

}
