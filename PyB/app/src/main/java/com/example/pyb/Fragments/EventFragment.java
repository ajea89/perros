package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.R;

/**
 * Created by alan on 13/04/15.
 */
public class EventFragment extends BaseFragment {

    public static EventFragment newInstance(){
        EventFragment eventFragment = new EventFragment();
        return eventFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_fragment_layout, container, false);
    }
}
