package com.lassa97.coffeer;

public class CoffeeCounter {

    private int numOfCoffees;
    private float coffeeMoney;
    private float coffeeLiters;

    public CoffeeCounter() {}

    /*public CoffeeCounter (int numOfCoffees, float coffeeMoney, float coffeeLiters) {
        this.numOfCoffees = numOfCoffees;
        this.coffeeMoney = coffeeMoney;
        this.coffeeLiters = coffeeLiters;
    }*/

    public int getNumOfCoffees() {
        return numOfCoffees;
    }

    public void setNumOfCoffees(int numOfCoffees) {
        this.numOfCoffees = numOfCoffees;
    }

    public float getCoffeeMoney() {
        return coffeeMoney;
    }

    public void setCoffeeMoney (float coffeeMoney) {
        this.coffeeMoney = coffeeMoney;
    }

    public float getCoffeeLiters() {
        return coffeeLiters;
    }

    public void setCoffeeLiters (float coffeeLiters) {
        this.coffeeLiters = coffeeLiters;
    }
}
