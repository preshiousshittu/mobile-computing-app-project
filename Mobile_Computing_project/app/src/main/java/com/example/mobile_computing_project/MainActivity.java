package com.example.mobile_computing_project;

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
    public void ShowCart(View v){
        Intent ini = new Intent(this, cartActivity.class);
        startActivity(ini);

    }

    public void ShowStart(View v){
        Intent ini = new Intent(this, startpage.class);
        startActivity(ini);

    }
}