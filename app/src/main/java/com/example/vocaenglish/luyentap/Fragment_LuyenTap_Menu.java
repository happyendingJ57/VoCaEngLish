package com.example.vocaenglish.luyentap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.List.chitiettuvung.AdapterXemDanhSach;
import com.example.vocaenglish.List.chitiettuvung.TuVung;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.FragmentLuyentapMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class Fragment_LuyenTap_Menu extends Fragment{

    FragmentLuyentapMenuBinding binding;
    SQLhelper sqLhelper;
    List<TuVung_LuyenTap> tuVung_luyenTapList;
    AdapterTuVungLuyenTap adapterTuVungLuyenTap;

    public static Fragment_LuyenTap_Menu newInstance(){
        Bundle args = new Bundle();
        Fragment_LuyenTap_Menu fragment = new Fragment_LuyenTap_Menu();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_luyentap_menu,container,false);
        sqLhelper = new SQLhelper(getContext());
        tuVung_luyenTapList = sqLhelper.getAllContact();
        adapterTuVungLuyenTap= new AdapterTuVungLuyenTap(tuVung_luyenTapList);
        binding.listViewLuyenTap.setAdapter(adapterTuVungLuyenTap);

      binding.listViewLuyenTap.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
          @Override
          public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
              sqLhelper.delete(i);
              return false;
          }
      });

        return binding.getRoot();
    }

}
