package test.aahz.com.mvcapp;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdaptor extends BaseAdapter {

    List<Profile> profiles;

    public CustomAdaptor(List<Profile> profiles) {
        this.profiles = profiles;
    }


    @Override
    public int getCount() {
        return profiles.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("PLANETS " , "getView Position =" + position);

        View v = convertView;
        if(v == null)  v = View.inflate(parent.getContext(), R.layout.item_view, null);

        ImageView photo = (ImageView) v.findViewById(R.id.photo);
        TextView f = (TextView) v.findViewById(R.id.text_f);
        TextView s = (TextView) v.findViewById(R.id.text_s);

        photo.setImageResource(profiles.get(position).getPhoto());
        f.setText(profiles.get(position).getfName());
        s.setText(profiles.get(position).getsName());

        return v;
    }
}
