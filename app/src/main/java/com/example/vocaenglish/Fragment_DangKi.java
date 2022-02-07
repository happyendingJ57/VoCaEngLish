package com.example.vocaenglish;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.vocaenglish.databinding.FragmentDangkiBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;


public class Fragment_DangKi extends Fragment {

    FragmentDangkiBinding binding;
    public static Fragment_DangKi newInstance() {

        Bundle args = new Bundle();

        Fragment_DangKi fragment = new Fragment_DangKi();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dangki,container,false);


        binding.btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               onClickDangKi();
            }
        });

        binding.btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(Fragment_DangNhap.newInstance());
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

        binding.btnShowLaiPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnShowLaiPass.setVisibility(View.GONE);
                binding.btnShowLaiPassNot.setVisibility(View.VISIBLE);
                binding.etNhaplaiPassword.setTransformationMethod(new PasswordTransformationMethod());
            }
        });

        binding.btnShowLaiPassNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnShowLaiPass.setVisibility(View.VISIBLE);
                binding.btnShowLaiPassNot.setVisibility(View.GONE);
                binding.etNhaplaiPassword.setTransformationMethod(null);
            }
        });
        return binding.getRoot();


    }
    private void onFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.Frament_Login,fragment).commit();
    }

    private void onClickDangKi(){
        String email = binding.etGmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();
        String nhaplaipassword = binding.etNhaplaiPassword.getText().toString().trim();

        String regrexLowercase = "[^a-z]+";
        String regrexUppercase = "[^A-Z]+";
        String regrexNumber = "[^0-9]+";
        String regrexSpecials = "\\w+";
        String regrexSpaces = "[^ ]+";

        if(email.length() == 0 || password.length() == 0 || nhaplaipassword.length() ==0){
            Toast.makeText(getContext(), "Không được để trống thông tin", Toast.LENGTH_SHORT).show();
        }
        else if(password.length() < 6){
            Toast.makeText(getContext(), "Mật khẩu phải nhiều hơn 6 kí tự", Toast.LENGTH_SHORT).show();
        }

//        else if(Pattern.matches(regrexLowercase, password)) {
//            Toast.makeText(getContext(), "Mật khẩu phải chứa ít nhất 1 chữ cái thường", Toast.LENGTH_SHORT).show();
//        }
//        else if(Pattern.matches(regrexUppercase, password)){
//            Toast.makeText(getContext(), "Mật khẩu phải chứa ít nhất 1 chữ cái in hoa", Toast.LENGTH_SHORT).show();
//        }
//        else if(Pattern.matches(regrexNumber, password)){
//            Toast.makeText(getContext(), "Mật khẩu phải chứa ít nhất 1 số", Toast.LENGTH_SHORT).show();
//        }
//        else if(Pattern.matches(regrexSpecials, password)){
//            Toast.makeText(getContext(), "Mật khẩu phải chứa ít nhất 1 kí tự đặc biệt", Toast.LENGTH_SHORT).show();
//        }
//        else if(!Pattern.matches(regrexSpaces, password)){
//            Toast.makeText(getContext(), "Mật khẩu không được chứa khoảng trắng", Toast.LENGTH_SHORT).show();
//        }
//        else if(password.equalsIgnoreCase(nhaplaipassword)){
//            Toast.makeText(getContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
//        }
        else{
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        onFragment(Fragment_DangNhap.newInstance());
                                    }
                                },2000);


                            } else {
                                Toast.makeText(getContext(), "Đăng kí thất bại", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }


    }
}
