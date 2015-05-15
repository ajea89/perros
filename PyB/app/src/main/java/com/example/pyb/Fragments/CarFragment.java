package com.example.pyb.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pyb.Adapters.CarProductAdapter;
import com.example.pyb.Beans.Client;
import com.example.pyb.Beans.Order;
import com.example.pyb.Beans.Price;
import com.example.pyb.Beans.Product;
import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.R;
import com.example.pyb.Utils.CarManager;
import com.example.pyb.Utils.UserPreferences;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * Created by alan on 13/04/15.
 */
public class CarFragment extends BaseFragment {

    public static CarFragment newInstance(){
        CarFragment carFragment = new CarFragment();
        return carFragment;
    }

    private Client _user;
    private DbPyB db;
    private TextView tvEmpyOrders;
    private List<Product> products;
    private ArrayList<Order> orders;
    private CarProductAdapter adapter;

    private TextView tvCarSubtotal;
    private TextView tvCarDescuento;
    private TextView tvCarTotal;
    private DecimalFormat df = new DecimalFormat("###,###,##0.00");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.car_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        UserPreferences up = new UserPreferences(getActivity());
        _user = up.getPrefs();

        db = new DbPyB(getActivity());
        ListView listView = (ListView) findViewById(R.id.list_order);
        tvEmpyOrders = (TextView) findViewById(R.id.tv_empy_orders);
        tvCarSubtotal = (TextView) findViewById(R.id.tv_car_subtotal);
        tvCarDescuento = (TextView) findViewById(R.id.tv_car_descuento);
        tvCarTotal = (TextView) findViewById(R.id.tv_car_total);

        orders = db.readAllOrdersByClientId(_user.getId());
        if (orders != null){
            tvEmpyOrders.setVisibility(View.GONE);
            products = new ArrayList<>();

            for (Order orden : orders){
                ArrayList<Product> productsOrden = db.readProducts(orden.getProductId(), 0);
                if (productsOrden != null){
                    for (Product p : productsOrden){
                        products.add(p);
                    }
                }
            }

            adapter = new CarProductAdapter(getActivity(),products);

            adapter.setListener(new CarProductAdapter.CatalogProductAdapterListener() {
                @Override
                public void onCarButtonSelected(View v, int position) {

                    Product productSelected = products.get(position);

                    ImageView ibAddCar = (ImageView) v;
                    DbPyB db = new DbPyB(getActivity());
                    Order order = db.readOrder(productSelected.getId(), _user.getId());

                    if (order == null){

                        order = new Order();
                        order.setId(String.valueOf(productSelected.getId()));
                        order.setClientId(_user.getId());
                        order.setProductId(productSelected.getId());

                        db.insertUpdateOrder(order);
                        ibAddCar.setImageResource(R.mipmap.icon_car_on);
                        Toast.makeText(getActivity(), productSelected.getName() + " agregado(a) a orden", Toast.LENGTH_SHORT).show();
                    }else {
                        db.deleteOrder(order);
                        ibAddCar.setImageResource(R.mipmap.icon_car_off);
                        Toast.makeText(getActivity(), productSelected.getName()+" eliminado(a) de orden", Toast.LENGTH_SHORT).show();
                    }
                    updatePedido();
                }
            });
            adapter.notifyDataSetChanged();

            AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
            animationAdapter.setAbsListView(listView);
            listView.setAdapter(animationAdapter);

            printPrices();
        }else {
            tvEmpyOrders.setVisibility(View.VISIBLE);
            printPrices();
        }

        Button btGenerateOrder = (Button) findViewById(R.id.bt_generate_order);
        btGenerateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (products != null){
                    for (Product p : products){
                        db.deleteOrderProductId(p.getId(),_user.getId());
                    }
                    updatePedido();

                    String alertDialogTitle = "Pedido";
                    String alertDialogMessage = "Su pedido ha sido creado, se le entregará en un promedio de 15 minutos.\n\n ¡Gracias!";
                    String alertDialogButtonText = "Aceptar";

                    final AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
                    adBuilder.setTitle(alertDialogTitle);
                    adBuilder.setMessage(alertDialogMessage);
                    adBuilder.setPositiveButton(alertDialogButtonText, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adBuilder.create();
                    adBuilder.show();
                }else {
                    Toast.makeText(getActivity(),"Agregue productos antes de ordenar", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void updatePedido() {

        orders = db.readAllOrdersByClientId(_user.getId());
        if (orders != null){
            tvEmpyOrders.setVisibility(View.GONE);
            products = null;
            products = new ArrayList<>();

            for (Order orden : orders){
                ArrayList<Product> productsOrden = db.readProducts(orden.getProductId(), 0);
                if (productsOrden != null){
                    for (Product p : productsOrden){
                        products.add(p);
                    }
                }
            }

            adapter.setProducts(products);
        }else {
            products = null;
            adapter.setProducts(products);
            tvEmpyOrders.setVisibility(View.VISIBLE);
        }
        adapter.notifyDataSetChanged();

        printPrices();
    }

    private void printPrices(){
        Price price = CarManager.calculatePrices(getActivity());
        tvCarSubtotal.setText(df.format(price.getSubtotal()));
        tvCarDescuento.setText(df.format(price.getDescuento()));
        tvCarTotal.setText(df.format(price.getTotal()));
    }
}
