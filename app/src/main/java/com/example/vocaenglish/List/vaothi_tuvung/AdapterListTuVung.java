package com.example.vocaenglish.List.vaothi_tuvung;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vocaenglish.List.chitiettuvung.TuVung;
import com.example.vocaenglish.R;

import java.util.List;

public class AdapterListTuVung extends BaseAdapter {

    List<TuVung> list;

    public AdapterListTuVung(List<TuVung> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view1 = inflater.inflate(R.layout.item_list_dapan_vaothi_tuvung,viewGroup,false);

        TextView tvCauhoi = view1.findViewById(R.id.tv_list_cauhoi_tuVung);
        TextView tvDapan = view1.findViewById(R.id.tv_list_DapAn_tuvung);

        TuVung tuvung = list.get(i);

        tvCauhoi.setText(tuvung.getDichNghia());
        tvDapan.setText(tuvung.getTuVung());

        return view1;
    }
}
