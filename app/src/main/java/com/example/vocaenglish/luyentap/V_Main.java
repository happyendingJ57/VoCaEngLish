package com.example.vocaenglish.luyentap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.AActivityVmainBinding;

import java.util.List;

public class V_Main extends AppCompatActivity {

    AActivityVmainBinding binding;
    V_SQL sql1Helper;
    List<V_TuVung> contacts;
    V_Adapter adapterContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.a_activity_vmain);
        getSupportActionBar().hide();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

        sql1Helper = new V_SQL(this);
        contacts = sql1Helper.getAllContact();
        binding.xemtuvung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contacts.size() == 0){
                    binding.thongbao.setVisibility(View.VISIBLE);
                }
                else{
                    adapterContact =new V_Adapter(contacts);
                    binding.lvContacts.setAdapter(adapterContact);
                    binding.thongbao.setVisibility(View.GONE);
                }
            }
        });

        binding.lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        sql1Helper.delete(contacts.get(i).getTuVung());
                        adapterContact.notifyDataSetChanged();
                         contacts = sql1Helper.getAllContact();
                         adapterContact =new V_Adapter(contacts);
                         binding.lvContacts.setAdapter(adapterContact);
                        Toast.makeText(getBaseContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
    }
}