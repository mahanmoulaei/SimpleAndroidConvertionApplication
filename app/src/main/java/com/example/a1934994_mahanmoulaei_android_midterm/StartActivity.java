package com.example.a1934994_mahanmoulaei_android_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTemperature, btnMetrix, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        InitializeScreenComponents();
    }

    private void InitializeScreenComponents() {
        btnTemperature = findViewById(R.id.buttonTemperature);
        btnTemperature.setOnClickListener(this);

        btnMetrix = findViewById(R.id.buttonMetrix);
        btnMetrix.setOnClickListener(this);

        btnEnd = findViewById(R.id.buttonEnd);
        btnEnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.buttonTemperature: {
                OpenTemperaturePage();
                break;
            }
            case R.id.buttonMetrix: {
                OpenMetrixPage();
                break;
            }
            case R.id.buttonEnd: {
                QuitApp();
                break;
            }
        }
    }

    private void OpenTemperaturePage() {
        Intent intent = new Intent(this, TemperActivity.class);
        startActivity(intent);
    }

    private void OpenMetrixPage() {
        Intent intent = new Intent(this, MetrixActivity.class);
        startActivity(intent);
    }

    private void QuitApp() {
        System.exit(0);
    }

}