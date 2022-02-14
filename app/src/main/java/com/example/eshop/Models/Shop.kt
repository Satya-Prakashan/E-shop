package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


data class Shop(
    var shopid:Int, var ownerid:Int, var shopname:Int,
    var shopaddress:Int,var shoplandmark:String,var shopcity:String,
    var shopcategory:String,var deliveryservice:String,var deliveryfrom:String,
    var deliveryto:String
    )
{
}



//Creating object
object DBShop {
    val Table_Name = "shop"

    object Columns {
        val shop_id = "id"
        val owner_id = "ownerid"
        val shop_name = "shop name"
        val shop_address = "shop address"
        val shop_landmark="shop landmark"
        val shop_city="shop city"
        val shop_category="shop category"
        val delivery_service="delivery service"
        val delivery_from="deliveryfrom"
        val delivery_to="deliveryto"
    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.shop_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.owner_id} INTEGER,
        ${Columns.shop_name} TEXT,
        ${Columns.shop_address} TEXT,
        ${Columns.shop_landmark} TEXT, 
        ${Columns.shop_city} TEXT,
        ${Columns.shop_category} TEXT,
        ${Columns.delivery_service} TEXT,
        ${Columns.delivery_from} TEXT,
        ${Columns.delivery_to} TEXT,
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, s: Shop) {
        val row = ContentValues()
        row.put(Columns.shop_id, s.shopid)
        row.put(Columns.owner_id, s.ownerid)
        row.put(Columns.shop_name, s.shopname)
        row.put(Columns.shop_address, s.shopaddress)
        row.put(Columns.shop_landmark, s.shoplandmark)
        row.put(Columns.shop_city, s.shopcity)
        row.put(Columns.shop_category, s.shopcategory)
        row.put(Columns.delivery_service, s.deliveryservice)
        row.put(Columns.delivery_from, s.deliveryfrom)
        row.put(Columns.delivery_to, s.deliveryto)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<Shop> {
        val shopList = ArrayList<Shop>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.shop_id, Columns.owner_id,
                Columns.shop_name, Columns.shop_address,
                Columns.shop_landmark, Columns.shop_city,
                Columns.shop_category, Columns.delivery_service,
                Columns.delivery_from, Columns.delivery_to,

            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val shopV = Shop(
                c.getInt(1), c.getInt(2), c.getInt(3),
                c.getInt(4),c.getString(5),c.getString(6),
                c.getString(7),c.getString(8),c.getString(9),
                c.getString(10)
            )
            shopList.add(shopV)
        }
        return shopList
    }
}