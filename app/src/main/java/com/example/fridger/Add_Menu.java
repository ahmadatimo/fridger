package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Add_Menu extends AppCompatActivity {
    Button back;
    ImageButton fruits ,vegetables ,meat , liquids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        back = findViewById(R.id.goBack);
        fruits = findViewById(R.id.addFruits);
        vegetables = findViewById(R.id.addVegetables);
        meat = findViewById(R.id.addMeat);
        liquids = findViewById(R.id.addLiquid);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fridge.class);
                startActivity(intent);
            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Item.class);
                intent.putExtra(Add_Item.typeChanger,"Fruit");
                startActivity(intent);
            }
        });

        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Item.class);
                intent.putExtra(Add_Item.typeChanger,"Vegetable");
                intent.putExtra(Add_Item.textSize,23);
                startActivity(intent);
            }
        });

        meat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Item.class);
                intent.putExtra(Add_Item.typeChanger,"Meat");
                startActivity(intent);
            }
        });

        liquids.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Item.class);
                intent.putExtra(Add_Item.typeChanger,"Liquid");
                intent.putExtra(Add_Item.textSize,23);
                startActivity(intent);
            }
        });

    }


}