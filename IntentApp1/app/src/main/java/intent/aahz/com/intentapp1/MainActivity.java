package intent.aahz.com.intentapp1;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;

public class MainActivity extends AppCompatActivity {
    EditText emailAddressText;
    EditText subjectText;
    EditText messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailAddressText = (EditText) findViewById(R.id.editText);
        emailAddressText.setText("aazaleski@tut.by");

        subjectText = (EditText) findViewById(R.id.subjectText);
        subjectText.setText("Mobile message send from " + getDeviceName());
        subjectText.setScroller(new Scroller(getApplicationContext()));
        subjectText.setVerticalScrollBarEnabled(true);

        messageText = (EditText) findViewById(R.id.messageText);
        messageText.setText("Cheers,\n\nWith best regards,\n" + getDeviceName());
        messageText.setScroller(new Scroller(getApplicationContext()));
        messageText.setVerticalScrollBarEnabled(true);

        Button button = (Button) findViewById(R.id.button);
//        button.setActivated(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(Intent.EXTRA_EMAIL, new String[] {emailAddressText.getText().toString()})
                        .putExtra(Intent.EXTRA_SUBJECT, subjectText.getText().toString())
                        .putExtra(Intent.EXTRA_TEXT, messageText.getText().toString())
                );

            }
        });
    }

    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.toLowerCase().startsWith(manufacturer.toLowerCase())) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }


    private String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }
}
