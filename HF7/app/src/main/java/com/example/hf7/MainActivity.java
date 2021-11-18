package com.example.hf7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Animal> animalList = new ArrayList<>();

        animalList.add(new Animal("Macska", R.drawable.cat, "Macska leírása!"));
        animalList.add(new Animal("Disznó", R.drawable.disznyo, "Disznó leírása!"));
        animalList.add(new Animal("Kutya", R.drawable.dog, "Kutya leírása!"));
        animalList.add(new Animal("Zsiráf", R.drawable.giraffe, "Zsiráf leírása!"));
        animalList.add(new Animal("Ló", R.drawable.horse, "Ló leírása!"));
        animalList.add(new Animal("Oroszlán", R.drawable.lion, "Oroszlán leírása!"));
        animalList.add(new Animal("Nyúl", R.drawable.rabbit, "Nyúl leírása!"));
        animalList.add(new Animal("Bárány", R.drawable.sheep, "Bárány leírása!"));
        animalList.add(new Animal("Polip", R.drawable.octopus3, "Polip leírása!"));

        RecyclerView rvAnimals = findViewById(R.id.rvAnimals);
        rvAnimals.setHasFixedSize(true);
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        AnimalsAdapter adapter = new AnimalsAdapter(this, animalList);
        rvAnimals.setAdapter(adapter);
    }
}