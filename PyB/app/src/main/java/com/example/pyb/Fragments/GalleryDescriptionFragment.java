package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pyb.R;

/**
 * Created by Ajea on 18/05/2015.
 */
public class GalleryDescriptionFragment extends BaseFragment {

    private static String KEY_ARG = "image";
    private int[] images = {R.drawable.cerveza, R.drawable.cerveza_sabor, R.drawable.evento2, R.drawable.evento3, R.drawable.galeria1, R.drawable.galeria2, R.drawable.galeria3, R.drawable.galeria,R.drawable.cerveza, R.drawable.cerveza_sabor, R.drawable.evento2, R.drawable.evento3, R.drawable.galeria1, R.drawable.galeria2, R.drawable.galeria3, R.drawable.galeria};

    public static GalleryDescriptionFragment newInstance(int image){
        GalleryDescriptionFragment fragment = new GalleryDescriptionFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_ARG,image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_item_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView image = (ImageView)findViewById(R.id.iv_image_gallery_full);
        image.setImageResource(images[getArguments().getInt(KEY_ARG)]);
    }
}
