package com.example.pyb.Beans;

/**
 * Created by alan on 10/03/15.
 */
public class NavigationDrawerItem {

    private String name;
    private int iconId;

    public NavigationDrawerItem(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
