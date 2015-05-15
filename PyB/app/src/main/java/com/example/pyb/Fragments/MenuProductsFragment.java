package com.example.pyb.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.pyb.Adapters.MenuProductAdapter;
import com.example.pyb.Beans.Client;
import com.example.pyb.Beans.Order;
import com.example.pyb.Beans.Product;
import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.R;
import com.example.pyb.Utils.UserPreferences;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 14/04/15.
 */
public class MenuProductsFragment extends BaseFragment {

    private static String KEY_ARG = "productType";

    public static MenuProductsFragment newInstance(int productType){

        MenuProductsFragment menuProductsFragment = new MenuProductsFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_ARG,productType);
        menuProductsFragment.setArguments(args);

        return menuProductsFragment;
    }

    private int productType;
    private Client _user;
    private DbPyB db;
    private NumberPicker np;
    private Order tmpOrder;

    private  String alertDialogPositiveButtonText = "Aceptar";
    private  String alertDialogNegativeButtonText = "Cancelar";
    private  String getAlertDialogTitle = "Cantidad";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_products_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        UserPreferences up = new UserPreferences(getActivity());

        productType = getArguments().getInt(KEY_ARG);
        _user = up.getPrefs();

        db = new DbPyB(getActivity());
        ListView listView = (ListView) findViewById(R.id.list_products);
        final List<Product> products = db.readProducts(0,productType+1);

        MenuProductAdapter adapter = new MenuProductAdapter(getActivity(),products);

        adapter.setListener(new MenuProductAdapter.CatalogProductAdapterListener() {
            @Override
            public void onCarButtonSelected(View v, int position) {

                final Product productSelected = products.get(position);

                final ImageView ibAddCar = (ImageView) v;
                tmpOrder = db.readOrder(productSelected.getId(), _user.getId());

                if (tmpOrder == null){

                    //pedir cantidad
                    final AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
                    adBuilder.setTitle(getAlertDialogTitle);

                    LayoutInflater inflater = getActivity().getLayoutInflater();
                    final View customView = inflater.inflate(R.layout.dialog_number_picker, null);

                    np = (NumberPicker) customView.findViewById(R.id.np_quantity);
                    setNumberPickerTextColor(np, getResources().getColor(R.color.blue));
                    np.setMaxValue(100);
                    np.setMinValue(1);
                    np.setWrapSelectorWheel(true);

                    adBuilder.setView(customView).setPositiveButton(alertDialogPositiveButtonText, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            tmpOrder = new Order();
                            tmpOrder.setId(String.valueOf(productSelected.getId()));
                            tmpOrder.setClientId(_user.getId());
                            tmpOrder.setProductId(productSelected.getId());
                            tmpOrder.setQuantity(np.getValue());

                            db.insertUpdateOrder(tmpOrder);
                            ibAddCar.setImageResource(R.mipmap.icon_car_on);
                            Toast.makeText(getActivity(), productSelected.getName()+" agregado(a) a orden", Toast.LENGTH_SHORT).show();

                        }
                    }).setNegativeButton(alertDialogNegativeButtonText, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adBuilder.create();
                    adBuilder.show();

                }else {
                    db.deleteOrder(tmpOrder);
                    ibAddCar.setImageResource(R.mipmap.icon_car_off);
                    Toast.makeText(getActivity(), productSelected.getName()+" eliminado(a) de orden", Toast.LENGTH_SHORT).show();
                }
            }
        });
        adapter.notifyDataSetChanged();

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);

    }

    public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color)
    {
        final int count = numberPicker.getChildCount();
        for(int i = 0; i < count; i++){
            View child = numberPicker.getChildAt(i);
            if(child instanceof EditText){
                try{
                    Field selectorWheelPaintField = numberPicker.getClass()
                            .getDeclaredField("mSelectorWheelPaint");
                    selectorWheelPaintField.setAccessible(true);
                    ((Paint)selectorWheelPaintField.get(numberPicker)).setColor(color);
                    ((EditText)child).setTextColor(color);
                    numberPicker.invalidate();
                    return true;
                }
                catch(NoSuchFieldException e){
                }
                catch(IllegalAccessException e){
                }
                catch(IllegalArgumentException e){
                }
            }
        }
        return false;
    }

}
