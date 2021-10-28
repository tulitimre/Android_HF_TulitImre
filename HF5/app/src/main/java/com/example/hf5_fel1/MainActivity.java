package com.example.hf5_fel1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<String> listItems = new ArrayList<>();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems.add("gSeventh");
        listItems.add("hEight");
        listItems.add("bSecond");
        listItems.add("aFirst");
        listItems.add("dForth");
        listItems.add("iNineth");
        listItems.add("eFifth");
        listItems.add("jTenth");
        listItems.add("fSixth");
        listItems.add("cThird");

        list = findViewById(R.id.listId);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        registerForContextMenu(list);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sortId:
                Collections.sort(listItems, String.CASE_INSENSITIVE_ORDER);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "List Sorted", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deleteId:
                listItems.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "All item deleted!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        View v = info.targetView;
        TextView tv1 = (TextView) v.findViewById(android.R.id.text1);
        switch (item.getItemId()) {
            case R.id.redId:
                tv1.setTextColor(Color.RED);
                Toast.makeText(MainActivity.this, "Color changed to red!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.greenId:
                tv1.setTextColor(Color.GREEN);
                Toast.makeText(MainActivity.this, "Color changed to green!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.yellowId:
                tv1.setTextColor(Color.YELLOW);
                Toast.makeText(MainActivity.this, "Color changed to yellow!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }
}