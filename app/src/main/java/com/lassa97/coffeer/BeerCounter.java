package com.lassa97.coffeer;

public class BeerCounter {

    private int numOfBeers;
    private float beerMoney;
    private float beerLiters;

    public BeerCounter() {}

    /*public BeerCounter (int numOfBeers, float beerMoney, float beerLiters) {
        this.numOfBeers = numOfBeers;
        this.beerMoney = beerMoney;
        this.beerLiters = beerLiters;
    }*/

    public int getNumOfBeers() {
        return numOfBeers;
    }

    public void setNumOfBeers(int numOfBeers) {
        this.numOfBeers = numOfBeers;
    }

    public float getBeerMoney() {
        return beerMoney;
    }

    public void setBeerMoney(float beerMoney) {
        this.beerMoney = beerMoney;
    }

    public float getBeerLiters() {
        return beerLiters;
    }

    public void setBeerLiters(float beerLiters) {
        this.beerLiters = beerLiters;
    }
}
