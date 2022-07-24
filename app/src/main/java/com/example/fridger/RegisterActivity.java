package com.example.fridger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fridger.model.Fridger;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password , confirmPassword;
    Button register, signin;
    DBHelper database;
    Fridger fridger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        register = findViewById(R.id.register);
        signin = findViewById(R.id.signin);
        database = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 //we get the data
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirmPassword.getText().toString();

                //this "if" to check that the fields are not empty
                if (user.equals("") || pass.equals("")|| confirm.equals(""))
                {
                    // if one of the data is empty the user will have this warning
                    Toast.makeText(RegisterActivity.this,"Some data are missing!!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (pass.equals(confirm)) // we check if the password = confirm password
                    {
                        boolean checkUser = database.checkUsername(user);//we go over the database and see if we have the same username
                        if(checkUser == false) // if we do not have we will accept the new username
                        {
                            boolean add = database.insertData(user,pass); // we will add the new input to the database
                            if(add == true) // the database had been written
                            {
                                Toast.makeText(RegisterActivity.this,"The new account is Registered",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainMenu.class);
                                fridger = new Fridger(user,pass);
                                startActivity(intent); // will jump to main menu
                            }
                            else
                            {
                                Toast.makeText(RegisterActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"The username is taken",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else // if password != confirm password
                    {
                        Toast.makeText(RegisterActivity.this,"The password is not the same as confirm password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Log_in.class);
                startActivity(intent);
            }
        });

    }
    public Fridger getFridger(){

        return this.fridger;
    }

    //helo
}