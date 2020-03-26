package com.lassa97.coffeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lassa97.coffeer.Drinks.Beer;
import com.lassa97.coffeer.Drinks.Coffee;
import com.lassa97.coffeer.Drinks.Soju;

public class AddDrinkActivity extends AppCompatActivity {

    private Beer smallBeer = new Beer(1.50f, 0.30f, 2);
    private Beer bigBeer = new Beer(2.00f, 0.50f, 3);

    private Coffee smallCoffee = new Coffee(0.50f, 0.05f, 1);
    private Coffee bigCoffee = new Coffee(0.90f, 0.10f, 2);

    private Soju smallSoju = new Soju(0.50f, 1, 1);
    private Soju bigSoju = new Soju(2.00f, 7, 5);

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

        ImageView addSmallSoju = findViewById(R.id.addSmallSoju);
        addSmallSoju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainSoju.setShotsOfSoju(MainActivity.mainSoju.getShotsOfSoju() + 1);
                if (MainActivity.mainSoju.getShotsOfSoju() % 7 == 0) {
                    MainActivity.mainSoju.setBottlesOfSoju(MainActivity.mainSoju.getBottlesOfSoju() + 1);
                }
                MainActivity.mainSoju.setSojuMoney(MainActivity.mainSoju.getSojuMoney() + smallSoju.getPrice());
                finish();
            }
        });

        ImageView addBigSoju = findViewById(R.id.addBigSoju);
        addBigSoju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainSoju.setShotsOfSoju(MainActivity.mainSoju.getShotsOfSoju() + bigSoju.getShots());
                MainActivity.mainSoju.setBottlesOfSoju(MainActivity.mainSoju.getBottlesOfSoju() + 1);
                MainActivity.mainSoju.setSojuMoney(MainActivity.mainSoju.getSojuMoney() + bigSoju.getPrice());
                finish();
            }
        });
    }
}
