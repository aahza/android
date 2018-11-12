package com.aahz.graphics.animationapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable  evolutionAnimation;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView evoImage = (ImageView) findViewById(R.id.evoView);
        evoImage.setBackgroundResource(R.drawable.evolution_man);
        evolutionAnimation = (AnimationDrawable) evoImage.getBackground();

        evoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (evolutionAnimation.isRunning()) {
                    evolutionAnimation.stop();
                } else {
                    evolutionAnimation.start();
                }
            }
        });
    }
}
