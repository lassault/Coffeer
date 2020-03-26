package com.lassa97.coffeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static BeerCounter mainBeer = new BeerCounter();
    public static CoffeeCounter mainCoffee = new CoffeeCounter();
    public static SojuCounter mainSoju = new SojuCounter();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restoreData();

        Button addDrinkButton = findViewById(R.id.addDrink);
        addDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDrink();
            }
        });

        Button clearDataButton = findViewById(R.id.clearData);
        clearDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateData();
    }

    @Override
    protected void onStop() {
        super.onStop();

        saveData();
    }

    public void addDrink () {
        Intent intent = new Intent(this, AddDrinkActivity.class);
        startActivity(intent);
    }

    public void restoreData() {

        SharedPreferences infoBeers = getSharedPreferences("infoBeers", 0);
        mainBeer.setNumOfBeers(infoBeers.getInt("numOfBeers", 0));
        mainBeer.setBeerMoney(infoBeers.getFloat("moneyOfBeers", 0.00f));
        mainBeer.setBeerLiters(infoBeers.getFloat("litersOfBeers", 0.00f));

        SharedPreferences infoCoffees = getSharedPreferences("infoCoffees", 0);
        mainCoffee.setNumOfCoffees(infoCoffees.getInt("numOfCoffees", 0));
        mainCoffee.setCoffeeMoney(infoCoffees.getFloat("moneyOfCoffees", 0.00f));
        mainCoffee.setCoffeeLiters(infoCoffees.getFloat("litersOfCoffees", 0.00f));

        SharedPreferences infoSoju = getSharedPreferences("infoSoju", 0);
        mainSoju.setShotsOfSoju(infoSoju.getInt("shotsOfSoju", 0));
        mainSoju.setSojuMoney(infoSoju.getFloat("moneyOfSoju", 0.00f));
        mainSoju.setBottlesOfSoju(infoSoju.getInt("bottlesOfSoju", 0));
    }

    public void updateData() {
        TextView nBeers = findViewById(R.id.numOfBeers);
        nBeers.setText(mainBeer.getNumOfBeers() + " beers");
        TextView mBeers = findViewById(R.id.moneyOfBeers);
        mBeers.setText(String.format("%.2f", mainBeer.getBeerMoney()) + "€");
        TextView lBeers = findViewById(R.id.litersOfBeers);
        lBeers.setText(String.format("%.2f", mainBeer.getBeerLiters()) + " liters");

        TextView nCoffees = findViewById(R.id.numOfCoffees);
        nCoffees.setText(mainCoffee.getNumOfCoffees() + " coffees");
        TextView mCoffees = findViewById(R.id.moneyOfCoffees);
        mCoffees.setText(String.format("%.2f", mainCoffee.getCoffeeMoney()) + "€");
        TextView lCoffees = findViewById(R.id.litresOfCoffee);
        lCoffees.setText(String.format("%.2f", mainCoffee.getCoffeeLiters()) + " liters");

        TextView sSoju = findViewById(R.id.shotsOfSoju);
        sSoju.setText(mainSoju.getShotsOfSoju() + " shots");
        TextView mSoju = findViewById(R.id.moneyOfSoju);
        mSoju.setText(String.format("%.2f", mainSoju.getSojuMoney()) + "€");
        TextView bSoju = findViewById(R.id.bottlesOfSoju);
        bSoju.setText(mainSoju.getBottlesOfSoju() + " bottles");
    }

    public void saveData() {
        SharedPreferences infoBeers = getSharedPreferences("infoBeers", 0);
        Editor beerEditor = infoBeers.edit();
        beerEditor.putInt("numOfBeers", mainBeer.getNumOfBeers());
        beerEditor.putFloat("moneyOfBeers", mainBeer.getBeerMoney());
        beerEditor.putFloat("litersOfBeers", mainBeer.getBeerLiters());
        beerEditor.apply();

        SharedPreferences infoCoffees = getSharedPreferences("infoCoffees", 0);
        Editor coffeeEditor = infoCoffees.edit();
        coffeeEditor.putInt("numOfCoffees", mainCoffee.getNumOfCoffees());
        coffeeEditor.putFloat("moneyOfCoffees", mainCoffee.getCoffeeMoney());
        coffeeEditor.putFloat("litersOfCoffees", mainCoffee.getCoffeeLiters());
        coffeeEditor.apply();

        SharedPreferences infoSoju = getSharedPreferences("infoSoju", 0);
        Editor sojuEditor = infoSoju.edit();
        sojuEditor.putInt("shotsOfSoju", mainSoju.getShotsOfSoju());
        sojuEditor.putFloat("moneyOfSoju", mainSoju.getSojuMoney());
        sojuEditor.putInt("bottlesOfSoju", mainSoju.getBottlesOfSoju());
        sojuEditor.apply();
    }

    public void clearData() {
        SharedPreferences infoBeers = getSharedPreferences("infoBeers", 0);
        Editor beerEditor = infoBeers.edit();
        beerEditor.clear();
        beerEditor.apply();

        SharedPreferences infoCoffees = getSharedPreferences("infoCoffees", 0);
        Editor coffeeEditor = infoCoffees.edit();
        coffeeEditor.clear();
        coffeeEditor.apply();

        restoreData();
        updateData();
    }

}
