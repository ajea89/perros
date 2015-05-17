package com.example.pyb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pyb.Beans.ProductType;
import com.example.pyb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 14/04/15.
 */
public class MenuTypeProductAdapter extends BaseAdapter {

    Context context;
    List<ProductType> productTypes;
    int images[];

    public MenuTypeProductAdapter(Context context, List<ProductType> productTypes) {
        this.context = context;
        this.productTypes = productTypes;

        images = new int[8];
        images[0] = R.drawable.entradas;
        images[1] = R.drawable.burritos;
        images[2] = R.drawable.burritos_cortes;
        images[3] = R.drawable.hotdogs;
        images[4] = R.drawable.postres;
        images[5] = R.drawable.cerveza;
        images[6] = R.drawable.cerveza_sabor;
        images[7] = R.drawable.bebidas;
    }

    @Override
    public int getCount() {
        return productTypes == null ? 0 : productTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return productTypes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_product_type_item_list, parent, false);

            holder = new ViewHolder();
            holder.tvProductTypeTitle = (TextView) convertView.findViewById(R.id.tv_product_type_title);
            holder.lyMenuProductType = (RelativeLayout) convertView.findViewById(R.id.ly_menu_product_type);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProductType productType = productTypes.get(position);

        holder.tvProductTypeTitle.setText(productType.getName());
        holder.lyMenuProductType.setBackgroundResource(images[position]);

        return convertView;
    }

    static class ViewHolder{
        TextView tvProductTypeTitle;
        RelativeLayout lyMenuProductType;
    }
}
