package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

data class Pickup(
    var orderid:Int, var userid:Int, var location:String,
    var pickuptime:Int) {
}



//Creating object
object DBpickup {
    val Table_Name = "pickup"

    object Columns {
        var order_id="orderid"
        val user_id = "id"
        val location = "location"
        val pickupTime = "pickuptime"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.order_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.user_id} INTEGER,
        ${Columns.location} TEXT,
        ${Columns.pickupTime} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, p: Pickup) {
        val row = ContentValues()
        row.put(Columns.order_id, p.orderid)
        row.put(Columns.user_id, p.userid)
        row.put(Columns.location, p.location)
        row.put(Columns.pickupTime, p.pickuptime)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<Pickup> {
        val pickList = ArrayList<Pickup>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.user_id, Columns.user_id,
                Columns.location, Columns.pickupTime
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val pickV = Pickup(
                c.getInt(1), c.getInt(2), c.getString(3),
                c.getInt(4),
            )
            pickList.add(pickV)
        }
        return pickList
    }
}