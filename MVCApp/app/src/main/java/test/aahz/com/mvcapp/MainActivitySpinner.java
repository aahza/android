package test.aahz.com.mvcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivitySpinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp = (Spinner) findViewById(R.id.spinner);
        TextView textView = (TextView) findViewById(R.id.textView);

        final List<String> planets = new ArrayList<>(asList("Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn", "Uranus ", "Neptune", "X-planet"));

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, planets);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

//        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "Planet #" + position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
