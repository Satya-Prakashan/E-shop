
    package com.example.eshop.Models

    import android.content.ContentValues
    import android.database.sqlite.SQLiteDatabase

    data class Orders(
        var productname:String, var productquality:String,
        var price: String) {
    }



    //Creating object
    object DBOrders {
        val Table_Name = "Orders"

        object Columns {
            val user_id = "id"
            val product_name = "productid"
            val product_quantity = "productquantity"
            val price = "price"
        }

        //This is creation of table if not exist
        val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.user_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.product_name} TEXT,
        ${Columns.product_quantity} TEXT,
        ${Columns.price} TEXT,
        );
    """.trimIndent()

        //Insertion of data in the table
        fun insert(db: SQLiteDatabase, od: Orders) {
            val row = ContentValues()
            row.put(Columns.product_name, od.productname)
            row.put(Columns.product_quantity, od.productquality)
            row.put(Columns.price, od.price)

            db.insert(Table_Name, null, row)
        }

        // This function will get all the queries
        fun getAll(db: SQLiteDatabase): ArrayList<Orders> {
            val orderList = ArrayList<Orders>()

            //Here below c is cursor that will signifies where current column is active
            val c = db.query(
                Table_Name, arrayOf(
                    Columns.product_name,
                    Columns.product_quantity, Columns.price
                ), null, null, null, null, null
            )

            //This will simply iterate until all the data is reterieved
            while (c.moveToNext()) {
                val orderV = Orders(
                    c.getString(1), c.getString(2),
                    c.getString(3),
                )
                orderList.add(orderV)
            }
            return orderList
        }
    }