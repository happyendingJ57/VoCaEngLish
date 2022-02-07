package com.example.vocaenglish.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.List.chitiettuvung.Unit1_Activity_XemDanhSach;
import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.FragmentHomeUnit1Binding;

public class Fragment_Home_Unit1 extends Fragment {
    FragmentHomeUnit1Binding binding;
    public static Fragment_Home_Unit1 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment_Home_Unit1 fragment = new Fragment_Home_Unit1();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_unit1,container,false);
//Xem chi tiet danh sach
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
        binding.btnXemDanhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onFragment1(Unit1_Fragment_XemDanhSach.newInstance());
                startActivity(new Intent(getContext(), Unit1_Activity_XemDanhSach.class));
            }
        });
 //Vao hoc
        binding.btnVaoHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment1(
                        Unit_VaoHoc.newInstance());
            }
        });
        //Vao thi
          binding.btnVaoThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment1(Unit_VaoThi.newInstance());
            }
        });



        return binding.getRoot();
    }

    private void onFragment1(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.framelayout_unit1,fragment).commit();
    }
}
