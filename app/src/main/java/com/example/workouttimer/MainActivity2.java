package com.example.workouttimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
     Button btnstart,btnstop;
     ImageView icachor;
     int sound;
     Animation roundanchor;
    private MediaPlayer mediaPlayer;

    Chronometer timehere;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnstart=(Button)findViewById(R.id.btnstart);
        icachor=(ImageView)findViewById(R.id.icacchor);
        btnstop=(Button)findViewById(R.id.btnstop);
        timehere=(Chronometer)findViewById(R.id.timeclock);
        btnstop.setAlpha(0);
        //load Animation
        roundanchor= AnimationUtils.loadAnimation(this,R.anim.roundanchor);

        //button start
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icachor.startAnimation(roundanchor);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                 timehere.setBase(SystemClock.elapsedRealtime());
                 if(mediaPlayer==null) {
                     mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.back);
                    mediaPlayer.start();
                 }



                timehere.start();

            }

        });
        //stop button
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timehere.stop();
                btnstart.animate().alpha(1).translationY(0).setDuration(300).start();
                btnstop.animate().alpha(0).setDuration(300).start();
                stopPlayer();
                stopAnim();





            }

        });

    }
    public void stopAnim(){
         if(roundanchor!=null)
         {
             icachor.clearAnimation();

         }
    }
    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }



}