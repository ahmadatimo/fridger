package com.example.fridger;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fridger.model.FridgerHelper;
import com.example.fridger.model.PFP;
import com.example.fridger.model.Type;


public class Fridge extends AppCompatActivity {


    Button deleteItem , addItem;
    ImageButton back , profile , settings , vegetables , fruits , meat , liquids, fridge , recipe , shopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        initializing();
        buttonsFunctions();
        setProfile();
    }

    public void initializing()
    {
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
    }




    public void setProfile()
    {
        profile.setImageResource(PFP.image);
    }

    public void buttonsFunctions()
    {

        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Delete_Menu.class);
                startActivity(intent);
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Menu.class);
                startActivity(intent);
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
                System.out.println("You clicked Profile");
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

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "Fruits...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , StoredItems.class);
                intent.putExtra(StoredItems.copyTitle , "Fruits");

                String items = "";
                for(int i = 0 ; i< FridgerHelper.fridger.getFridge().getItemCount() ; i++){
                    if(FridgerHelper.fridger.getFridge().getItemByIndex(i).getType().equals(Type.FRUIT)) {
                        items += FridgerHelper.fridger.getFridge().getItemByIndex(i).getName() +"     :    "+ FridgerHelper.fridger.getFridge().getItemByIndex(i).getDaysLeft() + "\n"+"------------------------------\n";
                    }
                }
                 intent.putExtra(StoredItems.copyStored,items);
                startActivity(intent);
            }
        });

        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "Vegetables...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , StoredItems.class);
                intent.putExtra(StoredItems.copyTitle,"Vegetables");
                String items = "";
                for(int i = 0 ; i< FridgerHelper.fridger.getFridge().getItemCount() ; i++){
                    if(FridgerHelper.fridger.getFridge().getItemByIndex(i).getType().equals(Type.VEGETABLE)) {
                        
                        items += FridgerHelper.fridger.getFridge().getItemByIndex(i).getName() +"     :    "+ FridgerHelper.fridger.getFridge().getItemByIndex(i).getDaysLeft() + "\n"+"------------------------------\n";
                    }
                }
                intent.putExtra(StoredItems.copyStored,items);
                startActivity(intent);
            }
        });

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "Meat...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , StoredItems.class);
                intent.putExtra(StoredItems.copyTitle,"Meat");
                String items = "";
                for(int i = 0 ; i< FridgerHelper.fridger.getFridge().getItemCount() ; i++){
                    if(FridgerHelper.fridger.getFridge().getItemByIndex(i).getType().equals(Type.MEAT)) {
                        items += FridgerHelper.fridger.getFridge().getItemByIndex(i).getName() +"     :    "+ FridgerHelper.fridger.getFridge().getItemByIndex(i).getDaysLeft() +"\n------------------------------\n";
                    }
                }
                intent.putExtra(StoredItems.copyStored,items);
                startActivity(intent);

            }
        });

        liquids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Fridge.this, "Liquids...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , StoredItems.class);
                intent.putExtra(StoredItems.copyTitle,"Liquids");
                String items = "";
                for(int i = 0 ; i< FridgerHelper.fridger.getFridge().getItemCount() ; i++){
                    if(FridgerHelper.fridger.getFridge().getItemByIndex(i).getType().equals(Type.LIQUID)) {
                        items += FridgerHelper.fridger.getFridge().getItemByIndex(i).getName() +"     :    "+ FridgerHelper.fridger.getFridge().getItemByIndex(i).getDaysLeft() +"\n"+"------------------------------\n";

                    }
                }
                intent.putExtra(StoredItems.copyStored,items);
                startActivity(intent);
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
                Intent intent = new Intent(getApplicationContext() , Recipes.class);
                startActivity(intent);
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