package com.example.hf1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText num1 = findViewById(R.id.num1Id);
        EditText num2 = findViewById(R.id.num2Id);
        TextView operation = findViewById(R.id.operationID);
        TextView result = findViewById(R.id.resultId);

        Button addBtn = findViewById(R.id.addBtnId);
        Button subtractBtn = findViewById(R.id.subtractBtnId);
        Button divideBtn = findViewById(R.id.divideBtnId);
        Button multiplyBtn = findViewById(R.id.multiplyBtnId);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int colorCodeDark = Color.parseColor("#91100C");
        window.setStatusBarColor(colorCodeDark);



        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#91100C"));
        actionBar.setBackgroundDrawable(colorDrawable);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result.setText(String.format("%.2f", Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString())));
                    operation.setText("+");

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Mindkét mezőt kikell tölteni!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result.setText(String.format("%.2f", Double.parseDouble(num1.getText().toString()) - Double.parseDouble(num2.getText().toString())));
                    operation.setText("-");
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Mindkét mezőt kikell tölteni!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result.setText(String.format("%.2f", Double.parseDouble(num1.getText().toString()) * Double.parseDouble(num2.getText().toString())));
                    operation.setText("*");
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Mindkét mezőt kikell tölteni!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!(Double.parseDouble(num2.getText().toString()) == 0)) {
                        result.setText(String.format("%.2f", Double.parseDouble(num1.getText().toString()) / Double.parseDouble(num2.getText().toString())));
                        operation.setText("/");
                    } else {
                        throw new Exception("Nullával nem lehet osztani");
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Mindkét mezőt kikell tölteni!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}