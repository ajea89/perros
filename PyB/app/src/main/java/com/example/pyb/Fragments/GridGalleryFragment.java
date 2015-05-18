package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.pyb.Adapters.GridGalleryAdapter;
import com.example.pyb.R;
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingRightInAnimationAdapter;

/**
 * Created by Ajea on 18/05/2015.
 */
public class GridGalleryFragment extends BaseFragment {

    public static GridGalleryFragment newInstance(){
        GridGalleryFragment fragment = new GridGalleryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.grid_gallerry_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final int[] images = {R.drawable.thumb1, R.drawable.thumb2, R.drawable.thumb3, R.drawable.thumb4, R.drawable.thumb5, R.drawable.thumb6, R.drawable.thumb7, R.drawable.thumb8,R.drawable.thumb1, R.drawable.thumb2, R.drawable.thumb3, R.drawable.thumb4, R.drawable.thumb5, R.drawable.thumb6, R.drawable.thumb7, R.drawable.thumb8};

        GridView gallery = (GridView) findViewById(R.id.grid_gallery);
        GridGalleryAdapter adapter = new GridGalleryAdapter(images,getActivity());
        SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(gallery);
        gallery.setAdapter(animationAdapter);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GalleryDescriptionFragment fragment = GalleryDescriptionFragment.newInstance(position);
                addFragmentToBackStack(fragment,"gallery");
            }
        });
    }
}
