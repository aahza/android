package com.example.fragtofragapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static int clicks = 0;
    private final int MENU_ID = 1;

    private TextView textView;
    private Button activity_btn;
    private CheckBox chbAddDel;
    private CheckBox chbVisible;

    private Fragment dynamicFragment;
    private Fragment dataFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbAddDel = findViewById(R.id.chbAddDel);
        chbVisible = findViewById(R.id.chbVisible);
        chbAddDel.setOnClickListener(this);
        chbVisible.setOnClickListener(this);

        textView = findViewById(R.id.activity_text);
        activity_btn = findViewById(R.id.activity_btn);
        activity_btn.setOnClickListener(this);

        dynamicFragment = initDynamicFragment();
        currentFragment = dynamicFragment;

        dataFragment = DataFragment.getInstance("Data Fragment");
        currentFragment = dataFragment;

        getSupportFragmentManager().beginTransaction().replace(R.id.dynamic_fragment, dataFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.static_fragment);
        Button button = fragment.getView().findViewById(R.id.static_btn);
        button.setOnClickListener(this);
    }

    private Fragment initDynamicFragment() {
        Fragment fragment = new FragmentDynamic();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.dynamic_fragment, fragment);
        ft.commit();
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.static_btn :
                clicks ++;
                textView.setText("Text from Static Fragment" + clicks);
                break;
            case R.id.chbAddDel:
            case R.id.chbVisible:
                invalidateOptionsMenu();
                break;
            case R.id.activity_btn:
                currentFragment = (currentFragment == dynamicFragment) ? dataFragment : dynamicFragment;
                getSupportFragmentManager().beginTransaction().replace(R.id.dynamic_fragment, currentFragment)
                        .commit();
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_group, menu);
        menu.setGroupVisible(R.id.group_visible, chbVisible.isChecked());
        if (chbAddDel.isChecked()) {
            menu.add(0, MENU_ID, 0, "New ...")
                    .setIcon(android.R.drawable.ic_delete)
                    .setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT
                    );
        } else {
            menu.removeItem(MENU_ID);
        }
        return true;
    }
}
