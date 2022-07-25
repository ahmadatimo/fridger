package com.example.fridger;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import java.sql.SQLException;


public class DBHelper extends SQLiteOpenHelper {

    String username = "";

    final static String DBNAME = "Login.db"; //name of database in the android device

    public DBHelper(Context context) // constructor
    {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table users(username TEXT primary key, password TEXT, profilePic INTEGER)");
        //this is a sequel query which creates a table "users" which will have three
        //columns one for username / one for password
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists users");
    }

    public boolean insertData(String username , String password, int profilePic)
    {
        SQLiteDatabase db = this.getReadableDatabase(); // database
        ContentValues values = new ContentValues();
        this.username = username;
        values.put("username",username); // add the first column to the content
        values.put("password" , password);// add the second column to the content
        values.put("profilePic", profilePic);

        long result = db.insert("users" , null , values);
        if (result == -1)// the previous line will check if the username and password
        {                // are stored if yes will return true if no will return false
            return  false;
        }
        else
        {
            return  true;
        }
    }

    public boolean checkUsername(String username)// this function will check if the username
    {                                            // is already in our database or not
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount() > 0 )
        {
            return  true; // username exists in the database
        }
        else
        {
            return  false; // username does not exist in the database
        }
    }

    public boolean checkUsernamePassword(String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =
        db.rawQuery("select * from users where username = ? and password = ?", new String[] {username,password});
        if (cursor.getCount() > 0)
        {
            return  true;
        }
        else
        {
            return  false;
        }
    }

    public int getProfilePic(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {username});//run query
        //make an imaginary table with all the rows that have the user names we created
        int index = cursor.getColumnIndex("profilePic");
        System.out.println("index: " + index + " --- cursorCount: " + cursor.getCount()); //for debugging purposes
        if (cursor.getCount() > 0 && index >= 0)
        {
            cursor.moveToNext();// it is like a list it does not move unless we call this function
            return cursor.getInt(index);
        }
        else
        {
            return -1;
        }
    }

    public boolean updateUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        long result = db.update("users",values, "username = ?", new String[]{this.username});
        if (result == -1)// the previous line will check if the username and password
        {                // are stored if yes will return true if no will return false
            return  false;
        }
        else
        {
            return  true;
        }
    }

    public boolean updatePassword( String password){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        long result = db.update("users",values, "username = ?", new String[]{username});
        if (result == -1)// the previous line will check if the username and password
        {                // are stored if yes will return true if no will return false
            return  false;
        }
        else
        {
            return  true;
        }
    }

    public void updateProfilePic(int profilePic)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("profilePic", profilePic);
        db.update("users",values,"username = ?", new String[]{username});
    }


}



