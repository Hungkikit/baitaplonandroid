package com.example.baitaplonandroid.Model;

import java.io.Serializable;
import java.util.Comparator;

public class Food implements Serializable {
    private int resourceId;
    private String name;
    private String title;
    private String cost;
    private int number;

    public Food(int resourceId, String name, String title, String cost) {
        this.resourceId = resourceId;
        this.name = name;
        this.title = title;
        this.cost = cost;
    }

    public Food(int resourceId, String name, String title, String cost, int number) {
        this.resourceId = resourceId;
        this.name = name;
        this.title = title;
        this.cost = cost;
        this.number = number;
    }



    public static Comparator<Food> FoodA_ZComparator = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            return f1.getName().compareTo(f2.getName());
        }
    };

    public static Comparator<Food> FoodZ_AComparator = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            return f2.getName().compareTo(f1.getName());
        }
    };

    public static Comparator<Food> FoodGiaTienTangDanComparator = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            return f1.getCost().compareTo(f2.getCost());
        }
    };

    public static Comparator<Food> FoodGiaTienGiamDanComparator = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            return f2.getCost().compareTo(f1.getCost());
        }
    };





    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

