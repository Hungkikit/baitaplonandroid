package com.example.baitaplonandroid.View.Layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplonandroid.Adapter.FoodAdapter;
import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.View.Activity.DetailActivity;
import com.example.baitaplonandroid.View.Activity.MainActivity;
import com.example.baitaplonandroid.my_interface.IClickItemFoodListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class grilledLayout extends AppCompatActivity {
    private RecyclerView rcvData;
    private FoodAdapter foodAdapter;
    List<Food> list = new ArrayList<>();

    //Nút Quay lại
    private ImageView back;

    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com_layout);

        rcvData = findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        foodAdapter = new FoodAdapter(getListFood(), new IClickItemFoodListener() {
            @Override
            public void onClickItemFood(Food food) {
                onClickGoToDetails(food);
            }
        });





        rcvData.setAdapter(foodAdapter);


        //Quay lại trang chủ
        back = (ImageView) findViewById(R.id.backward);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(grilledLayout.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Bấm vào giỏ hàng
        cart = (ImageView) findViewById(R.id.buy);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (grilledLayout.this, BuyLayout.class);
                startActivity(intent);
            }
        });

    }

    private List<Food> getListFood() {
//        List<Food> list = new ArrayList<>();
        list.add(new Food(R.drawable.ca_nuong, "Cá nướng","Made in Viet Nam","70000" ));
        list.add(new Food(R.drawable.thit_nuong, "Thịt nướng","Made in Viet Nam","75000" ));
        list.add(new Food(R.drawable.suon_nuong, "Sường nướng","Made in Viet Nam","80000" ));


        return list;
    }
    private void onClickGoToDetails (Food food){
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_food",food);
        intent.putExtras(bundle);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu_other, menu);


        return true;
    }
    //Sort button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.sortNameA_Z:

                Collections.sort(list, Food.FoodA_ZComparator);
                Toast.makeText(grilledLayout.this, "Sort A-Z", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;


            case R.id.sortNameZ_A:
                Collections.sort(list, Food.FoodZ_AComparator);
                Toast.makeText(grilledLayout.this, "Sort Z-A", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;


            case R.id.sortCostTangDan:
                Collections.sort(list, Food.FoodGiaTienTangDanComparator);
                Toast.makeText(grilledLayout.this, "Sort Ascending", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;

            case R.id.sortCostGiamDan:
                Collections.sort(list, Food.FoodGiaTienGiamDanComparator);
                Toast.makeText(grilledLayout.this, "Sort Desending", Toast.LENGTH_SHORT).show();
                foodAdapter.notifyDataSetChanged();
                return true;


        }


        return super.onOptionsItemSelected(item);

    }
}
