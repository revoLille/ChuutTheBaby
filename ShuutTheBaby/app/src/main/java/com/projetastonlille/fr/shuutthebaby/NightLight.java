package com.projetastonlille.fr.shuutthebaby;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Quang on 30/05/2016.
 */
public class NightLight extends Menu  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nightlight);

        Button btn = (Button) findViewById(R.id.rotate);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ImageView animationTarget = (ImageView) this.findViewById(R.id.testImage);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point);
        animationTarget.startAnimation(animation);

    }
}
