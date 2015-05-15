package com.example.pyb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pyb.Beans.Client;
import com.example.pyb.Beans.Order;
import com.example.pyb.Beans.Product;
import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.R;
import com.example.pyb.Utils.UserPreferences;

import java.util.List;

/**
 * Created by alan on 14/04/15.
 */
public class CarProductAdapter extends BaseAdapter {

    private Context context;
    private List<Product> products;
    private Client _user;
    private CatalogProductAdapterListener listener;

    public CarProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;

        UserPreferences userPreferences = new UserPreferences(context);
        _user = userPreferences.getPrefs();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewCarHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.car_item_list, parent, false);

            holder = new ViewCarHolder();
            holder.tvProductName = (TextView) convertView.findViewById(R.id.tv_car_product_name);
            holder.tvProductDescription = (TextView) convertView.findViewById(R.id.tv_car_product_description);
            holder.tvProductPrice = (TextView) convertView.findViewById(R.id.tv_car_product_price);
            holder.tvProductQuantity = (TextView) convertView.findViewById(R.id.tv_car_quantity);
            holder.ivAddCar = (ImageView) convertView.findViewById(R.id.iv_car_add);

            convertView.setTag(holder);
        }else {
            holder = (ViewCarHolder) convertView.getTag();
        }

        final Product product = products.get(position);

        holder.tvProductName.setText(product.getName());
        if (product.getDescription().equals(null) || product.getDescription().equals("null"))
            holder.tvProductDescription.setVisibility(View.GONE);
        else{
            holder.tvProductDescription.setVisibility(View.VISIBLE);
            holder.tvProductDescription.setText(product.getDescription());
        }

        holder.tvProductPrice.setText(String.valueOf(product.getPrice()));

        DbPyB db = new DbPyB(context);

        Order order = db.readOrder(product.getId(), _user.getId());
        if (order == null){
            holder.ivAddCar.setImageResource(R.mipmap.icon_car_off);
        }else {
            holder.ivAddCar.setImageResource(R.mipmap.icon_car_on);
            holder.tvProductQuantity.setText(""+order.getQuantity());
        }

        holder.ivAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onCarButtonSelected(v, position);
                }
            }
        });

        return convertView;
    }

    public CatalogProductAdapterListener getListener() {
        return listener;
    }

    public void setListener(CatalogProductAdapterListener listener) {
        this.listener = listener;
    }

    static class ViewCarHolder{
        TextView tvProductName;
        TextView tvProductDescription;
        TextView tvProductPrice;
        TextView tvProductQuantity;
        ImageView ivAddCar;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public interface CatalogProductAdapterListener{
        public void onCarButtonSelected(View v, int position);
    }
}
