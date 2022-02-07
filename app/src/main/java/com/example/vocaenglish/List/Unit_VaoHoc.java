package com.example.vocaenglish.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.List.vaohoc_nghe.Unit_VaoHoc_Activity_Nghe;
import com.example.vocaenglish.List.vaohoc_tuvung.Unit_VaoHoc_Activity_TuVung;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.UnitVaohocBinding;

public class Unit_VaoHoc extends Fragment {

    UnitVaohocBinding binding;
    public static Unit_VaoHoc newInstance() {

        Bundle args = new Bundle();

        Unit_VaoHoc fragment = new Unit_VaoHoc();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.unit_vaohoc, container, false);

        binding.btnVaohoctuVung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Unit_VaoHoc_Activity_TuVung.class));
            }
        });


        binding.btnVaohocnghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Unit_VaoHoc_Activity_Nghe.class));
            }
        });


        return binding.getRoot();
    }

    private void onFragment2(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.framelayout_unit1, fragment).commit();
    }
}
