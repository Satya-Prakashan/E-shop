package com.example.eshop.Models

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

data class Register(
    var fname:String, var lname:String, var email:String,
    var password:String, var phoneno: String, var address:String,
    var pincode:String) {
}



//Creating object
object DBregister {
    val Table_Name = "register"

    object Columns {
        val user_id="userid"
        val admin_fname = "adminfn"
        val admin_lname = "adminln"
        val email="email"
        val password = "password"
        val phoneno="phoneno"
        val address = "address"
        val pincode = "pincode"

    }

    //This is creation of table if not exist
    val Create_Table = """CREATE TABLE IF NOT EXISTS $Table_Name
        (${Columns.user_id} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${Columns.admin_fname} TEXT,
        ${Columns.admin_lname} TEXT,
        ${Columns.email} TEXT,
        ${Columns.password} TEXT,
        ${Columns.phoneno} TEXT,
        ${Columns.address} TEXT,
        ${Columns.pincode} TEXT
        );
    """.trimIndent()

    //Insertion of data in the table
    fun insert(db: SQLiteDatabase, reg: Register) {
        val row = ContentValues()
        row.put(Columns.admin_fname, reg.fname)
        row.put(Columns.admin_lname, reg.lname)
        row.put(Columns.email, reg.email)
        row.put(Columns.password, reg.password)
        row.put(Columns.phoneno, reg.phoneno)
        row.put(Columns.address,reg.address)
        row.put(Columns.pincode,reg.pincode)

        db.insert(Table_Name, null, row)
    }

    // This function will get all the queries
    fun getAll(db: SQLiteDatabase): ArrayList<Register> {
        val registers = ArrayList<Register>()

        //Here below c is cursor that will signifies where current column is active
        val c = db.query(
            Table_Name, arrayOf(
                Columns.admin_fname, Columns.admin_lname,
                Columns.email, Columns.password, Columns.phoneno,
                Columns.address,Columns.pincode
            ), null, null, null, null, null
        )

        //This will simply iterate until all the data is reterieved
        while (c.moveToNext()) {
            val records = Register(
                c.getString(1),c.getString(2), c.getString(3), c.getString(4),
                c.getString(5), c.getString(6), c.getString(7),
            )
            registers.add(records)
        }
        return registers
    }
}