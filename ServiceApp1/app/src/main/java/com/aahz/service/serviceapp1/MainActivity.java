package com.aahz.service.serviceapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    ProgressBar progressBar;
    Intent serviceIntent = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = (Switch) findViewById(R.id.switch1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    serviceIntent = new Intent(getApplicationContext(), SimpleService.class);
//                    progressBar.setProgress(0);
                    startService(serviceIntent);

                } else {
                    stopService(serviceIntent);
                }
            }
        });

    }
}
