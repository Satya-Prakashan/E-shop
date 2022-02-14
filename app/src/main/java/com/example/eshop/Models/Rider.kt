package com.example.eshop.Models

import android.content.ContentValues
import android.content.SearchRecentSuggestionsProvider
import android.database.sqlite.SQLiteDatabase


data class Rider(
    var riderid:Int,val riderusername:String,val riderfname:String,val riderlname:String,
    val ridertype:String,val shopid:Int,val thirdparty:String,val rating:Int) {
}



//Creating object
object DBRider {
    val Table_Name = "rider"

    object Columns {
        val rider_id = "id"
        val rider_username = "productid"
        val rider_fname = "ridrefname"
        val rider_lname="riderlname"
        val rider_type="ridertype"
        val shop_id="shopid"
        val third_party="thridparty"
        val rating="rating"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.rider_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.rider_username} TEXT,
        ${Columns.rider_fname} TEXT,
        ${Columns.rider_lname} TEXT,
        ${Columns.rider_type} TEXT,
        ${Columns.shop_id} INTEGER,
        ${Columns.third_party} TEXT,
        ${Columns.rating} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, r: Rider) {
        val row = ContentValues()
        row.put(Columns.rider_id, r.riderid)
        row.put(Columns.rider_username, r.riderusername)
        row.put(Columns.rider_fname, r.riderfname)
        row.put(Columns.rider_lname, r.riderlname)
        row.put(Columns.rider_type, r.ridertype)
        row.put(Columns.shop_id, r.shopid)
        row.put(Columns.third_party, r.thirdparty)
        row.put(Columns.rating, r.rating)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<Rider> {
        val riderList = ArrayList<Rider>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.rider_id, Columns.rider_username,
                Columns.rider_fname, Columns.rider_lname,
                Columns.rider_type, Columns.shop_id,
                Columns.third_party, Columns.rating
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val riderV = Rider(
                c.getInt(1), c.getString(2), c.getString(3),
                c.getString(4),c.getString(5),c.getInt(6),
                c.getString(7),c.getInt(8)
            )
            riderList.add(riderV)
        }
        return riderList
    }
}