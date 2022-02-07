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
import com.example.vocaenglish.databinding.ActivityVaothiTuvungBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VaoThi_TuVung extends AppCompatActivity {

    ActivityVaothiTuvungBinding binding;
    List<TuVung> mlistTuVung;
    int curent =0;
    int caudung = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_vaothi_tuvung);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
        getAPI();

        binding.btnHoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String TraLoi = binding.etTraloi.getText().toString();
                String DapAn = binding.tvDapAn.getText().toString();
                if(TraLoi.equalsIgnoreCase(DapAn)){
                    caudung++;
                    Toast.makeText(getBaseContext(), ""+caudung, Toast.LENGTH_SHORT).show();
                }
                curent++;
                if(curent<=mlistTuVung.size()-1){
                    binding.tvCauhoi.setText(mlistTuVung.get(curent).getDichNghia());
                    binding.tvDapAn.setText(mlistTuVung.get(curent).getTuVung());
                    binding.etTraloi.setText("");
                    binding.dau.setText(""+(curent+1));
                    binding.cuoi.setText(""+mlistTuVung.size());
                }
                else{
                    String soTu =  String.valueOf(caudung);
                    String tongSoTu =  String.valueOf(mlistTuVung.size());

                    Intent intent = new Intent(getBaseContext(),VaoThi_KetQua_TuVung.class);
                    intent.putExtra("soTu",soTu);
                    intent.putExtra("tongSoTu",tongSoTu);
                    startActivity(intent);
                }

            }
        });



    getSupportActionBar().hide();
    }
    public void getAPI(){
        Call<List<TuVung>> call = APIClient.create().onGetContactUnit1();
        call.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                mlistTuVung = response.body();
                binding.tvCauhoi.setText(mlistTuVung.get(curent).getDichNghia());
                binding.tvDapAn.setText(mlistTuVung.get(curent).getTuVung());
                binding.dau.setText(""+(curent+1));
                binding.cuoi.setText(""+mlistTuVung.size());
            }
            @Override
            public void onFailure(Call<List<TuVung>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}