package com.example.pyb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pyb.Beans.Product;
import com.example.pyb.R;

import java.util.List;

/**
 * Created by alan on 14/04/15.
 */
public class MenuProductAdapter extends BaseAdapter {

    Context context;
    List<Product> products;

    public MenuProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products == null ? 0 : products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_product_item_list, parent, false);

            holder = new ViewHolder();
            holder.tvProductName = (TextView) convertView.findViewById(R.id.tv_product_name);
            holder.tvProductDescription = (TextView) convertView.findViewById(R.id.tv_product_description);
            holder.tvProductPrice = (TextView) convertView.findViewById(R.id.tv_product_price);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = products.get(position);

        holder.tvProductName.setText(product.getName());
        if (product.getDescription().equals(null) || product.getDescription().equals("null"))
            holder.tvProductDescription.setVisibility(View.GONE);
        else{
            holder.tvProductDescription.setVisibility(View.VISIBLE);
            holder.tvProductDescription.setText(product.getDescription());
        }

        holder.tvProductPrice.setText(String.valueOf(product.getPrice()));

        return convertView;
    }

    static class ViewHolder{
        TextView tvProductName;
        TextView tvProductDescription;
        TextView tvProductPrice;
    }
}
