package com.projetastonlille.fr.shuutthebaby;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projetastonlille.fr.shuutthebaby.database.Database;

/**
 * Created by Pierre on 30/05/2016.
 */
public class Register extends Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button buttonRegisterToDatabase = (Button) findViewById(R.id.registerToDatabaseButton);
        buttonRegisterToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(Register.this,Database.class);
                startActivity(intent);*/
            }
        });

    }

}
