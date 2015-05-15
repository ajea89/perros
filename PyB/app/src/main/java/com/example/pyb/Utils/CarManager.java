package com.example.pyb.Utils;

import android.content.Context;

import com.example.pyb.Beans.Order;
import com.example.pyb.Beans.Price;
import com.example.pyb.Beans.Product;
import com.example.pyb.DataBase.DbPyB;

import java.util.ArrayList;

/**
 * Created by Ajea on 15/05/2015.
 */
public class CarManager {

    public static Price calculatePrices(Context context){
        Price price = new Price();
        DbPyB db = new DbPyB(context);
        UserPreferences sp = new UserPreferences(context);
        float subtotal = 0;
        float total = 0;
        float descuento = 0;
        float desc = (float) 0.05;

        ArrayList<Order> orders = db.readAllOrdersByClientId(sp.getPrefs().getId());
        ArrayList<Product> products;

        if (orders != null){
            products = new ArrayList<>();
            for (Order o : orders){
                Product product = db.readProducts(o.getProductId(),0).get(0);
                products.add(product);
            }

            for (int i = 0; i < orders.size(); i++){
                subtotal = subtotal + (orders.get(i).getQuantity() * (float)products.get(i).getPrice());
                descuento = descuento + ((orders.get(i).getQuantity() * (float)products.get(i).getPrice()) * desc);
            }

            price.setSubtotal(subtotal);
            price.setDescuento(descuento);
            price.setTotal(subtotal-descuento);

        }else {
            price.setTotal(total);
            price.setSubtotal(subtotal);
            price.setDescuento(descuento);
        }

        return price;
    }
}
