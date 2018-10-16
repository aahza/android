package com.aahz.test.dialogapp;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialog);
    }


    public void showDialog(View view) {
        DialogFragment dialog = new DataPickFragment();
        dialog.show(getSupportFragmentManager(), "DATA_PICKER");
    }
}
