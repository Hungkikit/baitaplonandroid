package com.example.baitaplonandroid.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplonandroid.View.Layout.BuyLayout;
import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.View.Activity.MainActivity;
import com.example.baitaplonandroid.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CarListViewHolder>{
    BuyLayout context;
    List<Food> foodList;

    public CartAdapter(BuyLayout context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public CarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_buy, parent, false);
        return new CarListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nameTxv.setText(foodList.get(position).getName());
        holder.numberTxv.setText(foodList.get(position).getNumber() + "");
        holder.priceTxv.setText(foodList.get(position).getCost());
        holder.buyImage.setImageResource(foodList.get(position).getResourceId());

        holder.buyMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodList.get(position).getNumber() > 0){
                    holder.numberTxv.setText(foodList.get(position).getNumber() - 1 + "");
                    foodList.get(position).setNumber(foodList.get(position).getNumber() - 1);
//                    holder.cartTotal.setText(
//                            Integer.parseInt(cartList.get(position).getPrice())
//                                    *cartList.get(position).getNumberInCart() + "");
                    context.getTotalAmountOfProducts(MainActivity.foodArrayList);
                }
            }
        });

        holder.buyPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.numberTxv.setText(foodList.get(position).getNumber() + 1 +"");
                foodList.get(position).setNumber(foodList.get(position).getNumber() + 1);
//                holder.cartTotal.setText(
//                        Integer.parseInt(cartList.get(position).getPrice().replace(".000", ""))
//                                *cartList.get(position).getNumberInCart() + ".000");
                context.getTotalAmountOfProducts(MainActivity.foodArrayList);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.foodArrayList.remove(foodList.get(position));
                context.getData(MainActivity.foodArrayList);
                context.getTotalAmountOfProducts(MainActivity.foodArrayList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class CarListViewHolder extends RecyclerView.ViewHolder {

        ImageView buyImage, buyMinus, buyPlus;
        TextView nameTxv, numberTxv, priceTxv;
        Button deleteButton;

        public CarListViewHolder(@NonNull View itemView) {
            super(itemView);

            buyImage = itemView.findViewById(R.id.Buy_Food_img);
            buyMinus = itemView.findViewById(R.id.Buy_minus);
            buyPlus = itemView.findViewById(R.id.Buy_plus);
            nameTxv = itemView.findViewById(R.id.Buy_name);
            numberTxv = itemView.findViewById(R.id.Buy_number);
            priceTxv = itemView.findViewById(R.id.buy_price);
            deleteButton = itemView.findViewById(R.id.btn_delete);

        }
    }

}
