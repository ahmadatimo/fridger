package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.fridger.model.PFP;

public class Profile extends AppCompatActivity {

    Button goBack;
    ImageButton icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9,icon10;
    ImageView main;
    int newImage = PFP.image;
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
            public void onClick(View v) {
                PFP.image = newImage;
                PFP.db.updateProfilePic(newImage);
                Profile.super.onBackPressed();
            }});

        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.bota;
                main.setImageResource(newImage);
            }
        });

        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.cartooncat;
                main.setImageResource(newImage);
            }
        });

        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.psycho_lover;
                main.setImageResource(newImage);
            }
        });

        icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.dog;
                main.setImageResource(newImage);
            }
        });

        icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.doll;
                main.setImageResource(newImage);
            }
        });

        icon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.hamster;
                main.setImageResource(newImage);
            }
        });

        icon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.ducky;
                main.setImageResource(newImage);
            }
        });

        icon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.rackon;
                main.setImageResource(newImage);
            }
        });

        icon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.rabbit;
                main.setImageResource(newImage);
            }
        });

        icon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newImage = R.drawable.kazuha;
                main.setImageResource(newImage);
            }
        });

    }



}