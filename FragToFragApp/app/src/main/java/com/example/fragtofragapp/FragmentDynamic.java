package com.example.fragtofragapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class FragmentDynamic extends Fragment implements View.OnClickListener{

    private static int clicks_active = 0;
    private static int clicks_dynamic = 0;

    private TextView textView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ex_003_second_fragment, null);
        textView = view.findViewById(R.id.dynamic_text);
        button = view.findViewById(R.id.dynamic_btn);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
//        Button activityBtn = getActivity().findViewById(R.id.activity_btn);
//        activityBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clicks_active ++;
//                textView.setText("Set from Activity" + clicks_active);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.static_fragment);
        TextView textView = fragment.getView().findViewById(R.id.static_text);
        clicks_dynamic ++;
        textView.setText("Text from Dynamic Fragment" + clicks_dynamic);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.dynamic_fragment_menu, menu);
    }
}
