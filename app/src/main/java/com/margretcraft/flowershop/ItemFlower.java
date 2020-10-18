package com.margretcraft.flowershop;

import android.graphics.drawable.Drawable;

public class ItemFlower {
    private String flowerName;
    private int quantity;
    private Drawable image;
    private int color;
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public ItemFlower(String name, Drawable image, int cost) {
        this.flowerName = name;
        this.image = image;
        this.quantity = 0;
        this.color = 0;
        this.cost = cost;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String FlowerName) {
        this.flowerName = FlowerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
