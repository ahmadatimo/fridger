package com.example.fridger;

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
        db.execSQL("create table users(username TEXT primary key, password TEXT)");
        //this is a sequel query which creates a table "users" which will have two
        //columns one for username / one for password
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists users");
    }

    public boolean insertData(String username , String password)
    {
        SQLiteDatabase db = this.getReadableDatabase(); // database
        ContentValues values = new ContentValues();
        this.username = username;
        values.put("username",username); // add the first column to the content
        values.put("password" , password);// add the second column to the content

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



}
