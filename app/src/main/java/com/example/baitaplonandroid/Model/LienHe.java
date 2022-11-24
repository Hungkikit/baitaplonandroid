package com.example.baitaplonandroid.Model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.baitaplonandroid.View.Activity.MainActivity;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.View.Layout.UserLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LienHe extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lien_he);

        // BẤM 3 ICON Ở DƯỚI CÙNG
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_fav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_fav:
                        return true;


                    case R.id.action_home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0,0);
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


    }
}
