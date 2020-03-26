package com.lassa97.coffeer;

public class SojuCounter {

    private int shotsOfSoju;
    private float sojuMoney;
    private int bottlesOfSoju;

    public SojuCounter() {}

        /*public SojuCounter (int shotsOfSoju, float sojuMoney, int bottlesOfSoju) {
        this.shotsOfSoju = shotsOfSoju;
        this.sojuMoney = sojuMoney;
        this.bottlesOfSoju = bottlesOfSoju;
    }*/


    public int getShotsOfSoju() {
        return shotsOfSoju;
    }

    public void setShotsOfSoju(int shotsOfSoju) {
        this.shotsOfSoju = shotsOfSoju;
    }

    public float getSojuMoney() {
        return sojuMoney;
    }

    public void setSojuMoney(float sojuMoney) {
        this.sojuMoney = sojuMoney;
    }

    public int getBottlesOfSoju() {
        return bottlesOfSoju;
    }

    public void setBottlesOfSoju(int bottlesOfSoju) {
        this.bottlesOfSoju = bottlesOfSoju;
    }
}
