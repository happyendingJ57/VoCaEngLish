package com.example.vocaenglish.List.vaothi_tuvung;

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
import com.example.vocaenglish.databinding.ActivityVaothiKetquaBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VaoThi_KetQua_TuVung extends AppCompatActivity {

    ActivityVaothiKetquaBinding binding;
    List<TuVung> listTuVung;
    AdapterListTuVung adapterListTuVung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_vaothi_ketqua);
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
        binding.tvSoTu.setText(soTu1);
        binding.tvTongSoTu.setText(tongSoTu1);


        getAPI();

       getSupportActionBar().hide();


    }
    public void getAPI(){
        Call<List<TuVung>> call = APIClient.create().onGetContactUnit1();
        call.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                listTuVung = response.body();


                binding.btnXemListTuVung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.tvCauhoi.setVisibility(View.VISIBLE);
                        binding.tvDapAn.setVisibility(View.VISIBLE);
                        adapterListTuVung= new AdapterListTuVung(listTuVung);
                        binding.lvVaothiTuvung.setAdapter(adapterListTuVung);
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