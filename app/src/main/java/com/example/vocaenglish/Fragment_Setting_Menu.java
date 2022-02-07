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

import com.example.vocaenglish.databinding.FragmentSettingMenuBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Fragment_Setting_Menu extends Fragment {

    FragmentSettingMenuBinding binding;


    public static Fragment_Setting_Menu newInstance() {

        Bundle args = new Bundle();

        Fragment_Setting_Menu fragment = new Fragment_Setting_Menu();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_setting_menu,container,false);

        binding.idView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(Demo_Fragment_Profile.newInstance());
            }
        });

        binding.btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(Fragment_Setting_Menu_ThongBao.newInstance());
            }
        });

        binding.doimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(getContext(),Setting_doimatkhau.class));
            }
        });

        binding.idSettingDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(),LoginActivity.class));
            }
        });
        return binding.getRoot();
    }

    private  void onFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.Main_Fragment,fragment).commit();
    }
}
