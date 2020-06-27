package com.superuser.edunomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogin(View view){
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
    public void onClickRegister(View view){
        startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
        finish();
    }
}