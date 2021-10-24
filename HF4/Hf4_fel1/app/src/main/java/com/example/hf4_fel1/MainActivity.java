package com.example.hf4_fel1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Money> currencyList = new ArrayList<>();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyList.add(new Money(R.drawable.unio, "EUR", "Euro", 4.4100, 4.5500));
        currencyList.add(new Money(R.drawable.usa, "USD", "Dolar american", 3.9750, 4.1450));
        currencyList.add(new Money(R.drawable.uk, "GBP", "Lira sterlina", 6.1250, 6.3550));
        currencyList.add(new Money(R.drawable.australia, "AUD", "Dolar australian", 2.9600, 3.0600));
        currencyList.add(new Money(R.drawable.canada, "CAD", "Dolar canadian", 3.0950, 3.2650));
        currencyList.add(new Money(R.drawable.switzerland, "CHF", "Franc elvetian", 4.2300, 4.3300));
        currencyList.add(new Money(R.drawable.dania, "DKK", "Coroana daneaza", 0.5850, 0.6150));
        currencyList.add(new Money(R.drawable.hungary, "HUF", "Forint maghiar", 0.0136, 0.0146));

        list = findViewById(R.id.currencyList);

        MoneyListAdapter theAdapter = new MoneyListAdapter(this, currencyList);
        list.setAdapter(theAdapter);

        list.setOnItemClickListener((adapterView, view, position, id) -> {
            TextView twCurrency = view.findViewById(R.id.currencyID);
            TextView twBuyValue = view.findViewById(R.id.valueCumparaId);
            Toast.makeText(MainActivity.this, twCurrency.getText().toString() + " " + twBuyValue.getText().toString(), Toast.LENGTH_SHORT).show();
        });

    }
}