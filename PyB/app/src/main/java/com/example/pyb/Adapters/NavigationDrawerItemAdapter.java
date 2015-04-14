package com.example.pyb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pyb.Beans.NavigationDrawerItem;
import com.example.pyb.R;

import java.util.List;


/**
 * Created by alan on 10/03/15.
 */
public class NavigationDrawerItemAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<NavigationDrawerItem> drawerItems;

    public NavigationDrawerItemAdapter(Context context, LayoutInflater inflater, List<NavigationDrawerItem> drawerItems) {
        this.context = context;
        this.inflater = inflater;
        this.drawerItems = drawerItems;
    }

    @Override
    public int getCount() {
        return drawerItems == null ? 0 : drawerItems.size() ;
    }

    @Override
    public Object getItem(int position) {
        return drawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = inflater.inflate(R.layout.navigation_drawer_item, null);
        }

        ImageView ivNavIcon = (ImageView) convertView.findViewById(R.id.iv_nav_icon);
        TextView tvNavName = (TextView) convertView.findViewById(R.id.tv_nav_name);

        NavigationDrawerItem item = drawerItems.get(position);

        if (item.getIconId()!=0)
            ivNavIcon.setImageResource(item.getIconId());

        tvNavName.setText(item.getName());

        return convertView;
    }
}
