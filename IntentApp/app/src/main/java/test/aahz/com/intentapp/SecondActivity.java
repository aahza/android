package test.aahz.com.intentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity  extends AppCompatActivity {

    TextView tv2;
    ImageView imv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv2 = (TextView) findViewById(R.id.txtV2);
        tv2.setText("Cat by default");

        try{
            String extra = getIntent().getStringExtra("string");
            if(extra != null|| (! extra.isEmpty()))
                tv2.setText(extra);
        } catch (Exception e) {e.printStackTrace();}

        imv = (ImageView) findViewById(R.id.imageView);

        imv.setImageResource(getIntent().getIntExtra("image", R.drawable.cat_background));

        //from bitmap
//        byte[] bImage = getIntent().getByteArrayExtra("byte_image");
//        Bitmap bitmap = BitmapFactory.decodeByteArray(bImage, 0, bImage.length);
//        imv.setImageBitmap(bitmap);
    }
}
