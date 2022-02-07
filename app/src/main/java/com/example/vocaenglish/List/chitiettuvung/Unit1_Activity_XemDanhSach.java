package com.example.vocaenglish.List.chitiettuvung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.vocaenglish.APIClient;
import com.example.vocaenglish.MainActivity;
import com.example.vocaenglish.R;
import com.example.vocaenglish.databinding.ActivityUnit1XemDanhSachBinding;
import com.example.vocaenglish.luyentap.AdapterTuVungLuyenTap;
import com.example.vocaenglish.luyentap.SQLhelper;
import com.example.vocaenglish.luyentap.TuVung_LuyenTap;
import com.example.vocaenglish.luyentap.V_SQL;
import com.example.vocaenglish.luyentap.V_TuVung;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Unit1_Activity_XemDanhSach extends AppCompatActivity {

    ActivityUnit1XemDanhSachBinding binding;
    List<TuVung> tuVungList;
    AdapterXemDanhSach adapterXemDanhSach;

    //List<TuVung_LuyenTap> tuVung_luyenTapList;
   // SQLhelper sqLhelper;
    V_SQL v_sql;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_unit1_xem_danh_sach);

       //sqLhelper = new SQLhelper(this);
        v_sql = new V_SQL(this);
           //longclick
                binding.lvUnit.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String tuVung =  tuVungList.get(i).getTuVung();
                        String phienAm =  tuVungList.get(i).getPhienAm();
                        String dichNghia =  tuVungList.get(i).getDichNghia();
                        String example=  tuVungList.get(i).getExample();
                        String img = tuVungList.get(i).getImg();
                        String phatAm = tuVungList.get(i).getPhatAm();
                        v_sql.add(tuVung,phienAm,dichNghia,img,example,phatAm);
                        Toast.makeText(getBaseContext(), "Thanh cong", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
       tuVungList = new ArrayList<>();

        getAPI();
        getSupportActionBar().setTitle("Danh sách chi tiết từ vựng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_tim)));

    }

    public void getAPI(){
        Call<List<TuVung>> call = APIClient.create().onGetContactUnit1();
        call.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                tuVungList = response.body();
                adapterXemDanhSach= new AdapterXemDanhSach(tuVungList);
                binding.lvUnit.setAdapter(adapterXemDanhSach);

                binding.lvUnit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String tuVung =  tuVungList.get(i).getTuVung();
                        String phienAm =  tuVungList.get(i).getPhienAm();
                        String dichNghia =  tuVungList.get(i).getDichNghia();
                        String example=  tuVungList.get(i).getExample();
                        String img = tuVungList.get(i).getImg();
                        String phatAm = tuVungList.get(i).getPhatAm();

                        Intent intent = new Intent(getBaseContext(), Unit1_Activity_ChiTietTuVung.class);
                        intent.putExtra("tuVung",tuVung);
                        intent.putExtra("phienAm",phienAm);
                        intent.putExtra("dichNghia",dichNghia);
                        intent.putExtra("example",example);
                        intent.putExtra("img",img);
                        intent.putExtra("phatAm",phatAm);
                        startActivity(intent);
                    }
                });

            }
            @Override
            public void onFailure(Call<List<TuVung>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapterXemDanhSach.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterXemDanhSach.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}