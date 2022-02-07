package com.example.vocaenglish.List.chitiettuvung;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.APIClient;
import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.Unit1FragmentXemdanhsachBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Unit1_Fragment_XemDanhSach extends Fragment {

    Unit1FragmentXemdanhsachBinding binding;
    List<TuVung> tuVungList;
    AdapterXemDanhSach adapterXemDanhSach;

    public static Unit1_Fragment_XemDanhSach newInstance() {

        Bundle args = new Bundle();

        Unit1_Fragment_XemDanhSach fragment = new Unit1_Fragment_XemDanhSach();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.unit1_fragment_xemdanhsach,container,false);

        tuVungList = new ArrayList<>();
        getAPI();

        return binding.getRoot();
    }

    public void getAPI(){
        Call<List<TuVung>> call = APIClient.create().onGetContactUnit1();
        call.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                tuVungList = response.body();
                adapterXemDanhSach= new AdapterXemDanhSach(tuVungList);
                binding.lvUnit.setAdapter(adapterXemDanhSach);

                binding.lvUnit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String tuVung =  tuVungList.get(i).getTuVung();
                        String phienAm =  tuVungList.get(i).getPhienAm();
                        String dichNghia =  tuVungList.get(i).getDichNghia();
                        String example=  tuVungList.get(i).getExample();
                        String img = tuVungList.get(i).getImg();
                        String phatAm = tuVungList.get(i).getPhatAm();

                        Intent intent = new Intent(getContext(), Unit1_Activity_ChiTietTuVung.class);
                        intent.putExtra("tuVung",tuVung);
                        intent.putExtra("phienAm",phienAm);
                        intent.putExtra("dichNghia",dichNghia);
                        intent.putExtra("example",example);
                        intent.putExtra("img",img);
                        intent.putExtra("phatAm",phatAm);
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void onFailure(Call<List<TuVung>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
