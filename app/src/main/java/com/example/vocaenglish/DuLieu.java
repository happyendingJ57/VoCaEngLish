package com.example.vocaenglish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vocaenglish.databinding.ActivityDulieuBinding;

public class DuLieu extends AppCompatActivity {

    ActivityDulieuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dulieu);
        getSupportActionBar().hide();

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getBaseContext(),MainActivity.class));
            }
        });
    }

}