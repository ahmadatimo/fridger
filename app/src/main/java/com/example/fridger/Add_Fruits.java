package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Fruits extends AppCompatActivity {

    EditText fruit , quantity , daysLeft;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fruits);

        fruit = findViewById(R.id.nameOfFruit);
        quantity = findViewById(R.id.numOfFruit);
        daysLeft = findViewById(R.id.fDaysLeft);
        goBack =  findViewById(R.id.goBack);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Menu.class);
                startActivity(intent);
            }
        });
    }
}