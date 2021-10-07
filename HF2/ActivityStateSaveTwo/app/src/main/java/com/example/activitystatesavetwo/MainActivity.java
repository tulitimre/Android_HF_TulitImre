package com.example.activitystatesavetwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText personName;
    CheckBox theCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personName = findViewById(R.id.nameID);
        theCheckBox = findViewById(R.id.checkBoxID);

        if (savedInstanceState != null) {
            personName.setText(savedInstanceState.getString("personNameKey"));
            theCheckBox.setChecked(savedInstanceState.getBoolean("theCheckboxKey"));
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("personNameKey", personName.getText().toString());
        outState.putBoolean("theCheckboxKey", theCheckBox.isChecked());

    }

}