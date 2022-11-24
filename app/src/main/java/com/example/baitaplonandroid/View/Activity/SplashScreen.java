package com.example.baitaplonandroid.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplonandroid.Account.SignIn;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.View.Activity.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();

            }
        },2000);
    }

    private void nextActivity() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            //Chua Login
            //Toast.makeText(SplashScreen.this, "Hay dang nhap!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
        } else {
            //Da Login
            //Toast.makeText(SplashScreen.this, "Data has been saved successfully!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        finish();

    }
}
