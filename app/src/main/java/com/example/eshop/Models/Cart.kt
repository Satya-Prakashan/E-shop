package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

data class Cart(
    var userid:Int, var productid:Int, var productquality:Int,
    var price:Int) {
}



//Creating object
object DBCart {
    val Table_Name = "cart"

    object Columns {
        val user_id = "id"
        val product_id = "productid"
        val product_quantity = "productquantity"
        val price = "price"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.user_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.product_id} INTEGER,
        ${Columns.product_quantity} INTEGER,
        ${Columns.price} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, todo: Cart) {
        val row = ContentValues()
        row.put(Columns.user_id, todo.userid)
        row.put(Columns.product_id, todo.productid)
        row.put(Columns.product_quantity, todo.productquality)
        row.put(Columns.price, todo.price)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<Cart> {
        val cartList = ArrayList<Cart>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.user_id, Columns.product_id,
                Columns.product_quantity, Columns.price
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val cartV = Cart(
                c.getInt(1), c.getInt(2), c.getInt(3),
                c.getInt(4),
            )
            cartList.add(cartV)
        }
        return cartList
    }
}