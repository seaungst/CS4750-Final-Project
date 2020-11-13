package com.bignerdranch.android.cs4750finalproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context, dbname, factory, version) {

    companion object {
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }

    //Create database
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user(id integer primary key autoincrement," +
        "username varchar(30), password varchar (20)")
    }

    //Inserts user account info into the database
    fun insertUserData(username: String, password: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("username", username)
        values.put("password", password)

        db.insert("user", null, values)
        db.close()
    }

    //Checks to see if user account already exists in the database
    fun verifyAccount(username: String, password: String) : Boolean {
        val db = writableDatabase
        val query = "select * from user where username = '$username' and password = '$password'"
        val cursor = db.rawQuery(query, null)

        if (cursor.count<=0) {
            cursor.close()
            return false
        }
        else {
            cursor.close()
            return true
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}