package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


data class UserOrder(
    var orderid:Int, var amount:Int, var promocode:String,
    var discount:Int,var finalamount:Int,var paymentid:Int,var userid:Int,
    var ordertype:String, var deliverchanges:Int,
    var orderaccepted:String,var shopid:Int
        ) {
}



//Creating object
object DBUserOrder {
    val Table_Name = "userorder"

    object Columns {
        val order_id = "id"
        val amount = "amount"
        val promocode = "promocode"
        val discount = "discount"
        val final_amount="finalamount"
        val payment_id="payment id"
        val user_id="userid"
        val order_type="ordertype"
        val delivery_changes="delivery changes"
        val order_accepted="order accepted"
        val shop_id="shopid"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.order_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.amount} INTEGER,
        ${Columns.promocode} TEXT,
        ${Columns.discount} INTEGER,
        ${Columns.final_amount} INTEGER,
        ${Columns.payment_id} INTEGER,
        ${Columns.user_id} INTEGER,
        ${Columns.order_type} TEXT,
        ${Columns.delivery_changes} INTEGER,
        ${Columns.order_accepted} TEXT,
        ${Columns.shop_id} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, uo: UserOrder) {
        val row = ContentValues()
        row.put(Columns.order_id, uo.orderid)
        row.put(Columns.amount, uo.amount)
        row.put(Columns.promocode, uo.promocode)
        row.put(Columns.discount, uo.discount)
        row.put(Columns.user_id, uo.userid)
        row.put(Columns.final_amount, uo.finalamount)
        row.put(Columns.payment_id, uo.paymentid)
        row.put(Columns.user_id, uo.userid)
        row.put(Columns.order_type, uo.ordertype)
        row.put(Columns.delivery_changes, uo.deliverchanges)
        row.put(Columns.order_accepted, uo.orderaccepted)
        row.put(Columns.shop_id, uo.shopid)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<UserOrder> {
        val orderList = ArrayList<UserOrder>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.order_id, Columns.amount,
                Columns.promocode, Columns.discount,
                Columns.final_amount, Columns.payment_id,
                Columns.user_id, Columns.order_type,
                Columns.delivery_changes, Columns.order_accepted,
                Columns.shop_id
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val orderV = UserOrder(
                c.getInt(1), c.getInt(2), c.getString(3),
                c.getInt(4),c.getInt(5),c.getInt(6),c.getInt(7),
                c.getString(8),c.getInt(9),c.getString(10),c.getInt(11)
            )
            orderList.add(orderV)
        }
        return orderList
    }
}