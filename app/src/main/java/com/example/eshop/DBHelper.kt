package com.example.eshop

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.eshop.Models.DBregister

class DBHelper(context:Context):SQLiteOpenHelper(
    context,"dbRegister",
    null,
    1
){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DBregister.Create_Table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}