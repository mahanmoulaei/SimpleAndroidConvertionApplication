package com.example.a1934994_mahanmoulaei_android_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextTemperature;
    Button btnConvertCelcius, btnReturnFromTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temper);

        InitializeScreenComponents();
    }

    private void InitializeScreenComponents() {
        editTextTemperature = findViewById(R.id.editTextTemperature);
        editTextTemperature.setText(null);

        btnConvertCelcius = findViewById(R.id.buttonConvertCelcius);
        btnConvertCelcius.setOnClickListener(this);

        btnReturnFromTemperature = findViewById(R.id.buttonReturnFromTemperature);
        btnReturnFromTemperature.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.buttonConvertCelcius: {
                ConvertCelciusToFahrenheit();
                break;
            }
            case R.id.buttonReturnFromTemperature: {
                ReturnToMainPage();
                break;
            }
        }
    }

    private void ConvertCelciusToFahrenheit() {
        String celcius = editTextTemperature.getText().toString();
        if (celcius.isEmpty()) {
            Toast.makeText(this, "The input cannot be empty!", Toast.LENGTH_LONG).show();
        } else if (!isNumber(celcius)) {
            Toast.makeText(this, "The input MUST be only number not letter!", Toast.LENGTH_LONG).show();
        } else {
            double fahrenheit = (Double.parseDouble(celcius) * 1.8) + 32.00;
            Toast.makeText(this, celcius + " celcius degree is " + fahrenheit + " fahrenheit degree", Toast.LENGTH_LONG).show();
        }

    }

    private void ReturnToMainPage() {
        finish();
    }

    private boolean isNumber(String str) {
        try {
            double v = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
        }
        return false;
    }
}
