package com.example.pyb.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pyb.R;

/**
 * Created by alan on 18/03/15.
 */
public class CatalogPopularFragment extends BaseFragment {

    public static CatalogPopularFragment newIntance (){
        CatalogPopularFragment fragment = new CatalogPopularFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.catalog_popular_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}