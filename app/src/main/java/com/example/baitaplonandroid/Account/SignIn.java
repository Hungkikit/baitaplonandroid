package com.example.baitaplonandroid.Account;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplonandroid.View.Activity.MainActivity;
import com.example.baitaplonandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private EditText edtgmail,edtpassword;
    private Button btnSignin, btnSignup;
    //private ProgressDialog progressDialog ;
    private FirebaseAuth mAuth;
    private LinearLayout forgot;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        mAuth = FirebaseAuth.getInstance();

        edtgmail = findViewById(R.id.edit_gmail);
        edtpassword = findViewById(R.id.edit_password);
        btnSignin = findViewById(R.id.SignIn);
        btnSignup = findViewById(R.id.SignUp);
        forgot = findViewById(R.id.forgot_password);

        //progressDialog = new ProgressDialog(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp_layout();
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Trangchu_layout();
            }
        });

    }
    private void SignUp_layout() {
        Intent intent = new Intent(SignIn.this, SignUp.class);
        startActivity(intent);
    }
    private void Trangchu_layout(){
        String email, pass;

        email = edtgmail.getText().toString();
        pass = edtpassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui lòng nhập email !!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui lòng nhập password !!", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công !!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignIn.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập thất bại !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
