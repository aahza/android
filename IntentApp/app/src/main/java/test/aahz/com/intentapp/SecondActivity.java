package test.aahz.com.intentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity  extends AppCompatActivity {

    TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv2 = (TextView) findViewById(R.id.txtV2);
        tv2.setText(getIntent().getStringExtra("string"));
    }
}
