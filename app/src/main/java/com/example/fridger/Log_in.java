package com.example.fridger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fridger.model.PFP;

public class Log_in extends AppCompatActivity {

    EditText username, password;
    Button signIn, register;
    DBHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.signIn);
        register = findViewById(R.id.register);
        database = new DBHelper(this);

        signIn.setOnClickListener(new View.OnClickListener() { // damn this is anonymous function
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("") && pass.equals(""))
                {
                    // if both data is empty the user will have this warning
                    Toast.makeText(Log_in.this,"both fields are missing!!!",Toast.LENGTH_SHORT).show();
                }
                else if(user.equals(""))
                {
                    Toast.makeText(Log_in.this,"username is missing!!!",Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(""))
                {
                    Toast.makeText(Log_in.this,"password is missing!!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean checkUserPass = database.checkUsernamePassword(user,pass); // check the if the user exists in the database
                    if(checkUserPass == true)
                    {
                        PFP.image = database.getProfilePic(user);
                        PFP.db = database;
                        Toast.makeText(Log_in.this,"logging in...",Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Log_in.this,"Invalid inputs" ,Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) // this will lead you to the register frame
            {
                Toast.makeText(Log_in.this,"registering...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    public String getUser()
    {
        return username.getText().toString();
    }

    public void setUser(String user)
    {
        username.setText(user);
    }
}