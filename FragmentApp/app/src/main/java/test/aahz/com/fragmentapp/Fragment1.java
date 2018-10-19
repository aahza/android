package test.aahz.com.fragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("AAZ", "onAttach");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("AAZ", "onActivityCreated");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("AAZ", "destroy View");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("AAZ", "onDetach");
    }
}
