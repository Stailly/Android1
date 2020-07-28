package com.example.android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class CitiesActivity extends AppCompatActivity {

    private EditText editText;
    private Switch pressure;
    private Switch windSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        editText = findViewById(R.id.enter_city);
        pressure = findViewById(R.id.showPressure);
        windSpeed = findViewById(R.id.showWind);
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
        logMethod("onCreate()");
    }

    private void logMethod(String s) {
        Toast.makeText(this, "App State" + s, Toast.LENGTH_SHORT).show();
        Log.d("App State ", s);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logMethod("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logMethod("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logMethod( "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logMethod( "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logMethod( "onDestroy()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        logMethod( "onSaveInstanceState()");
        outState.putBoolean("Pressure", pressure.isChecked());
        outState.putBoolean("Wind", windSpeed.isChecked());
        outState.putString("City", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logMethod("onRestoreInstanceState()");
        pressure.setChecked(savedInstanceState.getBoolean("Pressure"));
        windSpeed.setChecked(savedInstanceState.getBoolean("Wind"));
        editText.setText(savedInstanceState.getString("City"));
    }

}