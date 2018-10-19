package test.aahz.com.intentapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {

    private static final int CAMERA = 100;
    private static final String F_NAME = "text_aaz.txt";
    private Bitmap cameraImg;
    ImageView imvMain;
    SharedPreferences preferences;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AAA", "Creating trying");

        if (savedInstanceState != null) {
            Bitmap bitmap = savedInstanceState.getParcelable("bitmap");
            imvMain.setImageBitmap(bitmap);
        }
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences( this.getLocalClassName() + "_online", MODE_PRIVATE);

        file = new File(getFilesDir(), F_NAME);

    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.button2:
//                Toast.makeText(getApplicationContext(), "No action attached", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("string", "I m from \n" + this.getClass().getName());

                // image as byte stream
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat_background);
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//                byte[] bImage = byteArrayOutputStream.toByteArray();
//                intent.putExtra("byte_image", bImage);

                intent.putExtra("image", R.drawable.cat0);
                startActivity(intent);
                break;
            case R.id.button3:
//                Toast.makeText(getApplicationContext(), "No action attached", Toast.LENGTH_SHORT).show();
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d("AAA", "Saving trying");

        BitmapDrawable drawable = (BitmapDrawable) imvMain.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        outState.putParcelable("bitmap", bitmap);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("AAA", "Restore trying");

    }

    @Override
    protected void onStop() {
        Log.d("AAA", "Stop trying");

        super.onStop();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imvMain = findViewById(R.id.imageMain);

        switch (requestCode) {
            case CAMERA:
                Log.d("AAA", "get intent");

                cameraImg = (Bitmap) data.getExtras().get("data");
                imvMain.setImageBitmap(cameraImg);
                Log.d("AAA", "set bitmap");

                break;
        }
    }

    public void writeFile(File file, byte[] bytes) {
        try(FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(bytes);
        } catch (Exception e) { e.printStackTrace();}
    }

    public void readFile(File file, byte[] bytes) {
        try(FileInputStream inputStream = new FileInputStream(file)) {
            inputStream.read(bytes);
        } catch (Exception e) { e.printStackTrace();}
    }
}
