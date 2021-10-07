package com.example.hf2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Log.d("Statusz", "ActivityThree:onCreate()");
        Button btn3 = findViewById(R.id.button3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ActivityTwo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz", "ActivityThree:onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz", "ActivityThree:onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz", "ActivityThree:onDestroy()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz", "ActivityThree:onRestart()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz", "ActivityThree:onPause()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz", "ActivityThree:onResume()");

    }
}