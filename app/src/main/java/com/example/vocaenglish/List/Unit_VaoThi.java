package com.example.vocaenglish.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.List.vaothi_nghe.VaoThi_Nghe;
import com.example.vocaenglish.List.vaothi_tuvung.VaoThi_TuVung;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.UnitVaothiBinding;


public class Unit_VaoThi extends Fragment {
    
    
    UnitVaothiBinding binding;


    public static Unit_VaoThi newInstance() {
        
        Bundle args = new Bundle();
        
        Unit_VaoThi fragment = new Unit_VaoThi();
        fragment.setArguments(args);
        return fragment;
    }
    
    
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        
        binding = DataBindingUtil.inflate(inflater, R.layout.unit_vaothi,container,false);

        binding.btnVaohoctuVung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), VaoThi_TuVung.class));
            }
        });

        binding.btnVaohocnghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), VaoThi_Nghe.class));
            }
        });



        return binding.getRoot();
    }
}
