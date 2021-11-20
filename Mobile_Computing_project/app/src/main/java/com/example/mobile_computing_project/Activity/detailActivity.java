package com.example.mobile_computing_project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobile_computing_project.Domain.CategoryDomain;
import com.example.mobile_computing_project.R;

public class detailActivity extends AppCompatActivity {
private TextView addToCardBtn;
private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt;
private ImageView plusBTN,minusBTN,giftPic;
private CategoryDomain object;
private int numberOrder = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        getBundle();
    }

    public void getBundle() {
        object=(CategoryDomain) getIntent().getSerializableExtra("object");
        Log.d("object", ""+object);

        //int drawableResourceId=this.getResources().getIdentifier(object.getPic(), "drawable",this.getPackageName());

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBTN.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBTN.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v){
                if(numberOrder>1){
                    numberOrder=numberOrder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCardBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

            }

        });
    }

    public void ShowMain(View v){
        Intent ini = new Intent(this, MainActivity.class);
        startActivity(ini);}

    public void initView(){
        addToCardBtn=findViewById(R.id.addToCartBtn );
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        plusBTN=findViewById(R.id.plusBTN);
        minusBTN=findViewById(R.id.minusBTN);
        giftPic=findViewById(R.id.giftPic);
    }
}