package com.example.baitaplonandroid.View.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitaplonandroid.View.Layout.BuyLayout;
import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.View.Layout.comlayout;

import java.util.ArrayList;

public class DetailActivity extends Activity {

    //Nút Quay lại
    private ImageView back;
    private ImageView cart;

    private Button btnDetailAddToCart;
    private Button btnFavorite;

    String name , title, price;
    int image;
    public static ArrayList<Food> arrLike = new ArrayList<Food>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        Food food = (Food) bundle.get("object_food");
        ImageView imgdetail = findViewById(R.id.detail_img);
        imgdetail.setImageResource(food.getResourceId());
        image = food.getResourceId();


        TextView namedetail = findViewById(R.id.detail_name);
        namedetail.setText(food.getName());
        name = food.getName();

        TextView costdetail = findViewById(R.id.detail_cost);
        costdetail.setText(food.getCost());
        price = food.getCost();

        TextView titledetail = findViewById(R.id.detail_title);
        titledetail.setText(food.getTitle());
        title = food.getTitle();



        //Bấm vào giỏ hàng
        cart = (ImageView) findViewById(R.id.buy);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DetailActivity.this, BuyLayout.class);
                startActivity(intent);
            }
        });



        back = (ImageView) findViewById(R.id.backdetail);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetailActivity.this, comlayout.class);
                startActivity(intent);
                finish();
            }
        });


        addToCart();
        AddToFav();

    }

    private void addToCart() {
        btnDetailAddToCart = findViewById(R.id.btnDetailAddToCart);
        btnDetailAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.foodArrayList.size() > 0){

                    boolean exist = false;

                    for(int i = 0; i < MainActivity.foodArrayList.size(); i++){
                        if (MainActivity.foodArrayList.get(i).getName().equals(name)){
                            MainActivity.foodArrayList.get(i).setNumber(
                                    MainActivity.foodArrayList.get(i).getNumber() + 1
                            );
                            exist = true;
                        }
                    }

                    if(exist == false){
                        MainActivity.foodArrayList.add(new Food(image, name, title, price, 1));
                    }

                } else {
                    MainActivity.foodArrayList.add(new Food(image, name, title, price, 1));
                }
                Toast.makeText(DetailActivity.this, "Đã thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AddToFav(){
        btnFavorite = findViewById(R.id.btnLike);
        btnFavorite.setOnClickListener(view -> {

            Food  food = new Food(image, name, title, price, 1);
                arrLike.add(food);
                Toast.makeText(DetailActivity.this, "Bạn đã thích sản phẩm này", Toast.LENGTH_SHORT).show();

        });
    }


}