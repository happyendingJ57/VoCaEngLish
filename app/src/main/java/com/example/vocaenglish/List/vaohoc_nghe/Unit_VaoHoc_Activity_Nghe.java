package com.example.vocaenglish.List.vaohoc_nghe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import com.example.vocaenglish.APIClient;

import com.example.vocaenglish.List.chitiettuvung.TuVung;

import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.ActivityUnitVaohocBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Unit_VaoHoc_Activity_Nghe extends AppCompatActivity {

    ActivityUnitVaohocBinding binding;
    List<TuVung> mlistTuVung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_unit_vaohoc);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
       getAPI();


      getSupportActionBar().hide();
    }
    public void getAPI(){
        Call<List<TuVung>> call = APIClient.create().onGetContactUnit1();
        call.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                mlistTuVung = response.body();
                ViewPagerAdaper adapter = new ViewPagerAdaper(getSupportFragmentManager(),
                        FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mlistTuVung);
                binding.viewPager.setAdapter(adapter);

                binding.tvCurrentQs.setText("1");

                binding.tvTotalQs.setText(String.valueOf(mlistTuVung.size()));

                binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        binding.tvCurrentQs.setText(String.valueOf(position+1));
                        if (position == 0){
                            binding.tvBackQs.setVisibility(View.GONE);
                            binding.tvNextQs.setVisibility(View.VISIBLE);
                        }else if(position == mlistTuVung.size() -1){
                            binding.tvBackQs.setVisibility(View.VISIBLE);
                            binding.tvNextQs.setVisibility(View.GONE);
                        }
                        else
                        {
                            binding.tvBackQs.setVisibility(View.VISIBLE);
                            binding.tvNextQs.setVisibility(View.VISIBLE);
                        }
                    }



                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });


                binding.tvBackQs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem()-1);
                    }
                });

                binding.tvNextQs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem()+1);

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