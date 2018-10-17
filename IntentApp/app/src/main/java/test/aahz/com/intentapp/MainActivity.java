package test.aahz.com.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "No action attached", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
