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

import com.example.baitaplonandroid.View.Layout.FavLayout;
import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.R;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavListViewHolder> {
    FavLayout context;
    List<Food> foodList;

    public FavAdapter(FavLayout context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FavListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fav, parent, false);
        return new FavListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.NameFav.setText(foodList.get(position).getName());
        holder.TitleFav.setText(foodList.get(position).getTitle());
        holder.FavImage.setImageResource(foodList.get(position).getResourceId());

//        holder.dislike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.foodArrayList.remove(foodList.get(position));
//                context.getData(DetailActivity.arrLike);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }


    public static class FavListViewHolder extends RecyclerView.ViewHolder{
        ImageView FavImage;
        TextView NameFav, TitleFav;
        Button dislike;

        public FavListViewHolder(@NonNull View itemView) {
            super(itemView);

            FavImage = itemView.findViewById(R.id.Fav_Food_img);
            NameFav = itemView.findViewById(R.id.fav_name);
            TitleFav = itemView.findViewById(R.id.tieu_de_fav);
            dislike = itemView.findViewById(R.id.Dislike);

        }
    }
}
