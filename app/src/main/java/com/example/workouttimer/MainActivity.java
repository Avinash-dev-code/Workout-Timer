package com.example.workouttimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MediatorLiveData;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private TextView tvSplash,tvsubSplash;
   Animation atg,btnone,btntwo;
   ImageView ivsplash;
   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash=(TextView)findViewById(R.id.tvSplash);
        ivsplash=(ImageView)findViewById(R.id.ivsplash);
        tvsubSplash=(TextView)findViewById(R.id.tvsubSplash);
        btn=(Button)findViewById(R.id.btnget);
        //load animation
        atg= AnimationUtils.loadAnimation(this,R.anim.atg);
        btnone= AnimationUtils.loadAnimation(this,R.anim.btnone);
        btntwo= AnimationUtils.loadAnimation(this,R.anim.btntwo);
        //passing animation
        ivsplash.startAnimation(atg);
        tvSplash.startAnimation(btnone);
        tvsubSplash.startAnimation(btnone);
        btn.startAnimation(btntwo);
        //import fonts
        Typeface Mlight=Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium=Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular=Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");
        //passing fonts
        tvSplash.setTypeface(MRegular);
        tvsubSplash.setTypeface(Mlight);
        btn.setTypeface(MMedium);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(in);

            }
        });


    }
}