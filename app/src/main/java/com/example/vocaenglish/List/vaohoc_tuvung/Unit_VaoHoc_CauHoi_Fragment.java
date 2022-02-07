package com.example.vocaenglish.List.vaohoc_tuvung;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vocaenglish.List.chitiettuvung.TuVung;
import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;

import java.io.IOException;

public class Unit_VaoHoc_CauHoi_Fragment extends Fragment {
    TextView tvCauHoi,tvDapAn,btnXemDapAn;
    View mView;
    Button btnHoanThanh;
    EditText etTraLoi;
    int dem = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.unit_vaohoc_cauhoi_fragment, container, false);

        tvCauHoi = mView.findViewById(R.id.tv_CauHoi);
        etTraLoi = mView.findViewById(R.id.et_TraLoi);
        btnHoanThanh = mView.findViewById(R.id.btn_HoanThanh);
        btnXemDapAn = mView.findViewById(R.id.btn_XemDapAn);
        tvDapAn = mView.findViewById(R.id.tv_DapAn);

        Bundle bundleSR = getArguments();

        if(bundleSR != null){
            TuVung tuVung = (TuVung) bundleSR.get("cau_hoi");
            if(tuVung != null){
                tvCauHoi.setText(tuVung.getDichNghia());
                tvDapAn.setText(tuVung.getTuVung());
            }
        }


        btnHoanThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dapan = tvDapAn.getText().toString();
                String traloi = etTraLoi.getText().toString();

                if(traloi.equalsIgnoreCase(dapan)){
                    Toast.makeText(getContext(), "Chúc mừng bạn đã trả lời đúng", Toast.LENGTH_SHORT).show();
                    etTraLoi.setTextColor(Color.GREEN);

                    String url = "https://i.eop.edu.vn/rs/congratulations0.mp3";
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
                else
                {
                    dem =dem +1;
                    Toast.makeText(getContext(), "Đáp án của bạn chưa chính xác", Toast.LENGTH_SHORT).show();
                    etTraLoi.setTextColor(Color.RED);
                    if(dem>=2){
                        btnXemDapAn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        btnXemDapAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(dem >=2){
                    tvDapAn.setTextColor(Color.BLACK);
                    etTraLoi.setTextColor(Color.BLACK);
                }
                else{
                    Toast.makeText(getContext(),"Vui lòng nhập đáp án  ít nhất 2 lần",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return mView;
    }
}