package com.example.baitaplonandroid.Account;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplonandroid.View.Activity.MainActivity;
import com.example.baitaplonandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private TextView txtdangnhap;
    private EditText edtmail, edtpass, edtpasscf;
    private Button btnDangky;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mAuth = FirebaseAuth.getInstance();

        txtdangnhap = findViewById(R.id.txtdangnhap);
        edtmail = findViewById(R.id.editMail);
        edtpass = findViewById(R.id.editPass);
        edtpasscf = findViewById(R.id.editPasscf);
        btnDangky = findViewById(R.id.buttonDangky);

        txtdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn_layout();
            }
        });

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Trangchu_layout();
            }
        });
    }
    private void SignIn_layout(){
        Intent intent = new Intent(SignUp.this, SignIn.class);
        startActivity(intent);
    }
    private void Trangchu_layout(){
        String email, pass, passcf;

        email = edtmail.getText().toString();
        pass = edtpass.getText().toString();
        passcf = edtpasscf.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui l??ng nh???p email !!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui l??ng nh???p password !!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(pass.equals(passcf) == false){
            Toast.makeText(this,"H??y nh???p ch??nh x??c password !!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"????ng k?? th??nh c??ng !!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"????ng k?? th???t b???i, m???i anh zai nh???p l???i !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
