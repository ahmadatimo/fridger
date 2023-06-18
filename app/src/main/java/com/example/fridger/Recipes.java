package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fridger.model.PFP;
import com.example.fridger.model.ViewPagerModel;

import java.util.ArrayList;

public class Recipes extends AppCompatActivity {


    ViewPager viewPager;
    PagerAdapter adapter;
    ArrayList<ViewPagerModel> contents;

    ImageButton goBack ,profile ,settings ,previous ,next ,fridge ,recipes ,shopping;
    Button button;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);


        initializingAttributes();
        initializingButtons();
        setProfile();


    }

    public void initializingAttributes()
    {
        goBack = findViewById(R.id.Rback);
        profile = findViewById(R.id.Rprofile);
        settings = findViewById(R.id.Rsettings);
        //previous = findViewById(R.id.previous);
        //next = findViewById(R.id.next);
        fridge = findViewById(R.id.RfridgeIcon);
        recipes = findViewById(R.id.RrecipeIcon);
        shopping = findViewById(R.id.RshoppingIcon);
        button = findViewById(R.id.howTo);
        title = findViewById(R.id.recipeTitle);
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void initializingButtons()
    {
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() ,MainMenu.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Profile.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Settings.class);
                startActivity(intent);
            }
        });
        /**
         previous.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
        });

         next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
        });
         */
        fridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fridge.class);
                startActivity(intent);
            }
        });

        recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Recipes.this, "Are you trying to be funny ?", Toast.LENGTH_SHORT).show();
            }
        });

      /**
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       */

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(Recipes.this, "No shame to learn", Toast.LENGTH_SHORT).show();
              Intent intent = new Intent(getApplicationContext() , HowToCook.class);
              startActivity(intent);
          }
      });

    }

    public void setProfile()
    {
        profile.setImageResource(PFP.image);
    }
}