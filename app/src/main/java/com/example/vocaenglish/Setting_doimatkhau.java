package com.example.vocaenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import com.example.vocaenglish.databinding.ActivitySettingDoimatkhauBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Setting_doimatkhau extends AppCompatActivity {

    ActivitySettingDoimatkhauBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_setting_doimatkhau);
        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
        binding.btnShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnShowPass.setVisibility(View.GONE);
                binding.btnShowPassNot.setVisibility(View.VISIBLE);
                binding.etNewpassword.setTransformationMethod(new PasswordTransformationMethod());
            }
        });

        binding.btnShowPassNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnShowPass.setVisibility(View.VISIBLE);
                binding.btnShowPassNot.setVisibility(View.GONE);
                binding.etNewpassword.setTransformationMethod(null);
            }
        });
        binding.btnDoimatkhaumoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDoiMk();
            }


        });
    }
    private void onClickDoiMk() {
        String newPassword = binding.etNewpassword.getText().toString().trim();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.updatePassword(newPassword)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                }
                            },2000);

                        }
                    }
                });

    }
}