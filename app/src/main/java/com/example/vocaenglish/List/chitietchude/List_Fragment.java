package com.example.vocaenglish.List.chitietchude;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.APIClient;
import com.example.vocaenglish.List.Unit1_Activity;
import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.ListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_Fragment extends Fragment {

    ListFragmentBinding binding;
    List<ChuDe>chuDes;
    AdapterChuDe adapterChuDe;
    private SearchView searchView;

    public static List_Fragment newInstance() {
        Bundle args = new Bundle();
        List_Fragment fragment = new List_Fragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
      binding = DataBindingUtil.inflate(inflater,R.layout.list_fragment,container,false);
        chuDes = new ArrayList<>();
        getAPI();
        binding.listviewListChuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i){
                case 0:
                    startActivity(new Intent(getContext(),Unit1_Activity.class));break;
                case 1:
                    Toast.makeText(getContext(), "Application Software has no data ", Toast.LENGTH_SHORT).show();break;
                case 2:
                    Toast.makeText(getContext(), "The Web has no data ", Toast.LENGTH_SHORT).show();break;
                case 3:
                    Toast.makeText(getContext(), "Databases has no data ", Toast.LENGTH_SHORT).show();break;
                case 4:
                    Toast.makeText(getContext(), "Technical incidents has no data ", Toast.LENGTH_SHORT).show();break;
                case 5:
                    Toast.makeText(getContext(), "Video conferencing has no data ", Toast.LENGTH_SHORT).show();break;
                case 6:
                    Toast.makeText(getContext(), "User manuals has no data yet", Toast.LENGTH_SHORT).show();break;
                case 7:
                    Toast.makeText(getContext(), "Emails has no data yet", Toast.LENGTH_SHORT).show();break;
                default:
                    Toast.makeText(getContext(), "Lua chon khong ton tai", Toast.LENGTH_SHORT).show();
            }
            }
        });
        return binding.getRoot();
    }

    public void getAPI(){
        Call<List<ChuDe>> call = APIClient.create().onGetContact();
        call.enqueue(new Callback<List<ChuDe>>() {

            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                chuDes = response.body();
                adapterChuDe = new AdapterChuDe(chuDes);
                binding.listviewListChuDe.setAdapter(adapterChuDe);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
