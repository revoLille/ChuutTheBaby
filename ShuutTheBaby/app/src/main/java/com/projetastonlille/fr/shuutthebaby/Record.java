package com.projetastonlille.fr.shuutthebaby;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Quang on 30/05/2016.
 */
public class Record extends Menu {
    MediaRecorder recorder;
    MediaPlayer player;
    private String fileRecord = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);

    }

    public void startRecording(View view) {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(fileRecord);
        try {
            recorder.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
        recorder.start();



        Toast.makeText(this, "Recording", Toast.LENGTH_SHORT).show();
    }

    public void stopRecording(View view) {
        recorder.stop();
        recorder.release();
        recorder = null;


        Toast.makeText(Record.this, "End of the record", Toast.LENGTH_SHORT).show();
    }

    public void startPlaying(View view) throws IOException {
        MediaPlayer recSound = new MediaPlayer();
        recSound.setDataSource(fileRecord);
        recSound.prepare();
        recSound.start();

        Toast.makeText(Record.this, "Playing Audio", Toast.LENGTH_SHORT).show();
    }

    public void stopPlaying(View view){
        player.stop();
    }
}
