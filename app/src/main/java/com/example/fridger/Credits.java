package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Credits extends AppCompatActivity {

    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        ok = findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(Credits.this, "Thanks for checking the credits", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , MainMenu.class);
                startActivity(intent);
            }
        });
    }
}