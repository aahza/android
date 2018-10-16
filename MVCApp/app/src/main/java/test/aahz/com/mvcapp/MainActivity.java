package test.aahz.com.mvcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = (GridView) findViewById(R.id.gridView);

        final List<String> planets = new ArrayList<>(asList("Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn", "Uranus ", "Neptune", "X-planet"));

        gv.setAdapter(new ImageAdapter(this));

    }
}
