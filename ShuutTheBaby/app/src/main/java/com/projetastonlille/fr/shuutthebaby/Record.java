package com.projetastonlille.fr.shuutthebaby;

import android.app.Activity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Environment;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.util.Log;
import android.media.MediaRecorder;
import android.media.MediaPlayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Linne on 02/06/2016.
 */
public class Record extends Menu {
    private static final String LOG_TAG = "AudioRecordTest";
    private static String mFileName = null;
    private static int count=0;

    private MediaRecorder mRecorder = null;
    private MediaPlayer   mPlayer = null;


    // Methods Mediaplayer
    public void startPlaying(View view) {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    public void stopPlaying(View view) {
        mPlayer.release();
        mPlayer = null;
    }

    // Methods mediaRecord
    public void startRecording(View view) {
        count++;
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    public void stopRecording(View view) {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }


    public Record() {
        File folder =new File(Environment.getExternalStorageDirectory() + File.separator + "Chuutthebaby");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }
        mFileName = Environment.getExternalStorageDirectory().toString() +File.separator + "Chuutthebaby" + File.separator ;
        mFileName += "/babySong"+count+".3gp";

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
    }


}

