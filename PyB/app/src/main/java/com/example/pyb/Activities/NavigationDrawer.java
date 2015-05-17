package com.example.pyb.Activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pyb.Adapters.NavigationDrawerItemAdapter;
import com.example.pyb.Beans.NavigationDrawerItem;
import com.example.pyb.Fragments.AboutUsFragment;
import com.example.pyb.Fragments.CarFragment;
import com.example.pyb.Fragments.EventFragment;
import com.example.pyb.Fragments.GalleryFragment;
import com.example.pyb.Fragments.MenuFragment;
import com.example.pyb.Fragments.PlacesFragment;
import com.example.pyb.R;
import com.example.pyb.Utils.Constans;
import com.example.pyb.Utils.UserPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 7/04/15.
 */
public class NavigationDrawer extends ActionBarActivity implements android.support.v4.app.FragmentManager.OnBackStackChangedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ListView leftList;
    String[] navTitles;
    int currentSection = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_activity);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        leftList = (ListView) findViewById(R.id.list_menu);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }


        };

        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("");
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        navTitles = getResources().getStringArray(R.array.nav_titles);

        //lista de items para menu
        List<NavigationDrawerItem> drawerItems = new ArrayList<NavigationDrawerItem>();
        drawerItems.add(new NavigationDrawerItem(navTitles[0], 0));
        drawerItems.add(new NavigationDrawerItem(navTitles[1], 0));
        drawerItems.add(new NavigationDrawerItem(navTitles[2], 0));
        drawerItems.add(new NavigationDrawerItem(navTitles[3], 0));
        drawerItems.add(new NavigationDrawerItem(navTitles[4], 0));
        drawerItems.add(new NavigationDrawerItem(navTitles[5], 0));
        drawerItems.add(new NavigationDrawerItem(navTitles[6], 0));
        drawerItems.add(new NavigationDrawerItem(navTitles[7], 0));

        NavigationDrawerItemAdapter adapter = new NavigationDrawerItemAdapter(this, LayoutInflater.from(this),drawerItems);
        leftList.setAdapter(adapter);
        changeSection(0);

        leftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(Gravity.START);
                changeSection(position);
            }
        });

    }

    private void changeSection(int section) {

        Fragment fragment = null;

        if (section != currentSection){

            switch (section){

                case 0:
                    fragment = EventFragment.newInstance(Constans.HOME_FRAGMENT);
                    break;
                case 1:
                    fragment = AboutUsFragment.newInstance();
                    break;
                case 2:
                    fragment = GalleryFragment.newInstance();
                    break;
                case 3:
                    fragment = MenuFragment.newInstance();
                    break;
                case 4:
                    fragment = EventFragment.newInstance(Constans.EVENT_FRAGMENT);
                    break;
                case 5:
                    fragment = PlacesFragment.newInstance();
                    break;
                case 6:
                    fragment = CarFragment.newInstance();
                    break;
                case 7:
                    UserPreferences up = new UserPreferences(NavigationDrawer.this);
                    up.cleanPrefs();
                    finish();
                    break;
            }
        }

        if (fragment != null){

            int countBackStack = getSupportFragmentManager().getBackStackEntryCount();
            for (int i = 0 ; i<countBackStack ; i++){
                getSupportFragmentManager().popBackStack();
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment, null).commit();
            getSupportActionBar().setTitle(navTitles[section]);
        }
        currentSection = section;
    }

    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    private void shouldDisplayHomeUp() {
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
        drawerToggle.setDrawerIndicatorEnabled(!canback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //This method is called when the up button is pressed. Just the pop back stack.
        getSupportFragmentManager().popBackStack();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(Gravity.START)){
                drawerLayout.closeDrawer(Gravity.START);
                return false;
            }else{
                super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
