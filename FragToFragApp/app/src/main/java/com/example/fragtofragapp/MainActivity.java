package com.example.fragtofragapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static int clicks = 0;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.activity_text);

        initDynamicFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.static_fragment);
        Button button = fragment.getView().findViewById(R.id.static_btn);
        button.setOnClickListener(this);
    }

    private void initDynamicFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.dynamic_fragment, new FragmentDynamic());
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        clicks ++;
        textView.setText("Text from Static Fragment" + clicks);
    }
}
