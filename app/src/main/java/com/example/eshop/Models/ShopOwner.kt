package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


data class ShopOwner(
    var ownerid:Int, var ownerusername:String,var ownerpass:String,
    var ownerfname:String,
    var ownerlname:String) {
}



//Creating object
object DBShopOwner {
    val Table_Name = "shopowner"

    object Columns {
        val owner_id = "id"
        val owner_username="ownmerusername"
        val owner_pass="ownerpass"
        val owner_fname = "ownerfname"
        val owner_lname="ownerfname"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.owner_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.owner_username} TEXT,
        ${Columns.owner_pass} TEXT,
        ${Columns.owner_fname} TEXT,
        ${Columns.owner_lname} TEXT,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, so: ShopOwner) {
        val row = ContentValues()
        row.put(Columns.owner_id, so.ownerid)
        row.put(Columns.owner_username, so.ownerusername)
        row.put(Columns.owner_pass, so.ownerpass)
        row.put(Columns.owner_fname, so.ownerfname)
        row.put(Columns.owner_fname, so.ownerlname)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<ShopOwner> {
        val shopownerList = ArrayList<ShopOwner>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.owner_id, Columns.owner_username,
                Columns.owner_pass, Columns.owner_fname,Columns.owner_lname
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val shopV = ShopOwner(
                c.getInt(1), c.getString(2), c.getString(3),
                c.getString(4),c.getString(5)
            )
            shopownerList.add(shopV)
        }
        return shopownerList
    }
}