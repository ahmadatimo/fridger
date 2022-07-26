package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoredItems extends AppCompatActivity {

    Button ok;
    TextView recipeTitle,changeStored;
    final static  String copyTitle = "copyTitle";
    final static  String copyStored = "CopyStored";
    String title , stored;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stored_items);


        initializing();
        changeData();
        buttonsFunctions();

    }

    public void initializing()
    {
        ok = findViewById(R.id.stored_items_ok);
        recipeTitle = findViewById(R.id.howToCookTitle);
        changeStored = findViewById(R.id.howToText);
        title = "";
        stored = "";
    }

    public void changeData()
    {
        Intent intent = getIntent();
        title = intent.getStringExtra(copyTitle);
        stored = intent.getStringExtra(copyStored);
        recipeTitle.setText(title);
        changeStored.setText(stored);
    }

    public void buttonsFunctions()
    {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               StoredItems.super.onBackPressed();
            }
        });
    }
}