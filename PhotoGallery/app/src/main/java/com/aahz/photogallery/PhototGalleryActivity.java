package com.aahz.photogallery;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhototGalleryActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return PhotoGalleryFragment.newInstance();
    }
}
