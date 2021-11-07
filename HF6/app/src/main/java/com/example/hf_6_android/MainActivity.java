package com.example.hf_6_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String FRAG1 = "1";
    private static final String FRAG2 = "2";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ft.add(R.id.fragment1, new Fragment1Activity(), FRAG1);
            ft.add(R.id.fragment2, new Fragment2Activity(), FRAG2);
        } else {
            if (fm.findFragmentByTag(FRAG2) != null)
                ft.remove(fm.findFragmentByTag(FRAG2));
            ft.add(R.id.fragment1, new Fragment1Activity(), FRAG1);
        }
        ft.commit();
    }
}