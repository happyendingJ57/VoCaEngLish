package com.example.vocaenglish.luyentap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vocaenglish.List.chitiettuvung.TuVung;
import com.example.vocaenglish.R;

import java.util.List;

public class AdapterTuVungLuyenTap extends BaseAdapter {

    List<TuVung_LuyenTap> tuVung_luyenTapList;

    public AdapterTuVungLuyenTap(List<TuVung_LuyenTap> tuVung_luyenTapList) {
        this.tuVung_luyenTapList = tuVung_luyenTapList;
    }

    @Override
    public int getCount() {
        return tuVung_luyenTapList.size();
    }

    @Override
    public Object getItem(int i) {
        return tuVung_luyenTapList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view1 = inflater.inflate(R.layout.item_tuvung_luyentap,viewGroup,false);

        TextView tv_tuVung = view1.findViewById(R.id.tuVungLuyenTap);
        TextView tv_dichNghia = view1.findViewById(R.id.nghiaLuyenTap);


        TuVung_LuyenTap tuVung = tuVung_luyenTapList.get(i);


        tv_tuVung.setText(tuVung.getTuVung());
        tv_dichNghia.setText(tuVung.getDichNghia());

        return view1;
    }
}
