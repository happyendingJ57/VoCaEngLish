package com.example.vocaenglish.List.chitiettuvung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.ActivityUnit1ChiTietTuVungBinding;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class Unit1_Activity_ChiTietTuVung extends AppCompatActivity {


    ActivityUnit1ChiTietTuVungBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_unit1_chi_tiet_tu_vung);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

        TextView tvTuVung = findViewById(R.id.unit_tvtt_tuvung);
        TextView tvPhiemAm = findViewById(R.id.unit_tvtt_phienAm);
        TextView tvDichNghia = findViewById(R.id.unit_tvtt_dichNghia);
        TextView tvViDu = findViewById(R.id.unit_tvtt_vidu);
        ImageButton btnLoa = findViewById(R.id.unit_btntt_loa);
        ImageView imgAnh = findViewById(R.id.unit_imgtt_Minhhoa);

        //lay gia tri


        Intent intent = getIntent();
        String tuVungtt = intent.getStringExtra("tuVung");
        String phiemAmtt = intent.getStringExtra("phienAm");
        String dichNghiatt = intent.getStringExtra("dichNghia");
        String examplett = intent.getStringExtra("example");
        String imgtt = intent.getStringExtra("img");
        String btnLoatt = intent.getStringExtra("phatAm");


        //setTExt
        tvTuVung.setText(tuVungtt);
        tvPhiemAm.setText(phiemAmtt);
        tvDichNghia.setText(dichNghiatt);
        tvViDu.setText(examplett);
        Picasso.with(getBaseContext()).load(imgtt).into(imgAnh);


        btnLoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(btnLoatt);
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
}