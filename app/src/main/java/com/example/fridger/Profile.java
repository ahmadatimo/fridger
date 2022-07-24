package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.fridger.model.PFP;

public class Profile extends AppCompatActivity {

    PFP profilePicture;
    Button goBack;
    ImageButton icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9,icon10;
    ImageView main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initializer();
        buttonsFunction();
    }

    public  void initializer()
    {
        goBack = findViewById(R.id.goBack);
        main = findViewById(R.id.mainIcon);
        icon1 = findViewById(R.id.icon1);
        icon2 = findViewById(R.id.icon2);
        icon3 = findViewById(R.id.icon3);
        icon4 = findViewById(R.id.icon4);
        icon5 = findViewById(R.id.icon5);
        icon6 = findViewById(R.id.icon6);
        icon7 = findViewById(R.id.icon7);
        icon8 = findViewById(R.id.icon8);
        icon9 = findViewById(R.id.icon9);
        icon10 = findViewById(R.id.icon10);
    }

    public void buttonsFunction()
    {
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Profile.super.onBackPressed();}});

        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.bota);
            }
        });

        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.cartooncat);
            }
        });

        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.psycho_lover);
            }
        });

        icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.dog);
            }
        });

        icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.doll);
            }
        });

        icon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.hamster);
            }
        });

        icon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.ducky);
            }
        });

        icon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.rackon);
            }
        });

        icon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.rabbit);
            }
        });

        icon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setImageResource(R.drawable.kazuha);
            }
        });
    }


}