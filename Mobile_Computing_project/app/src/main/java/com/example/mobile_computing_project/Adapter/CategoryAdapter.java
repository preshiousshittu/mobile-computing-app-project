package com.example.mobile_computing_project.Adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_computing_project.Activity.detailActivity;
import com.example.mobile_computing_project.Domain.CategoryDomain;
import com.example.mobile_computing_project.R;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cat, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        holder.categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ini = new Intent(holder.itemView.getContext(), detailActivity.class);
                ini.putExtra( "object", (Serializable) categoryDomains.get( holder.getAdapterPosition() ) );
                holder.itemView.getContext().startActivity(ini);
            }
        });
    }



    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
