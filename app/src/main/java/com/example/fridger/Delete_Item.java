package com.example.fridger;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Delete_Item extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView textView;
    Button button;
    ImageView image;
    static String arrayOfItemsNames = "";
    static String textViewName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);

        initializing();
        setTypeChanger();
        buttonsFunction();
    }

    public void initializing()
    {
        textView = findViewById(R.id.deleteTypeName);
        spinner = findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.Fruits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        button = findViewById(R.id.goBackFromDeleteItem);
        image = findViewById(R.id.deleteItemImage);
    }


    public void setTypeChanger()
    {
        Intent intent = getIntent();
        textViewName = intent.getStringExtra(textViewName);
        textView.setText(textViewName);
        if(textView.getText().equals("Fruits"))
        {
            image.setImageResource(R.drawable.fruits);
            adapter = ArrayAdapter.createFromResource(this,R.array.Fruits, android.R.layout.simple_spinner_item);
        }
        else if(textView.getText().equals("Vegetables"))
        {
            image.setImageResource(R.drawable.vegetables);
            adapter = ArrayAdapter.createFromResource(this,R.array.Vegetables, android.R.layout.simple_spinner_item);
        }
        else if(textView.getText().equals("Meat"))
        {
            image.setImageResource(R.drawable.meat);
            adapter = ArrayAdapter.createFromResource(this,R.array.Meat, android.R.layout.simple_spinner_item);
        }
        else
        {
            image.setImageResource(R.drawable.water);
            adapter = ArrayAdapter.createFromResource(this,R.array.Liquids, android.R.layout.simple_spinner_item);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void buttonsFunction()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete_Item.super.onBackPressed();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}