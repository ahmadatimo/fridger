package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Delete_Menu extends AppCompatActivity {

    ImageButton fruit , vegetable , meat , liquid;
    Button goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_menu);

        initializing();
        buttonsFunction();

    }

    public void initializing()
    {
        goBack = findViewById(R.id.goBack);
        fruit = findViewById(R.id.removeFruits);
        vegetable = findViewById(R.id.removeVegetables);
        meat = findViewById(R.id.removeMeat);
        liquid = findViewById(R.id.removeLiquid);
    }

    public void buttonsFunction()
    {

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Fridge.class);
                startActivity(intent);
            }
        });

        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Delete_Item.class);
                int holder = R.array.Fruits;
                intent.putExtra(Delete_Item.textViewName,"Fruits");
                startActivity(intent);
            }
        });

        vegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Delete_Item.class);
                intent.putExtra(Delete_Item.textViewName,"Vegetables");
                startActivity(intent);
            }
        });

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Delete_Item.class);
                int holder = R.array.Meat;
                intent.putExtra(Delete_Item.textViewName,"Meat");
                intent.putExtra(Delete_Item.arrayOfItemsNames , holder);
                startActivity(intent);
            }
        });

        liquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Delete_Item.class);
                int holder = R.array.Meat;
                intent.putExtra(Delete_Item.textViewName,"Liquids");
                intent.putExtra(Delete_Item.arrayOfItemsNames , holder);
                startActivity(intent);
            }
        });
    }
}