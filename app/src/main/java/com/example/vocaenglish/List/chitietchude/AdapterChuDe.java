package com.example.vocaenglish.List.chitietchude;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vocaenglish.List.chitietchude.ChuDe;
import com.example.vocaenglish.R;
import com.squareup.picasso.Picasso;

import java.util.List;
public class AdapterChuDe extends BaseAdapter {

    List<ChuDe> chuDes;

    public AdapterChuDe(List<ChuDe> chuDes) {
        this.chuDes = chuDes;
    }

    @Override
    public int getCount() {
        return chuDes.size();
    }

    @Override
    public Object getItem(int i) {
        return chuDes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View viewnew = inflater.inflate(R.layout.item_chude,viewGroup,false);

        TextView tenChuDe = viewnew.findViewById(R.id.ten_ChuDe);
        TextView soTu = viewnew.findViewById(R.id.soTu_ChuDe);
        ImageView imgChuDe = viewnew.findViewById(R.id.img_ChuDe);

        ChuDe chuDe = chuDes.get(i);

        tenChuDe.setText(chuDe.getTenChuDe());
        soTu.setText(chuDe.getSoTu());
        Picasso.with(viewnew.getContext()).load(chuDe.getImgChuDe()).into(imgChuDe);

        return viewnew;
    }
}
