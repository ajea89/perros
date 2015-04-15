package com.example.pyb.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pyb.Adapters.MenuTypeProductAdapter;
import com.example.pyb.Beans.ProductType;
import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.R;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;

import java.util.List;

/**
 * Created by alan on 13/04/15.
 */
public class MenuFragment extends BaseFragment {

    public static MenuFragment newInstance(){
        MenuFragment menuFragment = new MenuFragment();
        return menuFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DbPyB db = new DbPyB(getActivity());
        ListView listMenu = (ListView) findViewById(R.id.list_menu);
        List<ProductType> productTypes = db.readProductTypes(0, true);

        MenuTypeProductAdapter adapter = new MenuTypeProductAdapter(getActivity(),productTypes);
        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listMenu);
        listMenu.setAdapter(animationAdapter);

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuProductsFragment fragment = MenuProductsFragment.newInstance(position);
                addFragmentToBackStack(fragment, "productType");
            }
        });

    }
}
