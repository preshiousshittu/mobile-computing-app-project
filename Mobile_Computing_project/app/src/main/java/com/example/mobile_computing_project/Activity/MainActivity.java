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

   /* private void recyclerViewPopularList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList =findViewById(R.id.popular_items);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<ItemDomain> itemlist = new ArrayList<>();
        itemlist.add(new ItemDomain("wje","dfjn",10.0));
        adaptar2 = new PopularAdapter(itemlist);
        recyclerViewPopularList.setAdapter(adaptar2);
    }*/



    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.categories);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Balloons"));
        categoryList.add(new CategoryDomain("Banners"));
        categoryList.add(new CategoryDomain("Centerpiece"));
        categoryList.add(new CategoryDomain("Hats"));
        categoryList.add(new CategoryDomain("Drinks"));
        categoryList.add(new CategoryDomain("Cake"));


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