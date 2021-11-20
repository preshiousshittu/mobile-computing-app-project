package com.example.mobile_computing_project.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_computing_project.Activity.detailActivity;
import com.example.mobile_computing_project.Domain.ItemDomain;
import com.example.mobile_computing_project.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<ItemDomain> itemDomains;

    public PopularAdapter(ArrayList<ItemDomain> ItemDomains) {
        this.itemDomains = ItemDomains;
    }

    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(itemDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(itemDomains.get(position).getFee()));

    }



    @Override
    public int getItemCount() {
        return itemDomains.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee,addBtn;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fee = itemView.findViewById(R.id.fee);
            title = itemView.findViewById(R.id.categoryName);
            addBtn = itemView.findViewById(R.id.addBTN);
        }
    }
}
