package com.example.pyb.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pyb.Beans.Client;

public class UserPreferences {

    Context context;

    public UserPreferences(Context context) {
        this.context = context;
    }

    public static final String PREFS_NAME = "USER_PREFS";

    public boolean addPreferences(Client user) {
        boolean userResult = false;

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        try {
            editor.putString("user", user.getId());
            editor.putString("password", user.getName());
            editor.putString("mail", user.getMail());

            editor.commit();
            userResult = true;

        } catch (Exception e) {
            userResult = false;
        }
        return userResult;
    }

    public Client getPrefs() {
        Client prefs = new Client();
        SharedPreferences settings;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        try {prefs.setId(settings.getString("user", null));}catch (Exception ignore){}
        try {prefs.setName(settings.getString("password", null));} catch (Exception ignore){}
        try {prefs.setMail(settings.getString("mail", null));} catch (Exception ignore){}

        return prefs;
    }

    public boolean cleanPrefs(){
        boolean flag;

        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        flag = editor.clear().commit();

        return flag;
    }
}
