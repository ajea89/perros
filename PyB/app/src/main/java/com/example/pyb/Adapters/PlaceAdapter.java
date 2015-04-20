package com.example.pyb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pyb.Beans.Place;
import com.example.pyb.R;

import java.util.List;

/**
 * Created by Alan on 19/04/2015.
 */
public class PlaceAdapter extends BaseAdapter {

    Context context;
    List<Place> places;

    public PlaceAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    @Override
    public int getCount() {
        return places == null ? 0 : places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PlaceHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.places_item_list_layout, parent, false);

            holder = new PlaceHolder();
            holder.tvPlaceName = (TextView) convertView.findViewById(R.id.tv_place_name);
            holder.tvPlaceAddrees = (TextView) convertView.findViewById(R.id.tv_place_addrees);
            holder.tvPlacePhone = (TextView) convertView.findViewById(R.id.tv_place_phone);

            convertView.setTag(holder);
        }else {
            holder = (PlaceHolder) convertView.getTag();
        }

        Place place = places.get(position);

        holder.tvPlaceName.setText(place.getName());
        holder.tvPlaceAddrees.setText(place.getAddrees());
        holder.tvPlacePhone.setText(place.getPhone());

        return convertView;
    }

    static class PlaceHolder{
        TextView tvPlaceName;
        TextView tvPlaceAddrees;
        TextView tvPlacePhone;
    }
}
