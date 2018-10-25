package sql.aahz.com.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHandler dbh = new DbHandler(this);
        ListView  phones_lview =  (ListView) findViewById(R.id.phones_db_listview);

        Log.d("AAZ_DB", "Load data ...");

        dbh.addContact(new Contact("Snow Baba", "8029-447-45-47"));
        dbh.addContact(new Contact("Ded Moroz", "(666) 999-00-11"));
        dbh.addContact(new Contact("Snegurochka Moroz", "103"));

        Log.d("AAZ_DB", "Reading data ...");

        final List<Contact> contacts = dbh.showAllContacts();

        List<String> contactNames = new ArrayList<>();
        for(Contact contact: contacts) {contactNames.add(contact.get_name());}

        CustomAdapter adapter = new CustomAdapter(contacts);
        phones_lview.setAdapter(adapter);


        // Manual adapter for ListView
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contactNames);
//        phones_lview.setAdapter(adapter);
//
        phones_lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),contacts.get(position).get_name() + " has phone " + contacts.get(position).get_number(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        for(Contact c: contacts) {
            Log.d("AAZ_DB", c.get_id() + " Name: " + c.get_name() + " Phone: " + c.get_number());
        }
    }
}
