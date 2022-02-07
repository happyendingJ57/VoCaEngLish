package com.example.vocaenglish;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.databinding.FragmentDangnhapBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Fragment_DangNhap extends Fragment {


    FragmentDangnhapBinding binding;
    public static Fragment_DangNhap newInstance() {
        Bundle args = new Bundle();
        Fragment_DangNhap fragment = new Fragment_DangNhap();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dangnhap,container,false);

        binding.btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDangNhap();
            }
        });

        binding.btnDangKiLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(Fragment_DangKi.newInstance());
            }
        });

        binding.txtQuenMkR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickQuenMk();
            }
        });

        binding.btnShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnShowPass.setVisibility(View.GONE);
                binding.btnShowPassNot.setVisibility(View.VISIBLE);
                binding.etPassword.setTransformationMethod(new PasswordTransformationMethod());
            }
        });

        binding.btnShowPassNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnShowPass.setVisibility(View.VISIBLE);
                binding.btnShowPassNot.setVisibility(View.GONE);
                binding.etPassword.setTransformationMethod(null);
            }
        });
        return binding.getRoot();
    }

    private  void onFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.Frament_Login,fragment).commit();
    }
    private void onClickDangNhap() {

        String stremail = binding.etEmail.getText().toString().trim();
        String strpassword = binding.etPassword.getText().toString().trim();

        String regrexName = "[A-Za-z \\p{L}]+";
        if(stremail.length() == 0 || strpassword.length() == 0)
        {
            Toast.makeText(getContext(), "Không để để trống thông tin", Toast.LENGTH_SHORT).show();
        }
        else{
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(stremail, strpassword)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startActivity(new Intent(getContext(),MainActivity.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getContext(), "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }

    private void onClickQuenMk() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = binding.etEmail.getText().toString().trim();

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Mật khẩu đã gửi tới email", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getContext(), "Gmail chưa được xác minh", Toast.LENGTH_SHORT).show();
                            }
                        }

                });
    }

}
