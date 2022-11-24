package com.example.baitaplonandroid.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplonandroid.View.Layout.BuyLayout;
import com.example.baitaplonandroid.View.Layout.DoUonglayout;
import com.example.baitaplonandroid.View.Layout.FryLayout;
import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.Model.LienHe;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.View.Layout.S;
import com.example.baitaplonandroid.View.Layout.UserLayout;
import com.example.baitaplonandroid.View.Layout.comlayout;
import com.example.baitaplonandroid.View.Layout.dessertLayout;
import com.example.baitaplonandroid.View.Layout.grilledLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Bấm nút Cơm
    private ImageView Com;
    private Button comBtn;


    private ImageView searchIcon;



    //Bấm nút Đồ Uống
    private ImageView DoUong;
    private Button doUongBtn;

    //Bấm nút Tráng Miệng
    private  ImageView dessert;
    private Button dessertBtn;

    //Bấm nút Món xào
    private ImageView xao;
    private Button xaoBtn;

    //Bấm nút nướng
    private ImageView grilled;
    private Button grilledBtn;

    private ImageView cart;

    public static ArrayList<Food> foodArrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_trangchu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.action_home);

        //nhấp chuột vào 3 icon ở dưới cùng
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_fav:
                        startActivity(new Intent(getApplicationContext()
                                , LienHe.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.action_home:
                        return true;

                    case R.id.action_log:
                        startActivity(new Intent(getApplicationContext()
                                , UserLayout.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        if (foodArrayList != null){

        } else {
            foodArrayList = new ArrayList<>();
        }

        //Bam vao Search
        searchIcon = (ImageView) findViewById(R.id.tim_kiem);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, S.class);
                startActivity(intent);
            }
        });

        //Bấm vào giỏ hàng
        cart = (ImageView) findViewById(R.id.buy);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buy_layout();
            }
        });

        //Cơm
        Com =(ImageView) findViewById(R.id.com);
        comBtn = findViewById(R.id.com_btn);


        comBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comlayout();
            }

        });
        Com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comlayout();
            }

        });


        //Đồ Uống
        DoUong = (ImageView) findViewById(R.id.do_uong);
        doUongBtn = findViewById(R.id.do_uong_btn);

        doUongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                douong_layout();
            }

        });
        DoUong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                douong_layout();
            }

        });

        //Tráng Miệng
        dessert = (ImageView) findViewById(R.id.trang_mieng);
        dessertBtn = findViewById(R.id.trang_mieng_btn);

        dessertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dessert_layout();
            }

        });
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dessert_layout();
            }

        });
        //Món Xào
        xao = (ImageView) findViewById(R.id.mon_xao);
        xaoBtn = findViewById(R.id.mon_xao_btn);

        xaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fry_layout();
            }

        });
        xao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fry_layout();
            }

        });

        //Nướng
        grilled = (ImageView) findViewById(R.id.grilled);
        grilledBtn = findViewById(R.id.grilled_btn);


        grilledBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grilled_layout();
            }

        });
        grilled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grilled_layout();
            }

        });
    }
    private void Buy_layout() {
        Intent intent = new Intent (MainActivity.this, BuyLayout.class);
        startActivity(intent);
    }

    private void grilled_layout() {
        Intent intent = new Intent(MainActivity.this, grilledLayout.class);
        startActivity(intent);
    }

    private void fry_layout() {
        Intent intent = new Intent(MainActivity.this, FryLayout.class);
        startActivity(intent);
    }

    private void dessert_layout() {
        Intent intent = new Intent(MainActivity.this, dessertLayout.class);
        startActivity(intent);
    }

    private void douong_layout() {
        Intent intent = new Intent(MainActivity.this, DoUonglayout.class);
        startActivity(intent);
    }

    private void Comlayout() {
        Intent intent = new Intent(MainActivity.this, comlayout.class);
        startActivity(intent);

    }
}