package com.projetastonlille.fr.shuutthebaby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projetastonlille.fr.shuutthebaby.babyphone.BabyPhone;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonPlay = (Button) findViewById(R.id.playButton);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Play.class);
                startActivity(intent);
            }
        });

        Button buttonRec = (Button) findViewById(R.id.recButton);
        buttonRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Record.class);
                startActivity(intent);
            }
        });

        Button buttonNightLight = (Button) findViewById(R.id.nightLightButton);
        buttonNightLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,NightLight.class);
                startActivity(intent);
            }
        });
        Button buttonbabyPhone = (Button) findViewById(R.id.babyPhoneButton);
        buttonbabyPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,BabyPhone.class);
                startActivity(intent);
            }
        });

        Button buttonLogin = (Button) findViewById(R.id.logInButton);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,LogIn.class);
                startActivity(intent);
            }
        });

        Button buttonAbout = (Button) findViewById(R.id.aboutButton);
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,About.class);
                startActivity(intent);
            }
        });

        Button buttonRegister = (Button) findViewById(R.id.registerButton);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Register.class);
                startActivity(intent);
            }
        });
    }
}




