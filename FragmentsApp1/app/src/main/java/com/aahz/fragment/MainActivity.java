package com.aahz.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ArticleListFragment articleListFragment = new ArticleListFragment();
            fragmentTransaction.add(R.id.content, articleListFragment);

            ArticleReaderFragment articleReaderFragment = new ArticleReaderFragment();
            fragmentTransaction.add(R.id.content, articleReaderFragment);

            fragmentTransaction.commit();
        }
    }
}
