package com.example.baitaplonandroid.View.Layout;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.baitaplonandroid.Adapter.FoodAdapter;
import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.View.Activity.DetailActivity;
import com.example.baitaplonandroid.my_interface.IClickItemFoodListener;

public class S extends AppCompatActivity {

    private FoodAdapter foodAdapter;
    private RecyclerView rcvData;
    List<Food> list = new ArrayList<>();
    //Tim Kiem
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_layout);


        rcvData = findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        foodAdapter = new FoodAdapter(getListFood(), new IClickItemFoodListener() {
            @Override
            public void onClickItemFood(Food food) {
                onClickGoToDetails(food);
            }
        });


        rcvData.setAdapter(foodAdapter);


    }

    private List<Food> getListFood() {
        //List<Food> list = new ArrayList<>();
        list.add(new Food(R.drawable.com_dua_bo, "Cơm dưa bò", "Made in Viet Nam", "30000"));
        list.add(new Food(R.drawable.com_rang, "Cơm rang", "Made in Viet Nam", "40000"));
        list.add(new Food(R.drawable.com_ga, "Cơm gà", "Made in Viet Nam", "50000"));

        list.add(new Food(R.drawable.bia, "Bia", "Made in Viet Nam", "15000"));
        list.add(new Food(R.drawable.nuoc_loc, "Nước lọc", "Made in Viet Nam", "10000"));
        list.add(new Food(R.drawable.coca_cola, "Coca cola", "Made in Viet Nam", "15000"));

        list.add(new Food(R.drawable.kem_vien, "Kem viên", "Made in Viet Nam", "30000"));
        list.add(new Food(R.drawable.sua_chua_hoa_qua, "sữa chua hoa quả", "Made in Viet Nam", "20000"));
        list.add(new Food(R.drawable.che_long_nhan, "Chè long nhãn", "Made in Viet Nam", "15000"));

        list.add(new Food(R.drawable.muc_xao, "Mực xào", "Made in Viet Nam", "70000"));
        list.add(new Food(R.drawable.rau_muong_xao, "Rau muống xào", "Made in Viet Nam", "50000"));
        list.add(new Food(R.drawable.bo_xao, "Bò xào", "Made in Viet Nam", "60000"));

        list.add(new Food(R.drawable.ca_nuong, "Cá nướng", "Made in Viet Nam", "70000"));
        list.add(new Food(R.drawable.thit_nuong, "Thịt nướng", "Made in Viet Nam", "75000"));
        list.add(new Food(R.drawable.suon_nuong, "Sườn nướng", "Made in Viet Nam", "80000"));

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);


        //Search
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setMaxWidth(Integer.MAX_VALUE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                foodAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                foodAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }

        super.onBackPressed();
    }

    //Sort button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sortNameA_Z:

                Collections.sort(list, Food.FoodA_ZComparator);
                Toast.makeText(S.this, "Sort A-Z", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;


            case R.id.sortNameZ_A:
                Collections.sort(list, Food.FoodZ_AComparator);
                Toast.makeText(S.this, "Sort Z-A", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;


            case R.id.sortCostTangDan:
                Collections.sort(list, Food.FoodGiaTienTangDanComparator);
                Toast.makeText(S.this, "Sort Ascending", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;

            case R.id.sortCostGiamDan:
                Collections.sort(list, Food.FoodGiaTienGiamDanComparator);
                Toast.makeText(S.this, "Sort Desending", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;


        }


        return super.onOptionsItemSelected(item);

    }

    private void onClickGoToDetails(Food food) {
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_food", food);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

