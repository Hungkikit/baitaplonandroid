package com.example.baitaplonandroid.View.Layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplonandroid.Adapter.CartAdapter;
import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.View.Activity.MainActivity;

import java.util.List;

public class BuyLayout extends Activity {

    private RecyclerView rcvData;

    private CartAdapter foodAdapter;

    private EditText diachi;
    //Nút Quay lại
    private ImageView back;
    TextView totalAmountTxv;

    private Button thanhtoanbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_layout);




        thanhtoanbtn = findViewById(R.id.Btn_thanhtoan);
        diachi = findViewById(R.id.Dia_chi);

        getData(MainActivity.foodArrayList);

        getTotalAmountOfProducts(MainActivity.foodArrayList);
        //Quay lại trang chủ
        setBack();
        thanhtoan();
    }



    private void setBack(){
        back = (ImageView) findViewById(R.id.backward);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyLayout.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getData(List<Food> foodArrayList){
        rcvData = findViewById(R.id.recyclerViewCart);
        foodAdapter = new CartAdapter(this, foodArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rcvData.setLayoutManager(layoutManager);
        rcvData.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();
    }

    public void getTotalAmountOfProducts(List<Food> foodArrayList){
        totalAmountTxv = findViewById(R.id.totalAmountProducts);
        int total = 0;
        for (int i = 0; i < foodArrayList.size(); i++){
            total += Integer.parseInt(foodArrayList.get(i).getCost())*foodArrayList.get(i).getNumber();
        }
        totalAmountTxv.setText(total + "");
    }

    private void thanhtoan() {
        thanhtoanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(diachi.getText().toString())) {
                    Toast.makeText(BuyLayout.this,
                            "Hãy Nhập địa chỉ",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Alert();
//                    MainActivity.foodArrayList.clear();
//                    getData(MainActivity.foodArrayList);
//                    Toast.makeText(BuyLayout.this,
//                           "Thanh Toán Thành Công",
//                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Alert(){
        int position;
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Khách hàng có muốn thanh toán không? ");

        alertDialog.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                MainActivity.foodArrayList.clear();
                getData(MainActivity.foodArrayList);
                Toast.makeText(BuyLayout.this,
                        "Thanh Toán Thành Công",
                        Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        alertDialog.show();
    }
}
