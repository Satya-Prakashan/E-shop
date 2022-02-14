package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


data class ProductOrdered(
    var orderid:Int, var productid:Int, var productquality:Int,
    var price:Int) {
}



//Creating object
object DBProductOrdered {
    val Table_Name = "productordered"

    object Columns {
        val order_id = "id"
        val product_id = "productid"
        val product_quantity = "productquantity"
        val price = "price"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.order_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.product_id} INTEGER,
        ${Columns.product_quantity} INTEGER,
        ${Columns.price} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, po: ProductOrdered) {
        val row = ContentValues()
        row.put(Columns.order_id, po.orderid)
        row.put(Columns.product_id, po.productid)
        row.put(Columns.product_quantity, po.productquality)
        row.put(Columns.price, po.price)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<ProductOrdered> {
        val cartList = ArrayList<ProductOrdered>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.order_id, Columns.product_id,
                Columns.product_quantity, Columns.price
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val orV = ProductOrdered(
                c.getInt(1), c.getInt(2), c.getInt(3),
                c.getInt(4),
            )
            cartList.add(orV)
        }
        return cartList
    }
}