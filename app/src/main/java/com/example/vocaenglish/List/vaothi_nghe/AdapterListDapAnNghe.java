package com.example.vocaenglish.List.vaothi_nghe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vocaenglish.List.chitiettuvung.TuVung;
import com.example.vocaenglish.R;

import java.util.List;

public class AdapterListDapAnNghe extends BaseAdapter {

    List<TuVung> tuVungList;

    public AdapterListDapAnNghe(List<TuVung> tuVungList) {
        this.tuVungList = tuVungList;
    }

    @Override
    public int getCount() {
        return tuVungList.size();
    }

    @Override
    public Object getItem(int i) {
        return tuVungList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view1 = inflater.inflate(R.layout.item_list_dapan_vaothi_nghe,viewGroup,false);

        TextView stt = view1.findViewById(R.id.tv_list_stt_nghe);
        TextView tvDapan = view1.findViewById(R.id.tv_list_DapAn_nghe);

        TuVung tuvung = tuVungList.get(i);

        stt.setText(""+(i+1));
        tvDapan.setText(tuvung.getTuVung());

        return view1;
    }
}
