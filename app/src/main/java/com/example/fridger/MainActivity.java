package com.example.fridger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fridger.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button signIn, register;
    DBHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Toast.makeText(MainActivity.this,"both fields are missing!!!",Toast.LENGTH_SHORT).show();
                }
                else if(user.equals(""))
                {
                    Toast.makeText(MainActivity.this,"username is missing!!!",Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(""))
                {
                    Toast.makeText(MainActivity.this,"password is missing!!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean checkUserPass = database.checkUsernamePassword(user,pass); // check the if the user exists in the database
                    if(checkUserPass == true)
                    {
                        Toast.makeText(MainActivity.this,"logging in...",Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Invalid inputs" ,Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) // this will lead you to the register frame
            {
                Toast.makeText(MainActivity.this,"registering...",Toast.LENGTH_SHORT).show();
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