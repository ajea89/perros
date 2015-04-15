package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.pyb.Adapters.MenuProductAdapter;
import com.example.pyb.Beans.Product;
import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.R;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_products_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        productType = getArguments().getInt(KEY_ARG);

        DbPyB db = new DbPyB(getActivity());
        ListView listView = (ListView) findViewById(R.id.list_products);
        List<Product> products = db.readProducts(0,productType+1);

        MenuProductAdapter adapter = new MenuProductAdapter(getActivity(),products);
        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);
    }

}
