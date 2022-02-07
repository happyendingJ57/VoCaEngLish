package com.example.vocaenglish.List.vaothi_nghe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.vocaenglish.APIClient;
import com.example.vocaenglish.List.chitiettuvung.TuVung;
import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.ActivityVaothiNgheBinding;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VaoThi_Nghe extends AppCompatActivity {

    ActivityVaothiNgheBinding binding;
    List<TuVung> mlistTuVung;
    int curent =0;
    int caudung = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_vaothi_nghe);
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
                }
                curent++;
                if(curent<=mlistTuVung.size()-1){
                    binding.tvDapAn.setText(mlistTuVung.get(curent).getTuVung());
                    binding.etTraloi.setText("");
                    binding.dau.setText(""+(curent+1));
                    binding.cuoi.setText(""+mlistTuVung.size());

                }
                else{
                    startActivity(new Intent(getBaseContext(),VaoThi_KetQua_Nghe.class));
                    String soTu =  String.valueOf(caudung);
                    String tongSoTu =  String.valueOf(mlistTuVung.size());
                    Intent intent = new Intent(getBaseContext(),VaoThi_KetQua_Nghe.class);
                    intent.putExtra("soTu",soTu);
                    intent.putExtra("tongSoTu",tongSoTu);
                    startActivity(intent);
                }

            }
        });


        binding.btnLoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = mlistTuVung.get(curent).getPhatAm();
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
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