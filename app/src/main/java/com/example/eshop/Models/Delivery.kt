package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

data class Delivery(
    var orderid:Int, var paymentstatus:Int, var amount:Int,
    var date:Int,var time:String,var riderid:Int) {
}

//Creating object
object DBdelivery {
    val Table_Name = "delivery"

    object Columns {
        val orderId = "orderId"
        val  paymentStatus= "paymentstatus"
        val amount = "amount"
        val date = "date"
        val time="time"
        val riderId="riderid"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.orderId} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.paymentStatus} INTEGER,
        ${Columns.amount} INTEGER,
        ${Columns.date} TEXT,
        ${Columns.time} TEXT,
        ${Columns.riderId} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, t: Delivery) {
        val row = ContentValues()
        row.put(Columns.orderId, t.orderid)
        row.put(Columns.paymentStatus, t.paymentstatus)
        row.put(Columns.amount, t.amount)
        row.put(Columns.date, t.date)
        row.put(Columns.time, t.time)
        row.put(Columns.riderId, t.riderid)


        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<Delivery> {
        val delList = ArrayList<Delivery>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.orderId, Columns.paymentStatus,
                Columns.amount, Columns.date,Columns.time,Columns.riderId
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val delV = Delivery(
                c.getInt(1), c.getInt(2), c.getInt(3),
                c.getInt(4),c.getString(5),c.getInt(6)
            )
            delList.add(delV)
        }
        return delList
    }
}