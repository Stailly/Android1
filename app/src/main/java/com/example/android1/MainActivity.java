package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.city);
        tv.setText(Objects.requireNonNull(getIntent().getExtras()).getString("city"));

        if (getIntent().getExtras().getBoolean("Pressure")) {
            findViewById(R.id.pressure_value).setVisibility(View.VISIBLE);
        }
        if (getIntent().getExtras().getBoolean("Wind")) {
            findViewById(R.id.wind_value).setVisibility(View.VISIBLE);
        }
        findViewById(R.id.home_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CitiesActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}