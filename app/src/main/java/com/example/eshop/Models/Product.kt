package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


data class Product(
    var productid:Int, var productquality:Int,
    var productname:String,
    var productprice:Int,var createdat:String,var modifiedat:String,
    var productimage:Int,var shopid:Int) {
}



//Creating object
object DBProduct {
    val Table_Name = "product"

    object Columns {
        val product_id = "productid"
        val product_name="procuctname"
        val product_quantity = "productquantity"
        val product_price = "price"
        val created_at="createdat"
        val modified_at="modifiedat"
        val product_image="productimage"
        val shop_id="shopid"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.product_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.product_name} TEXT,
        ${Columns.product_quantity} INTEGER,
        ${Columns.product_price} INTEGER,
        ${Columns.created_at} TEXT,
        ${Columns.modified_at} TEXT,
        ${Columns.product_image} INTEGER,
        ${Columns.shop_id} INTEGER,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, p: Product) {
        val row = ContentValues()
        row.put(Columns.product_id, p.productid)
        row.put(Columns.product_name, p.productname)
        row.put(Columns.product_quantity, p.productquality)
        row.put(Columns.product_price, p.productprice)
        row.put(Columns.created_at, p.createdat)
        row.put(Columns.modified_at, p.modifiedat)
        row.put(Columns.product_image, p.productimage)
        row.put(Columns.shop_id, p.shopid)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<Product> {
        val prodList = ArrayList<Product>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.product_id, Columns.product_name,
                Columns.product_quantity, Columns.product_price,
                Columns.created_at, Columns.modified_at,
                Columns.product_image, Columns.shop_id
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val prodV = Product(
                c.getInt(1), c.getInt(2), c.getString(3),
                c.getInt(4),c.getString(5),c.getString(6),c.getInt(7),c.getInt(8)
            )
            prodList.add(prodV)
        }
        return prodList
    }
}