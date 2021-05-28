package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements FragmentChanger {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment("Main", null, true);
    }

    @Override
    public void changeFragment(String tag, Bundle args, boolean addToBackStack) {
        Fragment fragment = FragmentFinder.findFragment(tag, args, getSupportFragmentManager());
        if (fragment == null) {
            switch (tag) {
                case "Weather":
                    fragment = new WeatherFragment();
                    break;
                case "Main":
                    fragment = new MainPageFragment();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid tag: " + tag);
            }
            fragment.setArguments(args);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack("");
        }
        transaction.commit();
    }
}