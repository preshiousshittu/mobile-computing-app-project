package com.example.mobile_computing_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class startpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);


    }
    public void ShowMain(View v){
        Intent ini = new Intent(this, MainActivity.class);
        startActivity(ini);}
}