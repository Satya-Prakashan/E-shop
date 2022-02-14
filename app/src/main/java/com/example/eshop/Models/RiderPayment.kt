package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


data class RiderPayment(
    var riderid:Int, var orderid:Int, var paymentid:Int,
    var paymentrecieved:Int) {
}



//Creating object
object DBRiderPayment {
    val Table_Name = "riderpayment"

    object Columns {
        val rider_id = "id"
        val order_id="orderid"
        val payment_id = "paymentid"
        val payment_recieved = "paymentrecieved"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.rider_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.order_id} INTEGER,
        ${Columns.payment_id} INTEGER,
        ${Columns.payment_recieved} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, rp: RiderPayment) {
        val row = ContentValues()
        row.put(Columns.rider_id, rp.riderid)
        row.put(Columns.order_id, rp.orderid)
        row.put(Columns.payment_id, rp.paymentid)
        row.put(Columns.payment_recieved, rp.paymentrecieved)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<RiderPayment> {
        val riderList = ArrayList<RiderPayment>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.rider_id, Columns.order_id,
                Columns.payment_id, Columns.payment_recieved
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val riderV = RiderPayment(
                c.getInt(1), c.getInt(2), c.getInt(3),
                c.getInt(4),
            )
            riderList.add(riderV)
        }
        return riderList
    }
}