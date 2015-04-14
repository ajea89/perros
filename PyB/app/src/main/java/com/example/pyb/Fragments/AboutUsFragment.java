package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.R;

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
}
