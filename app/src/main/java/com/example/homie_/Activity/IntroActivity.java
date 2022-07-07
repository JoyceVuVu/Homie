package com.example.homie_.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homie_.R;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SPLASH_SCREEN = 3000;
    //Variables
    Animation logo_anim;
    ImageView logo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.intro_activity);

        //Animation
        logo_anim = AnimationUtils.loadAnimation(this,R.anim.logo_anim);

        //Hooks
        logo = findViewById(R.id.logo);
        logo.setOnClickListener(this);

        logo.setAnimation(logo_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(IntroActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
