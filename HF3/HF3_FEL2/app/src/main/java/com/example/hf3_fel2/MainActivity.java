package com.example.hf3_fel2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addProductBtn = findViewById(R.id.btnAddID);
        Button cancelBtn = findViewById(R.id.btnCancelID);
        Button showProductsBtn = findViewById(R.id.btnShowProductsID);

        EditText etProductCode = findViewById(R.id.etProductCodeID);
        EditText etProductName = findViewById(R.id.etProductNameID);
        EditText etProductPrice = findViewById(R.id.etProductPriceID);

        TextView allProduct = findViewById(R.id.twAllProductsID);

        ArrayList<Product> productsList = new ArrayList<>();

        addProductBtn.setOnClickListener(view -> {
            try {
                boolean contains = false;
                for (Product e : productsList) {
                    if (e.getCode() == Integer.parseInt(etProductCode.getText().toString())) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    if(!(etProductName.getText().toString().matches(""))){
                        productsList.add(new Product(Integer.parseInt(etProductCode.getText().toString()), etProductName.getText().toString(), Double.parseDouble(etProductPrice.getText().toString())));
                        Toast.makeText(MainActivity.this, "Product added!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "No product name specified!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "This product is already added!", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "The code and the price must to be a number!", Toast.LENGTH_SHORT).show();
            }
        });

        cancelBtn.setOnClickListener(view -> {
            if (!(etProductCode.getText().toString().matches("") && etProductName.getText().toString().matches("") && etProductPrice.getText().toString().matches(""))) {
                etProductCode.setText("");
                etProductName.setText("");
                etProductPrice.setText("");
            } else {
                Toast.makeText(MainActivity.this, "The fields are already empty!", Toast.LENGTH_SHORT).show();
            }
        });

        showProductsBtn.setOnClickListener(view -> {
            StringBuilder addedProducts = new StringBuilder();
            if (!(productsList.isEmpty())) {
                addedProducts.setLength(0);
                allProduct.setText("");
                for (Product e : productsList) {
                    addedProducts.append(e.toString());
                }
                allProduct.setText(addedProducts.toString());
            } else {
                Toast.makeText(MainActivity.this, "There are no products to display!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}