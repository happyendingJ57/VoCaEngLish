package com.example.vocaenglish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


import com.example.vocaenglish.List.chitietchude.List_Fragment;
import com.example.vocaenglish.databinding.ActivityMainBinding;
import com.example.vocaenglish.luyentap.V_Main;
import com.example.vocaenglish.luyentap.fragment_batdau;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

       onFragment(List_Fragment.newInstance());

      binding.btnHome.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              onFragment(List_Fragment.newInstance());
              binding.imgBtnHome.setImageResource(R.drawable.home_yellow);
              binding.imgBtnStar.setImageResource(R.drawable.home_star_while);
              binding.imgBtnLearn.setImageResource(R.drawable.home_learn_while);
              binding.imgBtnSetting.setImageResource(R.drawable.home_setting_while);
              binding.txtHome.setTextColor(Color.YELLOW);
              binding.txtLuyentap.setTextColor(Color.WHITE);
              binding.txtLearn.setTextColor(Color.WHITE);
              binding.txtSetting.setTextColor(Color.WHITE);
          }
      });
      binding.btnLuyenTap.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              //startActivity(new Intent(getBaseContext(), V_Main.class));
              onFragment(fragment_batdau.newInstance());
              binding.imgBtnHome.setImageResource(R.drawable.home_while);
              binding.imgBtnStar.setImageResource(R.drawable.home_star_yellow);
              binding.imgBtnLearn.setImageResource(R.drawable.home_learn_while);
              binding.imgBtnSetting.setImageResource(R.drawable.home_setting_while);

              binding.txtHome.setTextColor(Color.WHITE);
              binding.txtLuyentap.setTextColor(Color.YELLOW);
              binding.txtLearn.setTextColor(Color.WHITE);
              binding.txtSetting.setTextColor(Color.WHITE);

          }
      });
      binding.btnMyList.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              binding.imgBtnHome.setImageResource(R.drawable.home_while);
              binding.imgBtnStar.setImageResource(R.drawable.home_star_while);
              binding.imgBtnLearn.setImageResource(R.drawable.home_learn_yellow);
              binding.imgBtnSetting.setImageResource(R.drawable.home_setting_while);


              binding.txtHome.setTextColor(Color.WHITE);
              binding.txtLuyentap.setTextColor(Color.WHITE);
              binding.txtLearn.setTextColor(Color.YELLOW);
              binding.txtSetting.setTextColor(Color.WHITE);
              onFragment(Fragment_MyList_Menu.newInstance());
          }
      });
      binding.btnSetting.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              onFragment(Fragment_Setting_Menu.newInstance());
              binding.imgBtnHome.setImageResource(R.drawable.home_while);
              binding.imgBtnStar.setImageResource(R.drawable.home_star_while);
              binding.imgBtnLearn.setImageResource(R.drawable.home_learn_while);
              binding.imgBtnSetting.setImageResource(R.drawable.home_setting_yellow);

              binding.txtHome.setTextColor(Color.WHITE);
              binding.txtLuyentap.setTextColor(Color.WHITE);
              binding.txtLearn.setTextColor(Color.WHITE);
              binding.txtSetting.setTextColor(Color.YELLOW);
          }
      });
      getSupportActionBar().hide();
    }


    private void onFragment(Fragment fragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.Main_Fragment,fragment)
                    .commit();
    }


}