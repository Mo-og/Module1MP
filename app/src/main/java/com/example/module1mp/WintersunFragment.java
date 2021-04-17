package com.example.module1mp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


public class WintersunFragment extends Fragment {

    public WintersunFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ImageView img = view.findViewById(R.id.image);
        img.setImageResource(R.drawable.wintersun);
        return view;
    }
}