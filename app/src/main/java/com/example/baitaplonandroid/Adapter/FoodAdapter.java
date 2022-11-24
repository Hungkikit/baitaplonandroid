package com.example.baitaplonandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.baitaplonandroid.Model.Food;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.my_interface.IClickItemFoodListener;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.foodViewHolder> implements Filterable {

    private List<Food> mListFood;
    private List<Food> mListFoodOld;
    private IClickItemFoodListener iClickItemFoodListener;
    private Context context;

    public FoodAdapter(List<Food> mListFood, IClickItemFoodListener listener) {
        this.mListFood = mListFood;
        this.mListFoodOld = mListFood;
        this.iClickItemFoodListener = listener;

    }

    public FoodAdapter(Context context, List<Food> mListFood) {
        this.mListFood = mListFood;
        this.context = context;
    }



    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new foodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull foodViewHolder holder, int position) {
        final Food food = mListFood.get(position);
        if(food == null){
            return;
        }
        holder.imgFood.setImageResource(food.getResourceId());
        holder.name.setText(food.getName());
        holder.title.setText(food.getTitle());
        holder.cost.setText(food.getCost());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItemFoodListener.onClickItemFood(food);
            }
        });



    }

    @Override
    public int getItemCount() {
        if(mListFood != null){
            return mListFood.size();
        }
        return 0;
    }



    public class foodViewHolder extends RecyclerView.ViewHolder  {

        private RelativeLayout layoutItem;
        private ImageView imgFood;
        private TextView name;
        private TextView title;
        private TextView cost;
        private ImageView addtocart;


        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imgFood = itemView.findViewById(R.id.img_Com);
            name = itemView.findViewById(R.id.Name);
            title = itemView.findViewById(R.id.tieu_de);
            cost = itemView.findViewById(R.id.cost_rice);


        }
    }

    //Phần Search
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if(strSearch.isEmpty()){
                    mListFood = mListFoodOld;
                }else{
                    List<Food> list = new ArrayList<>();
                    for(Food food :mListFoodOld){
                        if(food.getName().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(food);
                        }
                    }
                    mListFood = list;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mListFood;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mListFood = (List<Food>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}

