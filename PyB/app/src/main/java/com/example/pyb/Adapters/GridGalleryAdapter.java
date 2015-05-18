package com.example.pyb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.pyb.R;

/**
 * Created by Ajea on 18/05/2015.
 */
public class GridGalleryAdapter extends BaseAdapter {

    private int[] images;
    private Context context;

    public GridGalleryAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_gallery_adapter, parent, false);
            holder = new ImageHolder();
            holder.ivImage = (ImageView) convertView.findViewById(R.id.iv_image_gallery);

            convertView.setTag(holder);
        }else {
            holder = (ImageHolder) convertView.getTag();
        }

        holder.ivImage.setImageResource(images[position]);

        return convertView;
    }

    static class ImageHolder{
        ImageView ivImage;
    }
}
