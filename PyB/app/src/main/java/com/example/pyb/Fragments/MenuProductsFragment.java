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
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;

import java.util.List;

/**
 * Created by alan on 14/04/15.
 */
public class MenuProductsFragment extends BaseFragment {

    public static MenuProductsFragment newInstance(){
        MenuProductsFragment menuProductsFragment = new MenuProductsFragment();
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

        DbPyB db = new DbPyB(getActivity());
        GridView gridView = (GridView) findViewById(R.id.grid_list_products);
        List<Product> products = db.readProducts(0,productType+1);

        MenuProductAdapter adapter = new MenuProductAdapter(getActivity(),products);
        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(gridView);
        gridView.setAdapter(animationAdapter);
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
