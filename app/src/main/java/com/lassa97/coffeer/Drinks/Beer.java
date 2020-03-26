package com.lassa97.coffeer.Drinks;

public class Beer {

    private float price;
    private float liters;
    private int score;

    public Beer (float price, float liters, int score) {
        this.price = price;
        this.liters = liters;
        this.score = score;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getLiters() {
        return liters;
    }

    public void setLiters(float liters) {
        this.liters = liters;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
