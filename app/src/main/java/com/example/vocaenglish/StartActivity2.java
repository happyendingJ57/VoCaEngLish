package com.example.vocaenglish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.vocaenglish.databinding.ActivityStart2Binding;

public class StartActivity2 extends AppCompatActivity {

    ActivityStart2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_start2);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    nextActivity();
            }
        },2000);
    }
    private void nextActivity() {
               startActivity(new Intent(getApplicationContext(),LoginActivity.class));
               finish();
    }
}