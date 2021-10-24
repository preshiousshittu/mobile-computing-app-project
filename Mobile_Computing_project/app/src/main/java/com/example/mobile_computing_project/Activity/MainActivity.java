package com.example.mobile_computing_project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobile_computing_project.R;

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
    public void ShowDetail(View v){
        Intent ini = new Intent(this, detailActivity.class);
        startActivity(ini);

    }
}