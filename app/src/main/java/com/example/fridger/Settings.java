package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class Settings extends AppCompatActivity {

    Button logOut , goBack, okPassword, okUser;
    ImageButton userPencil , passPencil;
    TextView username,password;
    EditText editUsername,editPassword;
    DBHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        logOut = findViewById(R.id.logOut);
        goBack = findViewById(R.id.goBack);
        okPassword = findViewById(R.id.okForPassword);
        okUser = findViewById(R.id.okForUser);
        userPencil = findViewById(R.id.userpencil);
        passPencil = findViewById(R.id.passpencil);
        username = findViewById(R.id.usernameViewText);
        password = findViewById(R.id.passwordViewText);
        editUsername = findViewById(R.id.usernameEditText);
        editPassword = findViewById(R.id.passwordEditText);
        database = new DBHelper(this);
        editUsername.setVisibility(View.INVISIBLE);
        okPassword.setVisibility(View.INVISIBLE);
        okUser.setVisibility(View.INVISIBLE);


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

        userPencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okUser.setVisibility(View.VISIBLE);
                username.setVisibility(View.INVISIBLE);
                editUsername.setVisibility(View.VISIBLE);
            }
        });

        okUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editUsername.getText().toString();
                Boolean checkUserUpdate = database.updateUsername(name);

                if(checkUserUpdate == true)
                {
                    username.setText(name);
                    Toast.makeText(Settings.this, "Your Username is updated", Toast.LENGTH_SHORT).show();
                }
                username.setVisibility(View.VISIBLE);
                editUsername.setVisibility(View.INVISIBLE);
                okUser.setVisibility(View.INVISIBLE);
            }
        });

        passPencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okPassword.setVisibility(View.VISIBLE);
                password.setVisibility(View.INVISIBLE);
                editPassword.setVisibility(View.VISIBLE);


            }
        });

        okPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = editPassword.getText().toString();

                Boolean checkPasswordUpdate = database.updatePassword(pass);

                if(checkPasswordUpdate == true)
                {
                    String stars = "";
                    for(int i = 0; i < editPassword.getText().length(); i++)
                    {
                        stars = stars + "*";
                    }
                    password.setText(stars);
                    Toast.makeText(Settings.this, "Your password is updated", Toast.LENGTH_SHORT).show();
                }
                password.setVisibility(View.VISIBLE);
                editPassword.setVisibility(View.INVISIBLE);
                okPassword.setVisibility(View.INVISIBLE);
            }
        });
    }
}