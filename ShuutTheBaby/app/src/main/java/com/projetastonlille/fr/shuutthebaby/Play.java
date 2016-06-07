package com.projetastonlille.fr.shuutthebaby;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Quang on 30/05/2016.
 */
public class Play extends Menu{
    MediaPlayer mySound;
    int paused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
    }

    public void playMusic(View view) {
        if(mySound==null){
            mySound = MediaPlayer.create(this, R.raw.jacques);
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
