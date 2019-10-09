package com.lassa97.coffeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AddDrinkActivity extends AppCompatActivity {

    private Beer smallBeer = new Beer(1.50f, 0.30f, 2);
    private Beer bigBeer = new Beer(2.00f, 0.50f, 3);

    private Coffee smallCoffee = new Coffee(0.50f, 0.05f, 1);
    private Coffee bigCoffee = new Coffee(0.90f, 0.10f, 2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);

        ImageView addSmallBeer = findViewById(R.id.addSmallBeer);
        addSmallBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainBeer.setNumOfBeers(MainActivity.mainBeer.getNumOfBeers() + 1);
                MainActivity.mainBeer.setBeerLiters(MainActivity.mainBeer.getBeerLiters() + smallBeer.getLiters());
                MainActivity.mainBeer.setBeerMoney(MainActivity.mainBeer.getBeerMoney() + smallBeer.getPrice());
                finish();
            }
        });

        ImageView addBigBeer = findViewById(R.id.addBigBeer);
        addBigBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainBeer.setNumOfBeers(MainActivity.mainBeer.getNumOfBeers() + 1);
                MainActivity.mainBeer.setBeerLiters(MainActivity.mainBeer.getBeerLiters() + bigBeer.getLiters());
                MainActivity.mainBeer.setBeerMoney(MainActivity.mainBeer.getBeerMoney() + bigBeer.getPrice());
                finish();
            }
        });

        ImageView addSmallCoffee = findViewById(R.id.addSmallCoffee);
        addSmallCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainCoffee.setNumOfCoffees(MainActivity.mainCoffee.getNumOfCoffees() + 1);
                MainActivity.mainCoffee.setCoffeeLiters(MainActivity.mainCoffee.getCoffeeLiters() + smallCoffee.getLiters());
                MainActivity.mainCoffee.setCoffeeMoney(MainActivity.mainCoffee.getCoffeeMoney() + smallCoffee.getPrice());
                finish();
            }
        });

        ImageView addBigCoffee = findViewById(R.id.addBigCoffee);
        addBigCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainCoffee.setNumOfCoffees(MainActivity.mainCoffee.getNumOfCoffees() + 1);
                MainActivity.mainCoffee.setCoffeeLiters(MainActivity.mainCoffee.getCoffeeLiters() + bigCoffee.getLiters());
                MainActivity.mainCoffee.setCoffeeMoney(MainActivity.mainCoffee.getCoffeeMoney() + bigCoffee.getPrice());
                finish();
            }
        });
    }
}
