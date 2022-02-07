package com.example.vocaenglish;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.databinding.DemoProfileBinding;

public class Demo_Fragment_Profile extends Fragment {

    DemoProfileBinding binding;

    public static Demo_Fragment_Profile newInstance() {
        
        Bundle args = new Bundle();
        
        Demo_Fragment_Profile fragment = new Demo_Fragment_Profile();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.demo_profile,container,false);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
        return binding.getRoot();


    }

}
