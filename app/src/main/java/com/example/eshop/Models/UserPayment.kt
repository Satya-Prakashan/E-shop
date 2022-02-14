package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract


data class UserPayment(
    var paymentid:Int, var userid:Int, var paymentmode:String,
    var paymentdata:String,var paymenttime:String,var paymentamount:String,
    var paymentstatus:String
    ) {
}



//Creating object
object DBUserPayment {
    val Table_Name = "userpayment"

    object Columns {
        val payment_id = "paymentid"
        val user_id = "userid"
        val payment_mode = "paymentmode"
        val payment_date = "paymentdata"
        val payment_time = "paymenttime"
        val payment_amount = "paymentamount"
        val payment_status = "paymentstatus"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.payment_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.user_id} INTEGER,
        ${Columns.payment_mode} TEXT,
        ${Columns.payment_date} TEXT,
        ${Columns.payment_time} TEXT,
        ${Columns.payment_amount} TEXT,
        ${Columns.payment_status} TEXT
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, up: UserPayment) {
        val row = ContentValues()
        row.put(Columns.payment_id, up.paymentid)
        row.put(Columns.user_id, up.userid)
        row.put(Columns.payment_mode, up.paymentmode)
        row.put(Columns.payment_date, up.paymentdata)
        row.put(Columns.payment_time, up.paymenttime)
        row.put(Columns.payment_amount, up.paymentamount)
        row.put(Columns.payment_status, up.paymentstatus)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<UserPayment> {
        val paymentList = ArrayList<UserPayment>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.payment_id, Columns.user_id,
                Columns.payment_mode, Columns.payment_date,
                Columns.payment_amount,
                Columns.payment_status, Columns.payment_time

            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val paymentV = UserPayment(
                c.getInt(1), c.getInt(2), c.getString(3),
                c.getString(4),c.getString(5),
                c.getString(6),c.getString(7)
            )
            paymentList.add(paymentV)
        }
        return paymentList
    }
}