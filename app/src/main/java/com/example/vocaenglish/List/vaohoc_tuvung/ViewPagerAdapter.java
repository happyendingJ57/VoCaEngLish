package com.example.vocaenglish.List.vaohoc_tuvung;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.vocaenglish.List.chitiettuvung.TuVung;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<TuVung> mlistTuVung;
    public ViewPagerAdapter(FragmentManager fm, int behavior, List<TuVung> list) {
        super(fm, behavior);
        this.mlistTuVung = list;
    }

    @Override
    public Fragment getItem(int position) {
        if(mlistTuVung == null || mlistTuVung.isEmpty())
            return null;

        TuVung tuVung = mlistTuVung.get(position);
        Unit_VaoHoc_CauHoi_Fragment cauHoiFragment = new Unit_VaoHoc_CauHoi_Fragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("cau_hoi",tuVung);

        cauHoiFragment.setArguments(bundle);
        return  cauHoiFragment;
    }

    @Override
    public int getCount() {
        if(mlistTuVung != null)
        return mlistTuVung.size();

        return 0;
    }
}
