package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fridger.model.Item;
import com.example.fridger.model.Type;

public class Add_Item extends AppCompatActivity {

    EditText item , quantity , daysLeft;
    TextView type;
    Button goBack, add;
    static String typeChanger= "";
    static String textSize ="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        initializingData();
        setTypeChanger();


       goBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), Add_Menu.class);
               startActivity(intent);
           }
       });

       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(Add_Item.this, "New fruit was created", Toast.LENGTH_SHORT).show();
               addItem();
           }
       });
    }

    public void initializingData()
    {
        type = findViewById(R.id.item);
        item = findViewById(R.id.itemHint);
        quantity = findViewById(R.id.itemNumber);
        daysLeft = findViewById(R.id.DaysLeft);
        add = findViewById(R.id.addAFruit);
        goBack =  findViewById(R.id.goBack);
    }

    public void setTypeChanger()
    {
        Intent intent = getIntent();
        typeChanger = intent.getStringExtra(typeChanger);
        int size = intent.getIntExtra(textSize,0);
        if(typeChanger.equals("Vegetable"))
        {
            type.setTextSize(size);
        }
        if(typeChanger.equals("Liquid"))
        {
            type.setTextSize(size+10);
        }
        type.setText(typeChanger);
        item.setHint("enter a " + typeChanger);
    }


    private void addItem()
    {
        RegisterActivity ra = new RegisterActivity();
        if(type.getText().toString().equals("Fruit") && !item.equals("") && !quantity .equals("") && !daysLeft.equals("") ){
            Toast.makeText(getApplicationContext(), "All Requirements met ", Toast.LENGTH_SHORT).show();
            String Item = item.getText().toString();
            int days = Integer.parseInt(daysLeft.getText().toString());
            Type typeF = Type.FRUIT;
            int quantit = Integer.parseInt(quantity.getText().toString());
            System.out.println(Item + "," + days  + "," + typeF + "," + quantit);
            ra.getFridger().AddItem(new Item(Item,days, typeF),quantit);
        }


        

    }

}