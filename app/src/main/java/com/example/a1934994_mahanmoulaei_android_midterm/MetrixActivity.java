package com.example.a1934994_mahanmoulaei_android_midterm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MetrixActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextMetrix;
    Button btnConvertKilometer, btnReturnFromMetrix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrix);

        InitializeScreenComponents();
    }

    private void InitializeScreenComponents() {
        editTextMetrix = findViewById(R.id.editTextMetrix);
        editTextMetrix.setText(null);

        btnConvertKilometer = findViewById(R.id.buttonConvertKilometer);
        btnConvertKilometer.setOnClickListener(this);

        btnReturnFromMetrix = findViewById(R.id.buttonReturnFromMetrix);
        btnReturnFromMetrix.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.buttonConvertKilometer: {
                ConvertKilometerToMeter();
                break;
            }
            case R.id.buttonReturnFromMetrix: {
                ReturnToMainPage();
                break;
            }
        }
    }

    private void ConvertKilometerToMeter() {
        String kilometer = editTextMetrix.getText().toString();
        if (kilometer.isEmpty()) {
            Toast.makeText(this, "The input cannot be empty!", Toast.LENGTH_LONG).show();
        } else if (!isNumber(kilometer)) {
            Toast.makeText(this, "The input MUST be only number not letter!", Toast.LENGTH_LONG).show();
        } else {
            double meter = Double.parseDouble(kilometer) * 1000;
            Toast.makeText(this, kilometer + " kilometer is " + meter + " meter", Toast.LENGTH_LONG).show();
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
