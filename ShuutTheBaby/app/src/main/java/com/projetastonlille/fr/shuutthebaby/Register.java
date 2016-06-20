package com.projetastonlille.fr.shuutthebaby;

import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projetastonlille.fr.shuutthebaby.database.Database;
import com.projetastonlille.fr.shuutthebaby.database.User;
import com.projetastonlille.fr.shuutthebaby.database.UsersDataSource;

/**
 * Created by Pierre on 30/05/2016.
 */
public class Register extends Menu  {

    private UsersDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        datasource = new UsersDataSource(this);


        Button buttonRegisterToDatabase = (Button) findViewById(R.id.registerToDatabaseButton);
        buttonRegisterToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Register.this.addUser();
               
            }

        });

    }

    public int addUser(){

        User user = new User();
        EditText login = (EditText)findViewById(R.id.nameRegister);
        String loginString = login.getText().toString();
        EditText pwd = (EditText)findViewById(R.id.pwdRegister);
        String pwdString = pwd.getText().toString();
        EditText email = (EditText)findViewById(R.id.emailRegister);
        String emailString = email.getText().toString();
        EditText fn = (EditText)findViewById(R.id.firstNameRegister);
        String fnString = fn.getText().toString();
        EditText ln = (EditText)findViewById(R.id.lastNameRegister);
        String lnString = ln.getText().toString();

        user.setLogin(loginString);
        user.setPassword(pwdString);
        user.setEmail(emailString);
        user.setFirst_name(fnString);
        user.setLast_name(lnString);

        datasource.open();
        datasource.createUser(user);
        datasource.close();

        //System.out.println(user.toString());
        //String logTest = login.getText().toString();
        //String pwdTest = pwd.getText().toString();
        //String mailTest = email.getText().toString();
        //String fnTest = fn.getText().toString();
        //String lnTest = ln.getText().toString();
        //System.out.println(logTest);
    return 1;
    }
}
