package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    Button logOut , goBack;
    ImageButton userpencil , passpencil;
    DBHelper database;
    Log_in user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        logOut = findViewById(R.id.logOut);
        goBack = findViewById(R.id.goBack);
        userpencil = findViewById(R.id.userpencil);
        passpencil = findViewById(R.id.passpencil);
        database = new DBHelper(this);
        user = new Log_in();

        logOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(Settings.this, "Logging out...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , Log_in.class);
                startActivity(intent);
            }
        });

        goBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Settings.super.onBackPressed(); // this turn u back to the previous frame
            }
        });

        passpencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user.getUser();
            }
        });
    }
}