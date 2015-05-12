package com.example.pyb.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pyb.Beans.Client;
import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.R;

import java.util.ArrayList;

/**
 * Created by alan on 6/04/15.
 */
public class Login extends Activity {

    DbPyB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);

        final EditText etLoginUser = (EditText) findViewById(R.id.et_login_user);
        final EditText etLoginPassword = (EditText) findViewById(R.id.et_login_password);
        Button  btLoginMissedPassword = (Button) findViewById(R.id.bt_login_missed_password);
        Button btLoginEnterAccount = (Button) findViewById(R.id.bt_login_enter_account);


        btLoginEnterAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = etLoginUser.getText().toString();
                String password = etLoginPassword.getText().toString();

                if(user.length() > 0 && password.length() > 0){

                    db = new DbPyB(Login.this);
                    ArrayList<Client> clients = db.readClientLogin(user,password);

                    if (clients != null){
                        Intent intent = new Intent(Login.this, NavigationDrawer.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this,"Usuario y/o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Login.this,"Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btLoginMissedPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, LoginRecoverPassword.class);
                startActivity(intent);
            }
        });

    }
}
