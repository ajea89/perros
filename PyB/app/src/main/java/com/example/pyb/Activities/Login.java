package com.example.pyb.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pyb.R;

/**
 * Created by alan on 6/04/15.
 */
public class Login extends Activity {

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

                Intent intent = new Intent(Login.this, NavigationDrawer.class);
                startActivity(intent);

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
