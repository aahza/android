package test.aahz.com.mvcapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter {
    Context mContext;

    public ImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 40;
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
        Log.d("GRID ---", "position " + position);
        ImageView v = new ImageView(mContext);
//        v.setImageResource(R.drawable.the_planet_x);
        v.setImageResource(android.R.drawable.star_big_on);
        return v;
    }
}
