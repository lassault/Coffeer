package com.lassa97.coffeer.Drinks;

public class Soju {

    private float price;
    private int shots;
    private int score;

    public Soju (float price, int shots, int score) {
        this.price = price;
        this.shots = shots;
        this.score = score;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
