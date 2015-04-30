package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pyb.R;

/**
 * Created by Ajea on 30/04/2015.
 */
public class ImageEventFragment extends BaseFragment{

    private static final String ARG_PARAM1 = "imagen";
    private int image;

    public static ImageEventFragment newInstance(int image){
        ImageEventFragment fragment = new ImageEventFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1,image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_event_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        image = getArguments().getInt(ARG_PARAM1);
        ImageView eventImage = (ImageView) findViewById(R.id.event_image);
        eventImage.setImageResource(image);
    }
}
