package com.example.vocaenglish.List;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.List.Fragment_Home_Unit1;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.ActivityUnit1Binding;

public class Unit1_Activity extends AppCompatActivity {
    ActivityUnit1Binding binding;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_unit1);

        onFragment(Fragment_Home_Unit1.newInstance());
        getSupportActionBar().hide();

    }
    private void onFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_unit1,fragment).commit();
    }
}
