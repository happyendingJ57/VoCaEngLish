package com.example.vocaenglish.luyentap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vocaenglish.R;

import java.util.List;

public class V_Adapter extends BaseAdapter {

    List<V_TuVung> v_tuVungList;

    public V_Adapter(List<V_TuVung> v_tuVungList) {
        this.v_tuVungList = v_tuVungList;
    }

    @Override
    public int getCount() {
        return v_tuVungList.size();
    }

    @Override
    public Object getItem(int i) {
        return v_tuVungList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view1 = inflater.inflate(R.layout.item_tuvung, viewGroup, false);

        TextView tvName = view1.findViewById(R.id.unit_tenchude);
        TextView tvPN = view1.findViewById(R.id.unit_dichNghia);

        V_TuVung contact = v_tuVungList.get(i);

        tvName.setText(contact.getTuVung());
        tvPN.setText(contact.getDichNghia());

        return view1;
    }
}
