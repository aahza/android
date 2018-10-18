package test.aahz.com.intentapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    private static final int CAMERA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imvMain = findViewById(R.id.imageMain);
        switch (requestCode) {
            case CAMERA:
                Bitmap cameraImg = (Bitmap) data.getExtras().get("data");
                imvMain.setImageBitmap(cameraImg);
                break;
        }
    }
}
