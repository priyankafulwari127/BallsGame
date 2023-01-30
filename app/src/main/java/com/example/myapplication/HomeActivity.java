package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class HomeActivity extends AppCompatActivity {

    ArrayList<NewClass> list;
    Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int count = Integer.parseInt(getIntent().getStringExtra("number"));

        RecyclerView recyclerView = findViewById(R.id.recycleriew);

        list = new ArrayList<>();

        for(int i=0; i<count; i++){
            NewClass n = new NewClass();
            n.position = i;
            n.state = 0;
            list.add(n);
        }
        adapter = new Adapter(list,this);

        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(adapter);

    }

}