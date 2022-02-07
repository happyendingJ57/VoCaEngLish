package com.example.vocaenglish.List.vaohoc_nghe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.vocaenglish.List.chitiettuvung.TuVung;

import java.util.List;

public class ViewPagerAdaper extends FragmentStatePagerAdapter {

    List<TuVung> mlistTuVung;
    public ViewPagerAdaper( FragmentManager fm, int behavior , List<TuVung> list) {
        super(fm, behavior);
        this.mlistTuVung = list;
    }


    @Override
    public Fragment getItem(int position) {
        if(mlistTuVung == null || mlistTuVung.isEmpty())
            return null;

        TuVung tuVung = mlistTuVung.get(position);
       VaoHoc_Nghe_Fragment ngheFragment = new VaoHoc_Nghe_Fragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("vaohoc_nghe",tuVung);

        ngheFragment.setArguments(bundle);
        return  ngheFragment;
    }

    @Override
    public int getCount() {
        if(mlistTuVung != null)
            return mlistTuVung.size();

        return 0;
    }
}
