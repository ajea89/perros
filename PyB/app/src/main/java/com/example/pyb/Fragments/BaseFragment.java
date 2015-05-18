package com.example.pyb.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.pyb.R;


public class BaseFragment extends Fragment {

    String TAG = BaseFragment.class.getSimpleName();

    public View findViewById(int resource){
         try{return getView().findViewById(resource);}catch (Exception e){return null;}
    }


    public void addFragmentToBackStack(Fragment fragment, String tag, int container){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.in_fragment, R.anim.out_fragment, R.anim.out_fragment, R.anim.in_fragment);
        transaction.addToBackStack(tag);
        transaction.replace(container, fragment, tag).commit();
    }

    public void addFragmentToBackStack(Fragment fragment, String tag){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.in_fragment, R.anim.out_fragment, R.anim.in_fragment, R.anim.out_fragment);
        transaction.addToBackStack(tag);
        transaction.replace(R.id.content_frame, fragment, tag).commit();
    }

    public void replaceFragment(Fragment fragment, int container){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(container, fragment).commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}
