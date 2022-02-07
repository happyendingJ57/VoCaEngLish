package com.example.vocaenglish.List.vaothi_nghe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.vocaenglish.APIClient;
import com.example.vocaenglish.List.chitiettuvung.TuVung;
import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.ActivityVaothiKetquaNgheBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VaoThi_KetQua_Nghe extends AppCompatActivity {

    ActivityVaothiKetquaNgheBinding binding;
    List<TuVung> listTuVung;
    AdapterListDapAnNghe adapterListNghe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_vaothi_ketqua_nghe);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

        binding.btnTrangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

        Intent intent = getIntent();
        String soTu1 = intent.getStringExtra("soTu");
        String tongSoTu1 = intent.getStringExtra("tongSoTu");


        //setTExt
        binding.tvSoTuNghe.setText(soTu1);
        binding.tvTongSoTuNghe.setText(tongSoTu1);


        getAPI();

       getSupportActionBar().hide();
    }
    public void getAPI(){
        Call<List<TuVung>> call = APIClient.create().onGetContactUnit1();
        call.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                listTuVung = response.body();


                binding.btnXemListNghe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.tvSttCau.setVisibility(View.VISIBLE);
                        binding.tvDapAnNghe.setVisibility(View.VISIBLE);
                        adapterListNghe= new AdapterListDapAnNghe(listTuVung);
                        binding.lvVaothiNghe.setAdapter(adapterListNghe);
                        binding.tvSttCau.setVisibility(View.VISIBLE);
                        binding.tvDapAnNghe.setVisibility(View.VISIBLE);
                    }
                });

            }
            @Override
            public void onFailure(Call<List<TuVung>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}