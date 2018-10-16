package test.aahz.com.mvcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    List<Profile> profiles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.lv);

        final List<String> planets = new ArrayList<>(asList("Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn", "Uranus ", "Neptune", "X-planet"));

        lv.setAdapter(new CustomAdaptor(loadData()));

    }

    public List<Profile> loadData() {
//        for (int i =0; i < 1; i++) {
            profiles.add(new Profile(R.drawable.pl_mercury_x320, "Mercury", "2440\n  3.30e23\n  5.43\n  .11\n  -1.9\n   58.6"));
            profiles.add(new Profile(R.drawable.pl_venus_x320, "Venus", "6052\n  4.87e24\n  5.24\n  .65\n  -4.4\n -243 "));
            profiles.add(new Profile(R.drawable.pl_earth_x320, "Earth ", "6378\n  5.97e24\n  5.52\n  .30\n   -\n      0.99"));
            profiles.add(new Profile(R.drawable.pl_mars_x320, "Mars", "3397\n  6.42e23\n  3.93\n  .15\n  -2.0\n    1.03"));
            profiles.add(new Profile(R.drawable.pl_jupiter_x320, "Jupiter", "71492\n  1.90e27\n  1.33\n  .52\n  -2.7\n   0.41"));
            profiles.add(new Profile(R.drawable.pl_saturn_x320, "Saturn", "60268\n  5.68e26\n  0.69\n  .47\n   0.7\n    0.45"));
            profiles.add(new Profile(R.drawable.pl_uranus_x320, "Uranus ", "25559\n  8.68e25\n  1.32\n  .51\n   5.5\n   -0.72"));
            profiles.add(new Profile(R.drawable.pl_nepune_x320, "Neptune", "24766\n  1.02e26\n  1.64\n  .41\n   7.8\n    0.67"));
            profiles.add(new Profile(R.drawable.pl_pluto_x320, "Pluto", "1150\n  1.27e22\n  2.06\n  .55\n  13.6\n   -6.39"));
//        }
        return profiles;
    }
}
