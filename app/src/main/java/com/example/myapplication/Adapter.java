package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<NewClass> list;
    private Context context;

    public Adapter(List<NewClass> userlist, Context context){
        this.context = context;
        this.list = userlist;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getRandomNumber();
        }
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_design,parent,false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        switch (list.get(position).state) {
            case 0 : holder.cardView.setCardBackgroundColor(Color.WHITE);
            break;
            case 1: holder.cardView.setCardBackgroundColor(Color.BLUE);
            break;
            case 2: holder.cardView.setCardBackgroundColor(Color.RED);
            break;
        }
        holder.cardView.setOnClickListener(view -> {
            if (list.get(position).state == 1) {
                list.get(position).state = 2;
                switch (list.get(position).state) {
                    case 0 : holder.cardView.setCardBackgroundColor(Color.WHITE);
                        break;
                    case 1: holder.cardView.setCardBackgroundColor(Color.BLUE);
                        break;
                    case 2: holder.cardView.setCardBackgroundColor(Color.RED);
                        break;
                }
                getRandomNumber();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void getRandomNumber(){
        final int num = new Random().nextInt(list.size());

        if (list.get(num).state==0) {
            // ser dot to blue
            list.get(num).state = 1;
            notifyDataSetChanged();
        }
        else {
            boolean check = false ;
            int red = 0;
            for (int i=0;i<list.size();i++) {
                if (list.get(i).state==2) {
                    red++;
                }
            }
            if (red==list.size()) {

                Toast.makeText(context,"GAME OVER",Toast.LENGTH_SHORT).show();
            } else {
                getRandomNumber();
            }
        }
    }
}
