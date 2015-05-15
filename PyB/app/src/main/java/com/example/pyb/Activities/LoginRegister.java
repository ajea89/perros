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
public class LoginRegister extends Activity {

    DbPyB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register_activity_layout);

        final EditText etRegisterUser = (EditText) findViewById(R.id.et_register_user);
        final EditText etRegisterPassword = (EditText) findViewById(R.id.et_register_password);
        final EditText etRegisterMail = (EditText) findViewById(R.id.et_register_mail);
        Button btLoginRegister = (Button) findViewById(R.id.bt_login_register);

        btLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = etRegisterMail.getText().toString();
                String user = etRegisterUser.getText().toString();
                String pass = etRegisterPassword.getText().toString();

                if (mail.length() > 0 && user.length() > 0 && pass.length() > 0){

                    if (isEmailValid(mail)){
                        db = new DbPyB(LoginRegister.this);

                        Client client = new Client();
                        client.setId(user);
                        client.setName(pass);
                        client.setMail(mail);

                        boolean flag = db.insertUpdateClient(client);

                        if (flag){
                            Toast.makeText(LoginRegister.this, "Usuario: "+client.getId()+"\nContraseña: "+client.getName()+"\nCorreo: "+client.getMail()+"\n\n¡Registrado!", Toast.LENGTH_LONG).show();
                            finish();
                        }else {
                            Toast.makeText(LoginRegister.this, "Usuario no registrado, intente más tarde", Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(LoginRegister.this, R.string.invaidMail, Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(LoginRegister.this, R.string.incompleteInfoToast, Toast.LENGTH_SHORT).show();
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
