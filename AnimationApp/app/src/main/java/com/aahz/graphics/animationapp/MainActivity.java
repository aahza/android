package com.aahz.graphics.animationapp;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable  evolutionAnimation;

    TextView helloTv;
    TextView animateText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTv = (TextView) findViewById(R.id.hello_id);
        animateText = (TextView) findViewById(R.id.animateTv);
        animateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;

                for (final Drawable drawable : textView.getCompoundDrawables()) {
                    if (drawable instanceof Animatable) {
                        ((Animatable) drawable).start();
                    }
                }            }
        });



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
