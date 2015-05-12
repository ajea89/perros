package com.example.pyb.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pyb.Beans.Client;
import com.example.pyb.DataBase.DbPyB;
import com.example.pyb.R;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alan on 7/04/15.
 */
public class LoginRecoverPassword extends Activity {

    DbPyB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_recover_activity_layout);

        final EditText etLoginRecoverMail = (EditText) findViewById(R.id.et_login_recover_mail);
        Button btLoginRecoverSend = (Button) findViewById(R.id.bt_login_recover_send);

        btLoginRecoverSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = etLoginRecoverMail.getText().toString();

                if (mail.length() > 0){

                    if (isEmailValid(mail)){
                        db = new DbPyB(LoginRecoverPassword.this);
                        ArrayList<Client> clients = db.readClientEmail(mail);

                        if (clients != null){
                            Toast.makeText(LoginRecoverPassword.this, "Usuario: "+clients.get(0).getId()+"\nContraseña: "+clients.get(0).getName(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(LoginRecoverPassword.this, "Correo no registrado", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(LoginRecoverPassword.this, R.string.invaidMail, Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(LoginRecoverPassword.this, R.string.incompleteMail, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
