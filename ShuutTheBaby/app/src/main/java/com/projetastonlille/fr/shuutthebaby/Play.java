package com.projetastonlille.fr.shuutthebaby;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by Quang on 30/05/2016.
 */
public class Play extends Menu{
    MediaPlayer mySound;
    int paused;
    //Declaration des listes
    private Map<String, Integer> soundMap = new HashMap<>();
//    private Map<String, Integer> timeMap; // Liste en bonus avec Timer ;)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        soundMap.put("L'enfant do", R.raw.enfantdo);
        soundMap.put("Machine à laver", R.raw.dryer );
        soundMap.put("Frere Jacques",R.raw.jacques);
        soundMap.put("Meunier",R.raw.meunier);

        final Spinner soundSpinner = (Spinner) findViewById(R.id.soundSpinner);

        List<String> names = new ArrayList<>(soundMap.keySet());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,names);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soundSpinner.setAdapter(dataAdapter);



    }

    public void playMusic(View view) {
        final Spinner soundSpinner = (Spinner) findViewById(R.id.soundSpinner);
        String selectedSound = (String)soundSpinner.getSelectedItem();

        int id = soundMap.get(selectedSound);

        if(mySound==null){
            mySound = MediaPlayer.create(this, id);
            mySound.setLooping(true);//Boucle de la musique a coupler avec un Timer ?
            mySound.start();

        }else if (!mySound.isPlaying()){
            mySound.seekTo(paused); // On cherche la valeur de paused pour relancer la musique a ce moment là.
            mySound.start();
        }
    }
    public void stopMusic(View view) {
        mySound.pause();
        paused = 0;
    }
    //METHOD() Pause à linstant INT et on recupere cette valer avec le .getCurrentPosition.
    public void pause(View view) {
        mySound.pause();
        paused=mySound.getCurrentPosition();
    }
}
