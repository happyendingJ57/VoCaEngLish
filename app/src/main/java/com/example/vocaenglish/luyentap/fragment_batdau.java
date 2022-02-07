package com.example.vocaenglish.luyentap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.FragmentBatdauluyentapBinding;

public class fragment_batdau extends Fragment {
    FragmentBatdauluyentapBinding binding;


    public static fragment_batdau newInstance() {

        Bundle args = new Bundle();

        fragment_batdau fragment = new fragment_batdau();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_batdauluyentap,container,false);

        binding.btnBatdauluyentap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), V_Main.class));
            }
        });
        return binding.getRoot();


    }
}
