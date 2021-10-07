package com.example.hf2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Log.d("Statusz", "ActivityTwo:onCreate()");


        Button btn2 = findViewById(R.id.button2);
        Button btn4 = findViewById(R.id.button4);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ActivityThree.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz", "ActivityTwo:onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz", "ActivityTwo:onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz", "ActivityTwo:onDestroy()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz", "ActivityTwo:onRestart()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz", "ActivityTwo:onPause()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz", "ActivityTwo:onResume()");

    }
}