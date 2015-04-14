package com.example.pyb.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.DataBase.FillDataBase;
import com.example.pyb.Beans.Product;
import com.example.pyb.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Splash extends Activity {

    Timer timer;
    DbPyB db;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        db = new DbPyB(this);

        ArrayList<Product> products = db.readProducts(0,5);
        if (products == null){
            FillDataBase fillDataBase = new FillDataBase(this);
            fillDataBase.execute();
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                starApp();
            }
        },3000,3000);
    }

    private void starApp() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null)
            timer.cancel();
    }

}
