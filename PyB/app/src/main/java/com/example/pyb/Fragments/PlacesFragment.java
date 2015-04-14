package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.R;

/**
 * Created by alan on 13/04/15.
 */
public class PlacesFragment extends BaseFragment {

    public static PlacesFragment newInstance(){
        PlacesFragment placesFragment = new PlacesFragment();
        return placesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.places_fragment_layout, container, false);
    }
}
