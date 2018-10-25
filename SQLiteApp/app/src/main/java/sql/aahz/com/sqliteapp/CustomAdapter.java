package sql.aahz.com.sqliteapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    List<Contact> contactList = null;

    public CustomAdapter(List<Contact> contacts) {
        super();
        contactList = contacts;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null) v = View.inflate(parent.getContext(), R.layout.db_list_item, null);
        TextView t1 = (TextView) v.findViewById(R.id.text1);
        TextView t2 = (TextView) v.findViewById(R.id.text2);
        t1.setText(contactList.get(position).get_name());
        t2.setText(contactList.get(position).get_number());
        return v;
    }
}
