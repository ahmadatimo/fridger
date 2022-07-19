package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Fridge extends AppCompatActivity {

    Button deleteItem , addItem;
    ImageButton back , profile , settings , vegetables , fruits , meat , liquids, fridge , recipe , shopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        deleteItem = findViewById(R.id.deleteItem);
        addItem = findViewById(R.id.addItem);
        back = findViewById(R.id.Fback);
        profile = findViewById(R.id.Fprofile);
        settings = findViewById(R.id.Fsettings);
        vegetables = findViewById(R.id.vegetables);
        fruits = findViewById(R.id.fruits);
        meat = findViewById(R.id.meat);
        liquids = findViewById(R.id.liquids);
        fridge = findViewById(R.id.FfridgeIcon);
        recipe = findViewById(R.id.FrecipeIcon);
        shopping = findViewById(R.id.FshoppingIcon);

        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "no function added yet", Toast.LENGTH_SHORT).show();
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "no function added yet", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainMenu.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Profile.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Settings.class);
                startActivity(intent);
            }
        });

        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "not ready yet", Toast.LENGTH_SHORT).show();
            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "not made yet", Toast.LENGTH_SHORT).show();
            }
        });

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "not made yet", Toast.LENGTH_SHORT).show();
            }
        });

        liquids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this,"not done yet", Toast.LENGTH_SHORT).show();
            }
        });

        fridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "you are already in \"fridge\" section", Toast.LENGTH_SHORT).show();
            }
        });

        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "not ready yet", Toast.LENGTH_SHORT).show();
            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "not ready yet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}