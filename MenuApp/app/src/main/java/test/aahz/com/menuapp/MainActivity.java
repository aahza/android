package test.aahz.com.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView helloTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTv = (TextView) findViewById(R.id.hello_text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.item1:
                helloTv.setText("Last menu item is Settings");
            Toast.makeText(getBaseContext(), "Settings is choosen", Toast.LENGTH_SHORT).show();
            break;

            case R.id.item2:
                helloTv.setText("Last menu item is Additions");

                Toast.makeText(getBaseContext(), "Additions is choosen", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
