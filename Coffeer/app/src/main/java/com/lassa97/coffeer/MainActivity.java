package com.lassa97.coffeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lassa97.coffeer.Handler.PruebaResponseHandler;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

public class MainActivity extends AppCompatActivity {

    public static BeerCounter mainBeer = new BeerCounter();
    public static CoffeeCounter mainCoffee = new CoffeeCounter();

    /* android.app.Activity (https://developer.android.com/reference/android/app/Activity) */
    /* Activities [ES] (https://developer.android.com/guide/components/activities.html?hl=ES) */
    
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

        pruebaOnline();
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
    }

    public void clearData() {
        SharedPreferences infoBeers = getSharedPreferences("infoBeers", 0);
        Editor beerEditor = infoBeers.edit();
        beerEditor.clear();
        beerEditor.apply();

        SharedPreferences infoCoffees = getSharedPreferences("infoCoffees", 0);
        Editor coffeeEditor = infoCoffees.edit();;
        coffeeEditor.clear();
        coffeeEditor.apply();

        restoreData();
        updateData();
    }

    public void pruebaOnline() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        AsyncHttpClient client = new AsyncHttpClient();

        /*client.get(
                "http://172.19.79.248/php/prueba.php",
                new PruebaResponseHandler(gson, this)
        );*/

        RequestParams params = new RequestParams();
        params.put("grito", "aaaa");

        client.get(
                "http://172.19.79.248/php/grito.php", params,
                new PruebaResponseHandler(gson, this)
        );
    }

}
