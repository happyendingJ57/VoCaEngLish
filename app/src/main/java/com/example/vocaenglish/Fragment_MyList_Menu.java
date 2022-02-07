package com.example.vocaenglish;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.databinding.FragmentMylistMenuBinding;


public class Fragment_MyList_Menu extends Fragment {

    FragmentMylistMenuBinding binding;

    public static Fragment_MyList_Menu newInstance() {

        Bundle args = new Bundle();

        Fragment_MyList_Menu fragment = new Fragment_MyList_Menu();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mylist_menu, container, false);


        binding.btnTuvung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DuLieu.class));
            }
        });
        binding.btnNghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DuLieu.class));
            }
        });
        binding.btnCacthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DuLieu.class));
            }
        });
        binding.btnCautruc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DuLieu.class));
            }
        });
        binding.btnNguphap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DuLieu.class));
            }
        });


        return binding.getRoot();

    }
}
