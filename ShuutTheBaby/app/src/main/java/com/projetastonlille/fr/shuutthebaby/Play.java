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
import java.util.Timer;
import java.util.TimerTask;



/**
 * Created by Quang on 30/05/2016.
 */
public class Play extends Menu{
    MediaPlayer mySound;
    int paused;
    //Declaration des listes
    private Map<String, Integer> _soundMap = new HashMap<>();
    private Map<String, Integer> _timeMap = new HashMap<>();
//    private Map<String, Integer> timeMap; // Liste en bonus avec Timer ;)
    private Timer _timer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        _soundMap.put("L'enfant do", R.raw.enfantdo);
        _soundMap.put("Machine à laver", R.raw.dryer );
        _soundMap.put("Frere Jacques",R.raw.jacques);
        _soundMap.put("Meunier",R.raw.meunier);

        _timeMap.put(getResources().getString(R.string.disabled), 0);
        _timeMap.put(getResources().getString(R.string.time_1minute), 1000*60*1);
        _timeMap.put(getResources().getString(R.string.time_5minute), 1000*60*5);
        _timeMap.put(getResources().getString(R.string.time_10minute), 1000*60*10);
        _timeMap.put(getResources().getString(R.string.time_30minute), 1000*60*30);
        _timeMap.put(getResources().getString(R.string.time_1hour), 1000*60*60*1);
        _timeMap.put(getResources().getString(R.string.time_2hour), 1000*60*60*2);
        _timeMap.put(getResources().getString(R.string.time_4hour), 1000*60*60*4);
        _timeMap.put(getResources().getString(R.string.time_8hour), 1000*60*60*8);
///Spinner pour le Timer
        final Spinner timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        List<String> times = new ArrayList<>(_timeMap.keySet());
        ArrayAdapter<String> timesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, times);
        timesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timesAdapter);
///Spinner pour les musiques
        final Spinner soundSpinner = (Spinner) findViewById(R.id.soundSpinner);
        List<String> names = new ArrayList<>(_soundMap.keySet());
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,names);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soundSpinner.setAdapter(dataAdapter);
    }

    public void playMusic(final View view) {
        final Spinner soundSpinner = (Spinner) findViewById(R.id.soundSpinner);
        String selectedSound = (String)soundSpinner.getSelectedItem();
        int id  = _soundMap.get(selectedSound);

        final Spinner sleepTimeout = (Spinner) findViewById(R.id.timeSpinner);
        String selectTimeout = (String)sleepTimeout.getSelectedItem();
        int timeOut = _timeMap.get(selectTimeout);
        if(mySound==null){

            mySound = MediaPlayer.create(this,id);
            mySound.setLooping(true);//Boucle de la musique a coupler avec un Timer ?
            mySound.start();
            if(timeOut>0){
                _timer = new Timer();
                _timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mySound.stop();
                    }
                },(long)timeOut);
            }

        }else if (!mySound.isPlaying()){
            mySound.seekTo(paused); // On cherche la valeur de paused pour relancer la musique a ce moment là.
            mySound.start();
        }
    }
    public void stopMusic(View view) {
        mySound.pause();
        mySound.release();
        mySound = null;
        paused = 0;
    }
    //METHOD() Pause à linstant INT et on recupere cette valer avec le .getCurrentPosition.
    public void pause(View view) {
        mySound.pause();
        paused=mySound.getCurrentPosition();
    }
}
