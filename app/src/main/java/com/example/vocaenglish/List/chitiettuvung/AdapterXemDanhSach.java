package com.example.vocaenglish.List.chitiettuvung;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.vocaenglish.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdapterXemDanhSach extends BaseAdapter implements Filterable {
    List<TuVung> tuVungList;
    List<TuVung> tuVungListAll;

    public AdapterXemDanhSach(List<TuVung> tuVungList) {
        this.tuVungList = tuVungList;
        this.tuVungListAll = tuVungList;
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
        View view1 = inflater.inflate(R.layout.item_tuvung, viewGroup, false);
        TextView tv_tuVung = view1.findViewById(R.id.unit_tenchude);
        // Button btn_Loa = view1.findViewById(R.id.unit_btntt_loa);
        //  TextView tv_phienAm = view1.findViewById(R.id.unit_tv_phienAm);
        TextView tv_dichNghia = view1.findViewById(R.id.unit_dichNghia);
        // ImageView img_MH = view1.findViewById(R.id.unit_img_Minhhoa);
        // TextView tv_Example = view1.findViewById(R.id.unit_tv_vidu);
        TuVung tuVung = tuVungList.get(i);
        tv_tuVung.setText(tuVung.getTuVung());
        // tv_phienAm.setText(tuVung.getPhienAm());
        tv_dichNghia.setText(tuVung.getDichNghia());
        //  btn_Loa.setText(tuVung.getPhatAm());
        // Picasso.with(view1.getContext()).load(tuVung.getImg()).into(img_MH);
        // tv_Example.setText(tuVung.getExample());
        return view1;
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if(strSearch.isEmpty()){
                    tuVungList = tuVungListAll;
                }
                else{
                    List<TuVung> list = new ArrayList<>();
                    for(TuVung tuVung :tuVungListAll){
                        if(tuVung.getTuVung().toLowerCase(Locale.ROOT).contains(strSearch.toLowerCase(Locale.ROOT))){
                            list.add(tuVung);
                        }
                    }
                    tuVungList = list;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = tuVungList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                tuVungList = (List<TuVung>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
