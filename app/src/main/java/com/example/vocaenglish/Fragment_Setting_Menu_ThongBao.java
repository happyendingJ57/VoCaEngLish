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

import com.example.vocaenglish.databinding.FragmentSettingMenuThongbaoBinding;

public class Fragment_Setting_Menu_ThongBao extends Fragment {

    FragmentSettingMenuThongbaoBinding binding;


    public static Fragment_Setting_Menu_ThongBao newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment_Setting_Menu_ThongBao fragment = new Fragment_Setting_Menu_ThongBao();
        fragment.setArguments(args);
        return fragment;
    }
  
    
    
    
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {


      binding = DataBindingUtil.inflate(inflater,R.layout.fragment_setting_menu_thongbao,container,false);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
      return binding.getRoot();
    }
}
