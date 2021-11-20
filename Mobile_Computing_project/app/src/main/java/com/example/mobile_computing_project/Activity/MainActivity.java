package com.example.mobile_computing_project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobile_computing_project.Adapter.CategoryAdapter;
import com.example.mobile_computing_project.Domain.CategoryDomain;
import com.example.mobile_computing_project.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adaptar,adaptar2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        //recyclerViewPopularList();


    }

   /* private void recycler ViewPopularList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList =findViewById(R.id.popular_items);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<ItemDomain> itemlist = new ArrayList<>();
        itemlist.add(new ItemDomain("wje","dfjn",10.0));
        adaptar2 = new PopularAdapter(itemlist);
        recyclerViewPopularList.setAdapter(adaptar2);
    }*/



    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewCategoryList=findViewById(R.id.categories);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Balloons","Inflatable rubber balloons", 2));
        categoryList.add(new CategoryDomain("Banners", "Helps to show what you are celebrating", 5));
        categoryList.add(new CategoryDomain("Centerpiece", "Extra decorations to bring life to your party", 20));
        categoryList.add(new CategoryDomain("Hats", "Birthday hats to help stay dressed", 5));
        categoryList.add(new CategoryDomain("Drinks", "We always need some drinks to keep the party going", 20));
        categoryList.add(new CategoryDomain("Cake", "The important item, you wouldn't miss out on the varities we've got",30));


        adaptar = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adaptar);
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