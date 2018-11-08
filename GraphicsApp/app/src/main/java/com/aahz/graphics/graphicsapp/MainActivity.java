package com.aahz.graphics.graphicsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ZCanvas canvas;

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        canvas = new ZCanvas(this);

        setContentView(canvas);
    }
}
