package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CitiesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        final EditText editText = findViewById(R.id.enter_city);
        final Switch pressure = findViewById(R.id.showPressure);
        final Switch windSpeed = findViewById(R.id.showWind);
        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent intent = new Intent(CitiesActivity.this, MainActivity.class);
                                             Bundle bundle = new Bundle();
                                             bundle.putString("city", editText.getText().toString());
                                             bundle.putBoolean("Pressure", pressure.isChecked());
                                             bundle.putBoolean("Wind", windSpeed.isChecked());
                                             intent.putExtras(bundle);
                                             startActivity(intent);

                                         }
                                     }

        );

    }

}