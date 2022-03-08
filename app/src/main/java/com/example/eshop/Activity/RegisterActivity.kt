package com.example.eshop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eshop.DBHelper
import com.example.eshop.Models.DBregister
import com.example.eshop.Models.Register
import com.example.eshop.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val db= DBHelper(this).writableDatabase


        registerBtn.setOnClickListener {
            val newRecord=Register(etFname.text.toString(),etLname.text.toString(),etEmail.text.toString(),
                etPass.text.toString(),etPhoneno.text.toString(),etAddress.text.toString(),etPin.text.toString())

            db?.execSQL(DBregister.insert(db,newRecord).toString())

            Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}